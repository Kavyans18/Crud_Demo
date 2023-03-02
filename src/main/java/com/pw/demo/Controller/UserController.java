package com.pw.demo.Controller;

import com.pw.demo.Dto.User;
import com.pw.demo.Service.UserService;
import com.pw.demo.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping()
    public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
       return service.saveUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user,@PathVariable int id) {
        return service.updateUser(user, id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<User>> getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @GetMapping()
    public ResponseEntity<ResponseStructure<List<User>>>getAllUser(){
        return service.getAllUser();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<User>> deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }

}
