package com.contrerasjose.ecommercemanagement.ecommercemgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contrerasjose.ecommercemanagement.ecommercemgt.entity.AvailableMerchandise;
import com.contrerasjose.ecommercemanagement.ecommercemgt.repository.MerchandiseRepository;

@Service
public class AvailableMerchandiseService {

    @Autowired
    private MerchandiseRepository mRepo;

    public void save (AvailableMerchandise m) {
        mRepo.save(m);
    }

    public List<AvailableMerchandise> getAllAvailableMerchandise(){
        return mRepo.findAll();
    }
    public AvailableMerchandise getAvailableMerchandiseById(int id) {
        return mRepo.findById(id).orElse(null);
    }
public void deletedById(int id){
        mRepo.deleteById(id);
}
}
