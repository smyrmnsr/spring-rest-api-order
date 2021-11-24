## The objective of this project was to develop a functionality through which customers of an online store can place orders.

The API is developed using: 
![JAVA](https://img.shields.io/badge/JAVA-black?style=flat&logo=java&logoColor=orange)
![SPRING](https://img.shields.io/badge/SPRING-black?style=flat&logo=Symfony&logoColor=green)
![POSTGRESQL](https://img.shields.io/badge/POSTGRESQL-black?style=flat&logo=postgresql&logoColor=blue)

## In order for the application to run properly you need the following installed on your system:

- Java 11
- PostgreSQL
- Maven
- Embedded Tomcat

## How to run the application locally
-- Create a new PostgreSQL database and change the application properties (E.g. username/password of DB) present in ``resources/application.properties`` according to your local postgresql-server.

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
