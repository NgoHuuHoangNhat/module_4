package com.example.exercise_1.repository;

import com.example.exercise_1.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.*;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "Banh kem", 10000D, 100L, "Ngon"));
        productMap.put(2, new Product(2, "Banh kem", 10000D, 100L, "Ngon"));
        productMap.put(3, new Product(3, "Banh kem", 10000D, 100L, "Ngon"));
        productMap.put(4, new Product(4, "Banh kem", 10000D, 100L, "Ngon"));
        productMap.put(5, new Product(5, "Banh kem", 10000D, 100L, "Ngon"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(Integer id) {
        for (Integer p : productMap.keySet()) {
            if (productMap.get(p).getId().equals(id)) {
                return productMap.get(p);
            }
        }
        return null;
    }

    @Override
    public Product remove(Integer id) {
        System.out.println(id);
        return productMap.remove(id);
    }

    @Override
    public Integer findNewId() {
        Integer newId = 1;
        do {
            Product product = findById(newId);
            if (product == null) {
                break;
            } else {
                newId++;
            }
        } while (true);
        return newId;
    }

    @Override
    public void addNewProduct(Product product) {
        System.out.println(product.getId());
        productMap.put(product.getId(), product);
    }

    @Override
    public void updateProduct(Product product) {
        for (Integer key:productMap.keySet()) {
            Product p = productMap.get(key);
            if(p.getId().equals(product.getId())){
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setQuantity(product.getQuantity());
                p.setDescription(product.getDescription());
                break;
            }
        }
    }


}
