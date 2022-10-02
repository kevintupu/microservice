package com.kevintupu.orderservice.controller;

import com.kevintupu.orderservice.entitiy.OrderProduct;
import com.kevintupu.orderservice.entitiy.Product;
import com.kevintupu.orderservice.entitiy.StockProduct;
import com.kevintupu.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderRepository orderRepository;
    @Autowired
    private WebClient.Builder webClientBuilder;

    public OrderController(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderId(@PathVariable Long id)
    {
        OrderProduct order = orderRepository.findById(id).orElse(null);
        if (order==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<?> postOrder(@RequestBody OrderProduct orderProduct)
    {
        Product product = webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/product/"+orderProduct.getProductId())
                .retrieve()
                .bodyToMono(Product.class).block();

        StockProduct stock = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/stock/"+orderProduct.getProductId())
                .retrieve()
                .bodyToMono(StockProduct.class).block();

        if(stock.getProductQuantity() < orderProduct.getOrderQuantity())
            return new ResponseEntity<>("Not Enough Stock",HttpStatus.OK);
        if(product == null)
            return new ResponseEntity<>("Product Not Found",HttpStatus.OK);
        orderRepository.save(orderProduct);
        return new ResponseEntity<>(orderProduct,HttpStatus.CREATED);
        //return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
