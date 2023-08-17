package com.example.exercises1.Servise;


import com.example.exercises1.Api.ApiException;
import com.example.exercises1.Model.BookModel;
import com.example.exercises1.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<BookModel> getBooks(){
        return  bookRepository.findAll();
    }
    public void addBook(BookModel book){
        bookRepository.save(book);
    }

    public void updateBook(BookModel bookModel, Integer id){
        BookModel book=bookRepository.findBookModelById(id);

        if(book==null)
            throw new ApiException("Id not found");

        book.setTitle(bookModel.getTitle());
        book.setAuthor(bookModel.getAuthor());
        book.setCategory(bookModel.getCategory());
        book.setISBN(bookModel.getISBN());
        book.setNumberOfPages(bookModel.getNumberOfPages());
        bookRepository.save(book);
    }

    public void deleteBook(Integer id){
        BookModel book=bookRepository.findBookModelById(id);

        if(book==null)
            throw new ApiException("Id not found");

        bookRepository.delete(book);
    }

    public List<BookModel> getBooksByCategory(String category){
        List<BookModel> books=bookRepository.findBookModelByCategory(category);

        if(books==null)
            throw new ApiException("Books not found");

        return books;
    }

    public List<BookModel> getBooksByNumberOfPages(){
        List<BookModel> books=bookRepository.getByNumberOfPages();

        if(books==null)
            throw new ApiException("Books not found");

        return books;
    }
    public List<BookModel> getBooksByAuthor(String author){
        List<BookModel> books=bookRepository.findBookModelByAuthor(author);

        if(books==null)
            throw new ApiException("Books not found");

        return books;
    }

    public BookModel getBookByTitle(String title){
        BookModel book=bookRepository.findBookModelByTitle(title);
        if(book==null)
            throw new ApiException("Books not found");

        return book;
    }






}
