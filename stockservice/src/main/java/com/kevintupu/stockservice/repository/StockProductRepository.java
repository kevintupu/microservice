package com.kevintupu.stockservice.repository;

import com.kevintupu.stockservice.entity.StockProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockProductRepository extends JpaRepository<StockProduct,Long> {
    StockProduct findByProductId(Long productId);
}
