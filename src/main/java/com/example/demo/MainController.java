package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/user")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        userRepository.save(user);
        return "SAVED";
    }

    @PutMapping(path = "/user/{id}")
    public @ResponseBody String updateUser(@RequestBody User user, @PathVariable("id") Integer id){
        user.setId(id);
        userRepository.save(user);
        return "UPDATED";
    }

    @DeleteMapping(path = "user/{id}")
    public @ResponseBody String deletUser(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
        return "DELETED";
    }


    @GetMapping(path = "/user")
    public @ResponseBody Iterable<User> getAllUser(){
        return userRepository.findAll();
    }
}
