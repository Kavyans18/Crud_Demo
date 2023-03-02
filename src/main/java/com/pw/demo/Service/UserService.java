package com.pw.demo.Service;

import com.pw.demo.Dao.UserDao;
import com.pw.demo.Dto.User;
import com.pw.demo.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    UserDao dao;

    public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
        ResponseStructure<User> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus(HttpStatus.OK.value());
        responseStructure.setMessage("Success");
        responseStructure.setData(dao.saveUser(user));
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<User>> updateUser(User user, int id) {
        Optional<User> optional = dao.updateUser(user, id);
        ResponseStructure<User> responseStructure = new ResponseStructure<>();
        if(optional.isPresent()) {
            User data = optional.get();
            data.setName(user.getName());
            data.setGender(user.getGender());
            data.setEmail(user.getEmail());
            data.setPhone(user.getPhone());
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("SUCCESS");
            responseStructure.setData(data);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
        Optional<User> optional = dao.getUserById(id);
        ResponseStructure<User> responseStructure = new ResponseStructure<>();
        if(optional.isPresent()) {
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("SUCCESS");
            responseStructure.setData(optional.get());
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ResponseStructure<List<User>>>getAllUser(){
        ResponseStructure<List<User>> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus(HttpStatus.OK.value());
        responseStructure.setMessage("SUCCESS");
        responseStructure.setData(dao.getAllUser());
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
        ResponseStructure<User> responseStructure = new ResponseStructure<>();
        Optional<User> optional = dao.deleteUser(id);
        if(optional.isPresent()) {
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("SUCCESS");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }
    }
}
