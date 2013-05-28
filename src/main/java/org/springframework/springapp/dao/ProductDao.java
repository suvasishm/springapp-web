package org.springframework.springapp.dao;

import java.util.List;

import org.springframework.springapp.domain.Product;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}
