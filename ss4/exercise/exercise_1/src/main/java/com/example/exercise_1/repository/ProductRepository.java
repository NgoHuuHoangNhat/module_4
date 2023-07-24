package com.example.exercise_1.repository;

import com.example.exercise_1.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> findAll() {
        Query query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(Integer id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    @Modifying
    public Product remove(Integer id) {
        Product product = findById(id);
        entityManager.remove(product);
        return product;
    }

    @Override
    @Transactional
    public void addNewProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }


}
