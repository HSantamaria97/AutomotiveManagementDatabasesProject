package com.databases.project.AutoServiceManagerAPI.Repository;

import com.databases.project.AutoServiceManagerAPI.Entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


        //Selects
        @Query("SELECT u FROM users u WHERE u.username = :username")
        User getUserByUsername(@Param("username") String username);

        @Query("select u from users u " +
                "inner join u.role r " +
                "where r.roleName = :role")
        List<User> getUserByRole(@Param("role") String role);

        @Query("select u from users u where u.userId = :userId")
        User getUserById(@Param("userId") long userId);

        @Modifying
        @Transactional
        @Query("update users set firstName = :firstName where userId = :userId")
        void updateUserFirstName(@Param("firstName") String firstName, @Param("userId") long userId );

        @Modifying
        @Transactional
        @Query("update users set lastName = :lastName where userId = :userId")
        void updateUserLastName(@Param("lastName") String lastName, @Param("userId") long userId );

        @Modifying
        @Transactional
        @Query("update users set username = :username where userId = :userId")
        void updateUserUsername(@Param("username") String username, @Param("userId") long userId );

        @Modifying
        @Transactional
        @Query("update users set password = :password where userId = :userId")
        void updateUserPassword(@Param("password") String password, @Param("userId") long userId );

        @Modifying
        @Transactional
        @Query("update users set email = :email where userId = :userId")
        void updateUserEmail(@Param("email") String email, @Param("userId") long userId );

        @Modifying
        @Transactional
        @Query("update users set phoneNumber = :phoneNumber where userId = :userId")
        void updateUserPhoneNumber(@Param("phoneNumber") String phoneNumber, @Param("userId") long userId );

        @Modifying
        @Transactional
        @Query("delete from users where userId = :userId")
        void deleteUserById(@Param("userId") long userId);
}
