package com.cart.service;

import com.cart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> finAll();
    Optional<Product> finById(Long id);
    void save(Product product);
}
