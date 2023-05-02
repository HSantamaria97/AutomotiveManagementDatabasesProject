package com.databases.project.AutoServiceManagerAPI.Service;

import com.databases.project.AutoServiceManagerAPI.Entity.Role;
import com.databases.project.AutoServiceManagerAPI.Entity.User;
import com.databases.project.AutoServiceManagerAPI.Repository.UserRepository;
import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(long Id){
        return userRepository.getUserById(Id);
    }
    public User getUserByUsername( String username)
    {
       return userRepository.getUserByUsername(username);
    }

    public List<User> getUserByRole(String role)
    {
        return userRepository.getUserByRole(role);
    }
    public void createNewUser(String email,
                              String firstName,
                              String lastName,
                              String username,
                              String password,
                              String phoneNumber,
                              String role)
    {
        User user = User.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .username(username)
                .password(new BCryptPasswordEncoder().encode(password))
                .phoneNumber(phoneNumber)
                .role(Role.builder().roleName(role).build())
                .build();
        userRepository.save(user);
    }
    public void updateUserInfo(long id,String firstName, String lastName,String username, String password, String email, String phoneNumber, String role){
        if(!Strings.isNullOrEmpty(firstName))
            userRepository.updateUserFirstName(firstName,id);
        if(!Strings.isNullOrEmpty(lastName))
            userRepository.updateUserLastName(lastName,id);
        if(!Strings.isNullOrEmpty(username))
            userRepository.updateUserUsername(username,id);
        if(!Strings.isNullOrEmpty(password))
            userRepository.updateUserPassword(new BCryptPasswordEncoder().encode(password),id);
        if(!Strings.isNullOrEmpty(email))
            userRepository.updateUserEmail(email,id);
        if(!Strings.isNullOrEmpty(phoneNumber))
            userRepository.updateUserPhoneNumber(phoneNumber,id);
        if(!Strings.isNullOrEmpty(role)) {
            User user = userRepository.getUserById(id);
            user.getRole().setRoleName(role);
            userRepository.save(user);
        }
    }
    public void deleteUserById(long id)
    {
        userRepository.deleteUserById(id);
    }
}
