# Simple Product Management Apps
 
Consists of 3 Main Services:
1. product-service : Service yang berfungsi untuk menambahkan produk,edit,dan delete
2. stock-service : Service yang berfungsi untuk management stok dari setiap produk yang sudah didaftarkan,pada scope ini hanya mencakup menambahkan stok
3. order-service : Service yang berfungsi untuk mengelola pemesanan produk

# Datastore
Datastore yang digunakan project:
H2-DB (In Memory Database)


# API Contract

1. Add Product: Untuk menambahkan produk
```
Example:
POST http://localhost:8080/product
{
    "productName" : "Botol Minum",
    "productPrice" : 100000
}
```

2. Add Stock: Untuk menambahkan stok
```
Example:
POST http://localhost:8082/stock
{
    "productId" : "1",
    "productQuantity" : 50
}
```

3. Order Barang: Melakukan pemesanan propduk
```
Example:
POST http://localhost:8081/order
{
    "productId" : 1,
    "orderQuantity" : 6
}
```
4. Get Product: Menampilkan detail produk
```
GET http://localhost:8080/product/1
```
5. Get Stock by Product Id: Menampilkan stok produk
```
GET http://localhost:8082/stock/1
```

# How To Run 
Through IntelliJ Idea IDE 

```
Buka Project menggunakan IntelliJ Idea, lalu masuk ke Services Tab
```
![image](https://user-images.githubusercontent.com/23337562/193455802-d5dd7492-ab1a-4e67-9653-6d516f49e235.png)
```
Klik kanan pada Service ProductserviceApplication, lalu klik Run
```
![image](https://user-images.githubusercontent.com/23337562/193455917-82650370-37c8-4499-add9-e3659e860451.png)

![image](https://user-images.githubusercontent.com/23337562/193455947-bdc100c5-cc8d-40b6-bcae-6070f78b9a39.png)
```
Lakukan hal yang sama untuk Service OrderserviceApplicate,StockserviceApplication.
Pastikan ketiga running Service tersebut dengan normal sesuai dengan gambar dibawah
```
![image](https://user-images.githubusercontent.com/23337562/193457873-4dd7961b-acb5-469d-afea-ef276c5565ec.png)


# Sample

```
Menambah Produk Baru, produk baru terdaftar dengan Product Id = 1
```
![image](https://user-images.githubusercontent.com/23337562/193456200-149b1b53-8f9d-40bf-905b-51c8c363d785.png)
```
Produk Baru sudah masuk ke dalam database
```
![image](https://user-images.githubusercontent.com/23337562/193457357-35385a71-4370-406a-ae06-5fcb4272f687.png)
```
Menambahkan stok dari Product Id 1, sebanyak 50
```
![image](https://user-images.githubusercontent.com/23337562/193456228-d85b66f7-fedb-4b18-aeb1-9cc1e06aeb19.png)
```
Stok sudah masuk ke dalam database
```
![image](https://user-images.githubusercontent.com/23337562/193457413-8db5cbdd-dc6c-4a7e-8a62-79395a772bb5.png)
```
Melakukan pemesanan Product Id 1 sebanyak 100, aplikasi memberikan response "Not Enough Stock". 
Karena jumlah pesanan lebih banyak dari jumlah stok
```
![image](https://user-images.githubusercontent.com/23337562/193456291-2b59e3db-eb88-4540-8cc0-7222ce19eb7f.png)
```
Melakukan order Product Id 1, sebanyak 30
Karena jumlah pesanan lebih sedikit dari jumlah stok, pemesanan Produk berhasil
```
![image](https://user-images.githubusercontent.com/23337562/193457461-bcd96b20-996d-4775-865b-ee827f5cdc2a.png)
```
Pemesanan produk masuk ke dalam database
```
![image](https://user-images.githubusercontent.com/23337562/193458481-8fcc8c5e-882b-442d-85f0-82d649accc92.png)


