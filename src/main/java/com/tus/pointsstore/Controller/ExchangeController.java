package com.tus.pointsstore.Controller;

import com.tus.pointsstore.Mapper.ExchangeMapper;
import com.tus.pointsstore.Mapper.GiftMapper;
import com.tus.pointsstore.Mapper.UserMapper;
import com.tus.pointsstore.Model.Exchange_his;
import com.tus.pointsstore.Model.Exchange_info;
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
public class ExchangeController {

    @Autowired
    private ExchangeMapper exchangeMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GiftMapper giftMapper;

    @GetMapping("/AllHis")
    public ResponseEntity<List<Exchange_his>> findAll() {
        List<Exchange_his> list = exchangeMapper.findAll();
        return new ResponseEntity<List<Exchange_his>>(list, HttpStatus.OK);
    }

    @GetMapping("/GetHis/{id}")
    public Exchange_his getUserById(@PathVariable int id) throws NotFoundException {
        return exchangeMapper.findById(id);
//                if (userMapper.findById(id) != null) {
//                    throw new NotFoundException("User with Id " + id + " does not exist.");
    }

    @PostMapping("/GetExInfo")
    public List<Exchange_info> getInfoByEmail(@RequestBody String data) throws NotFoundException {
        String s = data.replaceAll("[{}\"]", "");
        System.out.println(s);
        String[] strings = s.split(":");
        System.out.println(strings[1]);

        List<Exchange_info> infos = exchangeMapper.findAllInfo(strings[1]);
        return infos;

    }

    @PostMapping("/InsertHis")
    public Object insert(@RequestBody Exchange_his his) {
        Map<String, Object> map = new HashMap<>();
        // Check if user email is already in use

        // if email doesn't already exist, add user
        exchangeMapper.insert(his);
        map.put("state", true);
        map.put("msg", "Sign up successfully");
        //return user;

        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @PostMapping("/Exchange")
    public Object Exchange(@RequestBody List<Exchange_his> his) {
        Map<String, Object> map = new HashMap<>();

        //check if have enough stock
//        Gift gift = giftMapper.findById(his.getGift_id());
//        if (gift != null && gift.getStock() > his.getQty()) {
//            int amount = his.getQty() * gift.getPrice();
//            //check if have enough points
//            User user = userMapper.findById(his.getUser_id());
//            if (user != null && user.getpoints() > amount) {
//
//            } else {
//                map.put("state", false);
//                map.put("msg", "Insufficient number of points");
//            }
//        } else {
//            map.put("state", false);
//            map.put("msg", "Inventory shortage");
//        }
        // if email doesn't already exist, add user

        try {
            exchangeMapper.exchange(his);
            map.put("state", true);
            map.put("msg", "Exchange successfully");
        } catch (Exception ex) {
            map.put("state", false);
            map.put("msg", "Exchange Error");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @DeleteMapping("/deleteHis/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
//        if (userMapper.findById(id).isEmpty()) {
//            throw new NotFoundException("Patient with ID " + patientId + " does not exist.");
//        }
        exchangeMapper.deleteById(id);
        return new ResponseEntity<>("User with id " + id + " deleted", HttpStatus.OK);

    }

}

