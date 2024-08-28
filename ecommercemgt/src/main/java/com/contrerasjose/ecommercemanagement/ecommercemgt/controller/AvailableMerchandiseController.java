package com.contrerasjose.ecommercemanagement.ecommercemgt.controller;

import com.contrerasjose.ecommercemanagement.ecommercemgt.entity.AvailableMerchandise;
import com.contrerasjose.ecommercemanagement.ecommercemgt.entity.MyMerchandiseList;
import com.contrerasjose.ecommercemanagement.ecommercemgt.service.AvailableMerchandiseService;
import com.contrerasjose.ecommercemanagement.ecommercemgt.service.MyMerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile; // Added import for MultipartFile
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException; // Added import for IOException
import java.nio.file.Files; // Added import for Files
import java.nio.file.Path; // Added import for Path
import java.nio.file.Paths; // Added import for Paths
import java.util.*;

@Controller
public class AvailableMerchandiseController {

    @Autowired
    private AvailableMerchandiseService service;

    @Autowired
    private MyMerchandiseService myMerchandiseService;

    private static String UPLOAD_DIR = "src/main/resources/static/images/"; // Updated directory for storing uploaded images

    // Home page mapping
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // Mapping for New Merchandise Register page
    @GetMapping("/New_Merchandise_Register")
    public String newMerchandiseForm(Model model) {
        model.addAttribute("availableMerchandise", new AvailableMerchandise());
        return "NewMerchandiseRegister";
    }

    // Mapping to show all available merchandise
    @GetMapping("/Available_Merchandise")
    public ModelAndView getAllMerchandise() {
        List<AvailableMerchandise> list = service.getAllAvailableMerchandise();
        return new ModelAndView("merchandiseList", "AvailableMerchandise", list);
    }

    // Updated Mapping to handle form submission for adding a new merchandise with image upload
    @PostMapping("/save")
    public String addAvailableMerchandise(@ModelAttribute AvailableMerchandise m, @RequestParam("image") MultipartFile file) {
        try {
            // Save the file locally if it's not empty
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
                Files.write(path, bytes);
                m.setImageName(file.getOriginalFilename()); // Set the image name in the entity
            }
            service.save(m); // Save the merchandise to the database
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception if the file operation fails
        }
        return "redirect:/Available_Merchandise"; // Redirect to the list of available merchandise
    }


    // Mapping to show user's merchandise list
    @GetMapping("/My_Merchandise")
    public String getMyMerchandise(Model model) {
        List<MyMerchandiseList> list = myMerchandiseService.getAllMyMerch();
        model.addAttribute("merchandise", list);
        System.out.println("Number of items in My Merchandise: " + list.size());
        return "myMerchandise";
    }

    // Mapping to add an item to my merchandise list by id
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        AvailableMerchandise m = service.getAvailableMerchandiseById(id);
        if (m != null) {
            MyMerchandiseList ml = new MyMerchandiseList(m.getId(), m.getName(), m.getBrand(), m.getCategory(), m.getPrice(), m.getQuantity(), m.getSize(), m.getImageName());
            myMerchandiseService.saveMyMerch(ml);
            System.out.println("Added to My Merchandise: " + ml.getName()); // Debug statement
        } else {
            System.out.println("Item not found with ID: " + id); // Debug statement
        }
        return "redirect:/My_Merchandise"; // Redirect to the My Merchandise page
    }

    // Mapping to edit an existing merchandise item by id
    @RequestMapping("/editMerchandise/{id}")
    public String editMerchandise(@PathVariable("id") int id, Model model) {
        AvailableMerchandise m = service.getAvailableMerchandiseById(id);
        if (m != null) {
            model.addAttribute("availableMerchandise", m);
            return "merchandiseEdit";
        }
        return "redirect:/Available_Merchandise"; // Redirect if merchandise not found
    }

    // Mapping to delete a merchandise item by id
    @RequestMapping("/deleteMerchandise/{id}")
    public String deleteMerchandise(@PathVariable("id") int id) {
        service.deletedById(id);
        return "redirect:/Available_Merchandise";
    }
}
