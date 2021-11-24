## The objective of this project was to develop a functionality through which customers of an online store can place orders.

The API is developed using Java(JDK 11),Spring(MVC,REST,JPA) and PostgreSQL Database.

## What You Will Need?

- Java 11
- Mysql
- Maven
- Embedded Tomcat
- Postman REST Services Client


## PostgreSQL credential change
-- change PostgreSQL credentials(url,username and password) in the application.properties file.

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
        "itemName": "Product1",
        "quantity": 2,
        "products": {
        	"id": 102,
        	"name": "Product1",
        	"price": 0,
        }
	}
]
```
## Insert Product (demo)
```
{
    "id": 104,
    "name": Product1",
    "price": 200.23,
}
```
