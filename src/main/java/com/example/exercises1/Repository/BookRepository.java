package com.example.exercises1.Repository;

import com.example.exercises1.Model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BookRepository extends JpaRepository<BookModel,Integer> {


    BookModel findBookModelById(Integer id);

    List<BookModel> findBookModelByCategory(String Category);

    @Query("select b from BookModel  b where  b.numberOfPages>=300")
    List<BookModel> getByNumberOfPages();

    List<BookModel> findBookModelByAuthor(String author);

    BookModel findBookModelByTitle(String title);


}
