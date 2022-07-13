package com.tus.pointsstore.Controller;

import com.tus.pointsstore.Mapper.GiftMapper;
import com.tus.pointsstore.Model.Gift;
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
public class GiftController {

    @Autowired
    private GiftMapper giftMapper;

    @GetMapping("/AllGifts")
    public ResponseEntity<List<Gift>> findAll() {
        List<Gift> list = giftMapper.findAll();
        return new ResponseEntity<List<Gift>>(list, HttpStatus.OK);
    }

    @GetMapping("/GetGift/{id}")
    public Gift getUserById(@PathVariable int id) throws NotFoundException {
        return giftMapper.findById(id);
    }


    @PostMapping("/InsertGift")
    public Object insert(@RequestBody Gift user) {
        Map<String, Object> map = new HashMap<>();
        // Check if user email is already in use

        // if email doesn't already exist, add user
        giftMapper.insert(user);
        map.put("state", true);
        map.put("msg", "Sign up successfully");

        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @PostMapping("/UpdateGift")
    public Object update(@RequestBody Gift user) {
        Map<String, Object> map = new HashMap<>();
        // Check if user email is already in use

        // if email doesn't already exist, add user
        giftMapper.update(user);
        map.put("state", true);
        map.put("msg", "Sign up successfully");

        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @DeleteMapping("/deleteGift/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        giftMapper.deleteById(id);
        return new ResponseEntity<>("User with id " + id + " deleted", HttpStatus.OK);

    }

}

