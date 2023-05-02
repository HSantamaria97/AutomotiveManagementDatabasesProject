package com.databases.project.AutoServiceManagerAPI.Repository;

import com.databases.project.AutoServiceManagerAPI.Entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("select u from customer u")
    List<Customer> getAllCustomers();

    @Query("SELECT u FROM customer u WHERE u.customerId = :customerId")
    Customer getCustomerById(@Param("customerId") long customerId);

    @Query("select u from customer u where u.firstName = :firstName and u.lastName = :lastName" )
    Customer getCustomerByName(@Param("firstName") String firstName, String lastName);

    @Modifying
    @Transactional
    @Query("update customer set firstName = :firstName where customerId = :customerId")
    void updateCustomerFirstName(@Param("firstName") String firstName, @Param("customerId") long customerId );

    @Modifying
    @Transactional
    @Query("update customer set lastName = :lastName where customerId = :customerId")
    void updateCustomerLastName(@Param("lastName") String lastName, @Param("customerId") long customerId );

    @Modifying
    @Transactional
    @Query("update customer set phoneNumber = :phoneNumber where customerId = :customerId")
    void updateCustomerPhoneNumber(@Param("phoneNumber") String phoneNumber, @Param("customerId") long customerId );

    @Modifying
    @Transactional
    @Query("update customer set email = :email where customerId = :customerId")
    void updateCustomerEmail(@Param("email") String email, @Param("customerId") long customerId );

    @Modifying
    @Transactional
    @Query("delete from customer where customerId = :customerId")
    void deleteCustomerById(@Param("customerId") long customerId);

}
