package com.example.demo.repository;
import com.example.demo.model.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<customer,Integer> {

}
