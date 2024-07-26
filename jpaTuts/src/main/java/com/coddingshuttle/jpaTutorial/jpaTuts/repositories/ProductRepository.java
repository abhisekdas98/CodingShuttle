package com.coddingshuttle.jpaTutorial.jpaTuts.repositories;

import com.coddingshuttle.jpaTutorial.jpaTuts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByTitleAndOrderByPrice(String mazza);
}
