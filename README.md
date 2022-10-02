# Microservice Sederhana
 
Terdiri dari 3 Service :
1. product-service : Service yang berfungsi untuk menambahkan product,edit,dan delete
2. stock-service : Service yang berfungsi untuk menambahkan stock dari setiap product yang sudah didaftarkan
3. order-service : Service yang berfungsi untuk melalukan order product berdasarkan stock yang tersedia

# Tahapan Payload

1. Add Product
```
POST http://localhost:8080/product
{
    "productName" : "Botol Minum",
    "productPrice" : 100000
}
```

2. Add Stock
```
POST http://localhost:8082/stock
{
    "productId" : "1",
    "productQuantity" : 50
}
```

3. Order Barang
```
POST http://localhost:8081/order
{
    "productId" : 1,
    "orderQuantity" : 6
}
```
