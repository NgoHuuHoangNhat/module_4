package com.example.exercise_1.repository;

import com.example.exercise_1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value = " select quantity as quantity from book b where b.id = :id ",nativeQuery = true)
    Long getQuantity(@Param(value = "id") Integer id );


    @Query(value = "select b.id as id,b.name as name, b.content as content,b.author as author, b.quantity as quantity\n" +
            "from book b\n" +
            "join borrow bor on b.id = bor.book_id\n" +
            "where bor.code = :code",nativeQuery = true)
    Book findBookBorrowByCode(@Param(value = "code") String code);
}
