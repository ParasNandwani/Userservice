# Userservice

Create User Curl

curl --location 'localhost:8080/v1/user' \
--header 'Content-Type: application/json' \
--data '{
    "mobile_number": 9034850345,
    "first_name": "paras",
    "last_name": "nandwani",
    "spending_limit": 0.0,
    "address":[{
        "city":"panipat"
    }]
}'


GetUser

curl --location --request GET 'localhost:8080/v1/user?firstName=para' \
--header 'Content-Type: application/json' \
--data '{
    "mobile_number": 9034850345,
    "first_name": "paras",
    "last_name": "nandwani",
    "spending_limit": 0.0
}'


QueryParam
   ?firstName=para&lastName=Nandwani&city=""
   if none of the parameter is provided then in response will get all the users
  




Second Question

curl --location --request GET 'localhost:8080/v1/customer?strategy=BOTH' \
--header 'Content-Type: application/json' \
--data '{
    "mobile_number": 9034850345,
    "first_name": "paras",
    "last_name": "nandwani",
    "spending_limit": 0.0
}'


Request Param:= 
  strategy = A -> return List A users
  strategy = B -> return List B users
  strategy = BOTH -> return Common in between both



