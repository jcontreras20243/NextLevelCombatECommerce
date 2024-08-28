package com.contrerasjose.ecommercemanagement.ecommercemgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contrerasjose.ecommercemanagement.ecommercemgt.entity.AvailableMerchandise;;

@Repository
public interface MerchandiseRepository extends JpaRepository<AvailableMerchandise ,Integer>{
}
