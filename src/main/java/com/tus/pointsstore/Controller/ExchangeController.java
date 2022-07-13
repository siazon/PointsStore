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


    @GetMapping("/GetHis/{id}")
    public Exchange_his getUserById(@PathVariable int id) throws NotFoundException {
        return exchangeMapper.findById(id);
    }

    @PostMapping("/GetExInfo")
    public List<Exchange_info> getInfoByEmail(@RequestBody String data) throws NotFoundException {
        String s = data.replaceAll("[{}\"]", "");
        System.out.println(s);
        String[] strings = s.split(":");
        System.out.println(strings[1]);

        var infos = exchangeMapper.findAllInfo(strings[1]);
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
        try {
            int res = exchangeMapper.exchange(his);
            if (res >= 3) {
                map.put("state", true);
                map.put("msg", "Exchange successfully");
            } else if (res == -1) {
                map.put("state", false);
                map.put("msg", "Your points balance is not enough");
            } else {
                map.put("state", false);
                map.put("msg", "Exchange Error");
            }
        } catch (Exception ex) {
            map.put("state", false);
            map.put("msg", "Exchange Error");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @DeleteMapping("/deleteHis/{id}")
    public ResponseEntity<String> deleteHis(@PathVariable int id) {
        exchangeMapper.deleteById(id);
        return new ResponseEntity<>("User with id " + id + " deleted", HttpStatus.OK);

    }

}

