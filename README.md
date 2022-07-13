# Points Store
# JWT Token generate

```
Token= HMAC256(user_id+user_name+Current date+A Private Key String);
```

# OpenAPI


## Update user info

```
url: http://127.0.0.1:8081/UpdateUser
method: post
header: token
body: {
  "id": "24",
  "user_email": "a@ait.ie",
  "user_password": "qwe",
  "user_name": "a@ait.ie",
  "user_phone": "870647175",
  "user_role": "staff",
  "points": "40"
}
return:  {
    "msg": "successfully",
    "state": true
}
```

# API


## Login

```
url: http://127.0.0.1:8081/Login
method: get
Param: ?username=admin&password=123456
return:  {"msg":"Successful login","role":"staff","user_id":24,"state":true,"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjI0IiwiZXhwIjoxNjU3MjAxOTU3LCJ1c2VybmFtZSI6ImFAYWl0LmllIn0.o84A2zytlYJ34RqfefeKG7Y_HvC_DX59FGewAWCqnWA","points":40}
```

## Sign up

```
url: http://127.0.0.1:8081/InsertUser
method: post
body: {"user_email":"","user_name":""}
return:  {
    "msg": "successfully",
    "state": true
}
```

## Get Users List

```
url: http://127.0.0.1:8081/AllUsers
method: get
header: token
Param: 
return:  {
    "msg": "successfully",
    "state": true,
    "users":[]
}
```


## Get user by Id

```
url: http://127.0.0.1:8081/GetUser/{id}
method: get
header: token
Param:
return:  {
    "msg": "successfully",
    "state": true,
    "user":{}
}
```



## Update user info

```
url: http://127.0.0.1:8081/UpdateUser
method: post
header: token
body: {
  "id": "24",
  "user_email": "a@ait.ie",
  "user_password": "qwe",
  "user_name": "a@ait.ie",
  "user_phone": "870647175",
  "user_role": "staff",
  "points": "40"
}
return:  {
    "msg": "successfully",
    "state": true
}
```


## Delete user by Id

```
url: http://127.0.0.1:8081/deleteUser/{id}
method: delete
header: token
Param:
return: {
    "msg": "successfully",
    "state": true
}
```


## Get Gifts List

```
url: http://127.0.0.1:8081/AllGifts
method: get
header: token
Param: 
return:  {
    "msg": "successfully",
    "state": true,
    "gifts":[]
}
```
## Get user by Id

```
url: http://127.0.0.1:8081/GetGift/{id}
method: get
header: token
Param:
return:  {
    "msg": "successfully",
    "state": true,
    "gift":{}
}
```


## New a gift

```
url: http://127.0.0.1:8081/InsertGift
method: post
body: {"user_email":"","user_name":""}
return:  {
    "msg": "successfully",
    "state": true
}
```




## Update gift info

```
url: http://127.0.0.1:8081/UpdateGift
method: post
header: token
body: {
  "id": "",
  "name": "napkin",
  "info": "A napkin",
  "price": "10",
  "stock": "5",
  "pic": "tissues.png"
}
return:  {
    "msg": "successfully",
    "state": true
}
```


## Delete gift by Id

```
url: http://127.0.0.1:8081/deleteGift/{id}
method: delete
header: token
Param:
return: {
    "msg": "successfully",
    "state": true
}
```



## Exchange the gifts by points blance

```
url: http://127.0.0.1:8081/Exchange
method: post
header: token
body: [
  {
    "gift_id": 4,
    "user_id": "24",
    "qty": 1,
    "amount": 40,
    "time": "2022/7/6 14:49:36",
    "address": "101 willow park",
    "delivery": "Standard-Delivery- €5.00"
  }
]
return:  {
    "msg": "successfully",
    "state": true
}
```



# Mysql

