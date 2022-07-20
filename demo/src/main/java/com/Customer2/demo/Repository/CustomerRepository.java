package com.Customer2.demo.Repository;

import com.Customer2.demo.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
