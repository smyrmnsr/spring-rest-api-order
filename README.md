## spring-rest-api-order


## What You Will Need?

- Java 11
- Mysql
- Maven
- Embedded Tomcat
- Postman REST Services Client


## MySql credential change
-- change MySql credential (user name and password)

## URLs (Products)
-- http://localhost:8080/api/products
  * end points (/{id},/save,/delete/{id},)
## URLs (Orders)
-- http://localhost:8080/api/order/
  * end points (/create)
## Place Order
```
[
	{
        "itemName": "Furniture",
        "quantity": 20,
        "userEmail": "dasdipak99@gmail.com",
        "product": {
        	"productId": 102,
        	"name": "",
        	"price": 0,
        	"quantity": 0
        }
	}
]
```
## Insert Item (demo)
```
{
    "id": 104,
    "name": "Computer",
    "price": 20000.23,
    "quantity": 105
}
```
