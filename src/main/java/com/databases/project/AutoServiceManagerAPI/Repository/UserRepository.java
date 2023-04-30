package com.databases.project.AutoServiceManagerAPI.Repository;

import com.databases.project.AutoServiceManagerAPI.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

        //Selects
        @Query("SELECT u FROM users u WHERE u.username = :username")
        User getUserByUsername(@Param("username") String username);

//        @Query("select u from users u " +
//                "inner join u.role r " +
//                "where r.name = :role")
//        List<User> getUserByRole(@Param("role") String role);

        @Query("select u from users u where u.userId = :userId")
        User getUserById(@Param("userId") int userId);


}
