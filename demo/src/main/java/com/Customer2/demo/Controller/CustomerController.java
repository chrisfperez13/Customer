package com.Customer2.demo.Controller;

import com.Customer2.demo.Model.Customer;
import com.Customer2.demo.Repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping("/list") // can change to anything here
    public List<Customer> list(){
        return this.customerRepository.findAll();
    }

    @PostMapping("/create")
        public Customer create(@RequestBody Customer customer){ //request body
        return this.customerRepository.save(customer);
    }

    @PutMapping("/update/{id}")
        public void update(@RequestBody Customer customerInput,@PathVariable Long id){
        Customer customer = this.customerRepository.findById(id).get();
        customer.setFirstName(customerInput.getFirstName());
        customer.setLastName(customerInput.getLastName());
        this.customerRepository.save(customer); //.save() comes from the jra that we extended in the class
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Customer customer){
        this.customerRepository.delete(customer);
    }

    @GetMapping("/list/id/{id}")
    public Customer listId(@PathVariable Long id){
        return this.customerRepository.findById(id).get();

    }


}
