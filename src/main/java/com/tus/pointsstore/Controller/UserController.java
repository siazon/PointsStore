package com.tus.pointsstore.Controller;

import com.tus.pointsstore.Common.JwtTokenUtil;
import com.tus.pointsstore.Mapper.UserMapper;
import com.tus.pointsstore.Model.LoginUserData;
import com.tus.pointsstore.Model.User;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class contains all REST enpoints to create, read, update, delete and login a user.
 */

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // Get all users
    @GetMapping("/AllUsers")
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userMapper.findAll();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    // Get one user by user id
    @GetMapping("/GetUser/{id}")
    public User getUserById(@PathVariable int id) throws NotFoundException {
        return userMapper.findById(id);
//                if (userMapper.findById(id) != null) {
//                    throw new NotFoundException("User with Id " + id + " does not exist.");
    }


    // Create a new user
    @PostMapping("/InsertUser")
    public Object insert(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        // Check if user email is already in use
        List<User> list = userMapper.findAll();
        String userEmail;

        boolean isExist = false;
        for (int i = 0; i < list.size(); i++) {
            userEmail = list.get(i).getUser_email();
            if (user.getUser_email().equalsIgnoreCase(userEmail)) {
                isExist = true;
            }

            // Create User Roles. Every admin will have the email extension - "garbagesorting.com".
            if (user.getUser_email().contains("ait.ie")) {
                user.setUser_role("staff");
            } else {
                user.setUser_role("user");
            }
        }
        if (!isExist) {
            // if email doesn't already exist, add user
            userMapper.insert(user);
            map.put("state", true);
            map.put("msg", "Sign up successfully");
            //return user;
        } else {
            map.put("state", false);
            map.put("msg", "Email address already exists");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    // Update a new user
    @PostMapping("/UpdateUser")
    public Object update(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();

        // if email doesn't already exist, add user
        userMapper.update(user);
        map.put("state", true);
        map.put("msg", "Sign up successfully");
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @PostMapping("/Login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginUserData userData) {

        Map<String, Object> map = new HashMap<>();
        User userDB = null;
        try {
            userDB = userMapper.findByEmail(userData.getEmail());
        } catch (Exception ex) {
            map.put("state", false);
            map.put("msg", "username or password does not exist");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }
        // Validate email and password
        if (userData.getEmail() == "" || userData.getPassword() == "") {
            map.put("state", false);
            map.put("msg", "username or password cannot be empty");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }

        // Check if email and password stored in database matches with email and password provided.
        if (userDB.getUser_password().equals(userData.getPassword())) {
            Map<String, String> payload = new HashMap<>();
            payload.put("id", String.valueOf(userDB.getId()));
            payload.put("username", userDB.getUser_name());
            String token = JwtTokenUtil.getToken(payload);
            map.put("state", true);
            map.put("msg", "Successful login");// back token
            map.put("token", token);
            map.put("role", userDB.getUser_role());
            map.put("points", userDB.getpoints());
            map.put("user_id", userDB.getId());
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } else {
            map.put("state", true);
            map.put("msg", "Incorrect username or password");// back token
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable int id) {
//        if (userMapper.findById(id).isEmpty()) {
//            throw new NotFoundException("Patient with ID " + patientId + " does not exist.");
//        }
        Map<String, Object> map = new HashMap<>();
        int res = userMapper.deleteById(id);
        if (res > 0) {
            map.put("state", true);
            map.put("msg", "Successful");// back token
        } else {
            map.put("state", false);
            map.put("msg", "unknow error");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

    }

}

