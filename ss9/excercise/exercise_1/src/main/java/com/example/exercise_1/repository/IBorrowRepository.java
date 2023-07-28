package com.example.exercise_1.repository;

import com.example.exercise_1.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {
    @Modifying
    @Transactional
    @Query(value = "delete from borrow \n" +
            "where code = :code", nativeQuery = true)
    void deleteBorrowByCode(@Param(value = "code") String code);

    @Query(value = "select * \n" +
            "from borrow b\n" +
            "where b.code = :code", nativeQuery = true)
    Borrow findBorrowByCode(@Param(value = "code") String code);
}