```


DROP TABLE IF EXISTS `tb_ogranization`;
CREATE TABLE `tb_ogranization` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `state` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_ogranization
-- ----------------------------
INSERT INTO `tb_ogranization` VALUES ('1', 'TUS', '11020', 'Athlone', 'School', '1');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  `points` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('0', 'Chen', 'a@ait.com', '0872471060', 'qwe', 'user', '2');
INSERT INTO `tb_user` VALUES ('1', 'Chen', 'b@ait.com', '870647175', 'qwe', 'user', '130');
INSERT INTO `tb_user` VALUES ('24', 'a@ait.ie', 'a@ait.ie', '870647175', 'qwe', 'staff', '3');
INSERT INTO `tb_user` VALUES ('25', 'ad@qq.com', 'ad@qq.com', '870647175', 'qwe', 'user', '0');

-- ----------------------------
-- Table structure for tb_gifts
-- ----------------------------
DROP TABLE IF EXISTS `tb_gifts`;
CREATE TABLE `tb_gifts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `info` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_gifts
-- ----------------------------
INSERT INTO `tb_gifts` VALUES ('0', 'napkin', 'A napkin', '108', '50', 'tissues.png');
INSERT INTO `tb_gifts` VALUES ('1', 'cups', 'A set of white cups 4pcs', '20', '10', 'cups.png');
INSERT INTO `tb_gifts` VALUES ('2', 'toy car', 'A cute plastic toy cars', '4', '60', 'car.png');
INSERT INTO `tb_gifts` VALUES ('3', 'toy bear', 'A cute stuffed bear toy', '3', '45', 'toy.png');
INSERT INTO `tb_gifts` VALUES ('4', 'pixar', 'An authentic Buzz Lightyear toy', '40', '0', 'pixar.png');
INSERT INTO `tb_gifts` VALUES ('5', 'plate', 'A beautiful dish', '30', '4', 'plate.png');
INSERT INTO `tb_gifts` VALUES ('6', 'teddy', 'A tedyy toy', '10', '10', 'tedyy.png');
INSERT INTO `tb_gifts` VALUES ('31', 'tableware', 'A set of white tableware', '20', '5', 'tableware.png');
INSERT INTO `tb_gifts` VALUES ('32', 'phone', 'A cute plastic toy phone', '30', '6', 'phone.png');
INSERT INTO `tb_gifts` VALUES ('33', 'fork', 'A set of forks', '40', '5', 'fork.png');
INSERT INTO `tb_gifts` VALUES ('34', 'coffecup', 'A beautiful coffe cup', '40', '5', 'coffecup.png');
INSERT INTO `tb_gifts` VALUES ('35', 'plate', 'A beautiful dish', '30', '5', 'plate.png');
INSERT INTO `tb_gifts` VALUES ('36', 'napkin', 'A napkin', '10', '10', 'tissues.png');
INSERT INTO `tb_gifts` VALUES ('37', 'cupse', 'A set of white cups 4pcse', '20', '5', 'cups.png');
INSERT INTO `tb_gifts` VALUES ('38', 'toy car', 'A cute plastic toy car', '30', '6', 'car.png');
INSERT INTO `tb_gifts` VALUES ('39', 'toy bear', 'A cute stuffed bear toy', '40', '5', 'toy.png');
INSERT INTO `tb_gifts` VALUES ('40', 'pixar', 'An authentic Buzz Lightyear toy', '40', '5', 'pixar.png');
INSERT INTO `tb_gifts` VALUES ('41', 'plate', 'A beautiful dish', '30', '5', 'plate.png');
INSERT INTO `tb_gifts` VALUES ('42', 'napkin', 'A napkin', '10', '10', 'tissues.png');
INSERT INTO `tb_gifts` VALUES ('43', 'cupse', 'A set of white cups 4pcse', '20', '5', 'cups.png');
INSERT INTO `tb_gifts` VALUES ('44', 'toy car', 'A cute plastic toy car', '30', '6', 'car.png');
INSERT INTO `tb_gifts` VALUES ('45', 'toy bear', 'A cute stuffed bear toy', '40', '5', 'toy.png');
INSERT INTO `tb_gifts` VALUES ('46', 'pixar', 'An authentic Buzz Lightyear toy', '40', '5', 'pixar.png');

-- ----------------------------
-- Table structure for tb_exchange_his
-- ----------------------------
DROP TABLE IF EXISTS `tb_exchange_his`;
CREATE TABLE `tb_exchange_his` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gift_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `qty` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `time` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `delivery` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_exchange_his
-- ----------------------------
INSERT INTO `tb_exchange_his` VALUES ('14', '3', '1', '1', '40', '2022/6/30 22:14:28', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('15', '1', '1', '1', '20', '2022/6/30 22:16:23', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('17', '1', '1', '1', '20', '2022/7/2 11:12:51', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('18', '3', '1', '1', '40', '2022/7/2 11:12:51', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('19', '1', '2', '1', '20', '2022/7/2 11:15:53', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('20', '3', '2', '1', '40', '2022/7/2 11:15:53', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('21', '1', '2', '1', '20', '2022/7/3 20:45:15', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('22', '2', '2', '1', '30', '2022/7/3 20:45:15', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('23', '1', '1', '1', '20', '2022/7/3 21:6:4', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('24', '2', '1', '1', '30', '2022/7/3 21:6:4', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('25', '1', '1', '1', '20', '2022/7/3 21:11:15', '', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('26', '1', '1', '1', '20', '2022/7/3 21:24:50', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('27', '1', '1', '1', '20', '2022/7/3 21:25:51', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('28', '1', '1', '1', '20', '2022/7/3 21:27:7', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('29', '1', '1', '1', '20', '2022/7/3 21:27:50', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('30', '5', '1', '1', '30', '2022/7/3 21:41:21', '', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('31', '1', '2', '1', '20', '2022/7/3 21:45:54', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('32', '1', '24', '2', '40', '2022/7/5 23:5:51', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('33', '2', '24', '1', '0', '2022/7/5 23:7:13', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('34', '4', '24', '1', '40', '2022/7/6 14:49:36', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('35', '1', '0', '1', '20', '2022/7/13 13:4:29', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('36', '2', '0', '1', '4', '2022/7/13 13:4:29', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('37', '1', '0', '1', '20', '2022/7/13 13:8:47', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('38', '2', '0', '1', '4', '2022/7/13 13:8:47', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('39', '1', '24', '1', '20', '2022/7/13 21:9:38', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('40', '5', '24', '4', '80', '2022/7/13 21:9:38', '101 willow park', 'Standard-Delivery- €5.00');
INSERT INTO `tb_exchange_his` VALUES ('41', '4', '24', '4', '160', '2022/7/13 21:14:35', '101 willow park', 'Standard-Delivery- €5.00');


```
