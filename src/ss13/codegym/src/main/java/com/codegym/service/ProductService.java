package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
@Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> finAll() {
        return productRepository.findAll();
    }
}
