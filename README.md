# Simple Product Management Apps
 
Consists of 3 Main Services:
1. product-service : Service that serves to add products, edit, and delete
2. stock-service : A service that functions for stock management of each product that has been registered, in this scope only includes adding stock
3. order-service : Service that serves to manage product orders

# Datastore
The datastore used by the project:
H2-DB (In Memory Database)


# API Contract

1. To add a product
```
Example:
POST http://localhost:8080/product
{
    "productName" : "Botol Minum",
    "productPrice" : 100000
}
```

2. To add stock
```
Example:
POST http://localhost:8082/stock
{
    "productId" : "1",
    "productQuantity" : 50
}
```

3. Place an order for a product
```
Example:
POST http://localhost:8081/order
{
    "productId" : 1,
    "orderQuantity" : 6
}
```
4. Show product details
```
GET http://localhost:8080/product/1
```
5. Display product stock based on Product ID 
```
GET http://localhost:8082/stock/1
```

# How To Run 
Through IntelliJ Idea IDE 

```
Open Project using IntelliJ Idea, then go to Services Tab
```
![image](https://user-images.githubusercontent.com/23337562/193455802-d5dd7492-ab1a-4e67-9653-6d516f49e235.png)
```
Right-click on Service ProductserviceApplication, then click Run
```
![image](https://user-images.githubusercontent.com/23337562/193455917-82650370-37c8-4499-add9-e3659e860451.png)

![image](https://user-images.githubusercontent.com/23337562/193455947-bdc100c5-cc8d-40b6-bcae-6070f78b9a39.png)
```
Do the same for Service OrderserviceApplicate,StockserviceApplication.
Make sure the three services are running normally according to the picture below
```
![image](https://user-images.githubusercontent.com/23337562/193457873-4dd7961b-acb5-469d-afea-ef276c5565ec.png)


# Sample

```
Adding a New Product, the new product is registered with Product ID = 1
```
![image](https://user-images.githubusercontent.com/23337562/193456200-149b1b53-8f9d-40bf-905b-51c8c363d785.png)
```
New products have been entered into the database
```
![image](https://user-images.githubusercontent.com/23337562/193457357-35385a71-4370-406a-ae06-5fcb4272f687.png)
```
Added stock from Product ID 1, as much as 50
```
![image](https://user-images.githubusercontent.com/23337562/193456228-d85b66f7-fedb-4b18-aeb1-9cc1e06aeb19.png)
```
The stock has been entered into the database
```
![image](https://user-images.githubusercontent.com/23337562/193457413-8db5cbdd-dc6c-4a7e-8a62-79395a772bb5.png)
```
Ordering 100 Product ID 1, the application responds "Not Enough Stock".
Because the order quantity is more than the stock quantity
```
![image](https://user-images.githubusercontent.com/23337562/193456291-2b59e3db-eb88-4540-8cc0-7222ce19eb7f.png)
```
Order Product ID 1, as much as 30
Because the order quantity is less than the stock quantity, the Product order is successful
```
![image](https://user-images.githubusercontent.com/23337562/193457461-bcd96b20-996d-4775-865b-ee827f5cdc2a.png)
```
Product orders are entered into the database
```
![image](https://user-images.githubusercontent.com/23337562/193458481-8fcc8c5e-882b-442d-85f0-82d649accc92.png)


