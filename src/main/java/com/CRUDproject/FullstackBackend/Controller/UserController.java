package com.CRUDproject.FullstackBackend.Controller;

import com.CRUDproject.FullstackBackend.Exception.UserNotFoundException;
import com.CRUDproject.FullstackBackend.Model.User;
import com.CRUDproject.FullstackBackend.Repository.UserRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));

    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User newUser,@PathVariable Long id){
      return userRepository.findById(id).map(user->{
          user.setUsername(newUser.getUsername());
          user.setName(newUser.getName());
          user.setEmail(newUser.getEmail());
          return userRepository.save(user);
       }).orElseThrow(()->new UserNotFoundException(id));
    }

     @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        else{
            userRepository.deleteById(id);
            return "User with the id "+id+" has been deleted succesfully!!";
        }
     }


}
