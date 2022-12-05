package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Contact;

public interface PrendasRepository extends JpaRepository<Prendas, Integer>, JpaSpecificationExecutor<Prendas> {

}
