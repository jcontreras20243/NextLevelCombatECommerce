package com.contrerasjose.ecommercemanagement.ecommercemgt.repository;

import com.contrerasjose.ecommercemanagement.ecommercemgt.entity.MyMerchandiseList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contrerasjose.ecommercemanagement.ecommercemgt.entity.MyMerchandiseList;

        @Repository
public interface MyMerchandiseRepository extends JpaRepository <MyMerchandiseList, Integer> {
}
