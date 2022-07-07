# Points Store



# API

## JWT Token generate

```
Token= HMAC256(user_id+user_name+Current date+A Private Key String);
```
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


```
