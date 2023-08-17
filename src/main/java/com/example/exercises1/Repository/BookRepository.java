package com.example.exercises1.Repository;

import com.example.exercises1.Model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookRepository extends JpaRepository<BookModel,Integer> {

}