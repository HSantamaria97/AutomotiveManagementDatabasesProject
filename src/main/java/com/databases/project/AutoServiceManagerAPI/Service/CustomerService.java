package com.databases.project.AutoServiceManagerAPI.Service;

import com.databases.project.AutoServiceManagerAPI.Entity.Customer;
import com.databases.project.AutoServiceManagerAPI.Repository.CustomerRepository;
import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomerById(long id)
    {
        return customerRepository.getCustomerById(id);
    }
    public Customer getCustomerByFirstAndLastName(String firstName, String LastName)
    {
        return customerRepository.getCustomerByName(firstName, LastName);
    }
    public void updateCustomerInfo(String firstname, String lastName, String email, String phoneNumber, long id)
    {
        if(!Strings.isNullOrEmpty(firstname))
            customerRepository.updateCustomerFirstName(firstname, id);
        if(!Strings.isNullOrEmpty(lastName))
            customerRepository.updateCustomerLastName(lastName, id);
        if(!Strings.isNullOrEmpty(email))
            customerRepository.updateCustomerEmail(email, id);
        if(!Strings.isNullOrEmpty(phoneNumber))
            customerRepository.updateCustomerPhoneNumber(phoneNumber, id);
    }
    public void createCustomer(String firstname, String lastName, String email, String phoneNumber)
    {
        Customer customer = Customer.builder()
                                    .firstName(firstname)
                                    .lastName(lastName)
                                    .email(email)
                                    .phoneNumber(phoneNumber)
                                    .build();
        customerRepository.save(customer);
    }
    public void deleteCustomerById(long id)
    {
        customerRepository.deleteCustomerById(id);
    }
    public List<Customer> getAllCustomers(){return customerRepository.getAllCustomers();}

}
