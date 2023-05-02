package com.databases.project.AutoServiceManagerAPI.controller;

import com.databases.project.AutoServiceManagerAPI.Entity.Customer;
import com.databases.project.AutoServiceManagerAPI.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/getCustomer")
    public ResponseEntity<Customer> getCustomerById(long id)
    {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    @GetMapping("/getCustomerByName")
    public ResponseEntity<Customer> getCustomerByName( String firstName,  String lastName)
    {
        return ResponseEntity.ok(customerService.getCustomerByFirstAndLastName(firstName,lastName));
    }
    @PostMapping("/servicemanager/updatecustomerinfo")
    public ResponseEntity<String> updateCustomerInfo( String firstName, String lastName, String email, String phoneNumber, long id)
    {
        customerService.updateCustomerInfo(firstName, lastName, email, phoneNumber, id);
        return ResponseEntity.ok("Customer updated!");
    }

    @PostMapping("/servicemanager/deletecustomer")
    public ResponseEntity<String> deleteCustomerById(long id)
    {
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok("Customer deleted successfully!");
    }
    @PostMapping("/servicemanager/newcustomer")
    public ResponseEntity<String>createNewCustomer(String firstName,String lastName,  String email, String phoneNumber)
    {
        customerService.createCustomer(firstName, lastName, email, phoneNumber);
        return ResponseEntity.ok("Customer created successfully!");
    }
    @GetMapping("/getallcustomers")
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
}
