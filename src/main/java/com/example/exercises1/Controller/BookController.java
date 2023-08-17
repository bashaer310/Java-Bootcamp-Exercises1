package com.example.exercises1.Controller;

import com.example.exercises1.Api.ApiResponse;
import com.example.exercises1.Model.BookModel;
import com.example.exercises1.Servise.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;


    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(bookService.getBooks());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid BookModel book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("Book added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody @Valid BookModel book, @PathVariable Integer id){
        bookService.updateBook(book,id);
        return ResponseEntity.status(200).body(new ApiResponse("Book updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("Book deleted"));
    }

    @GetMapping("/getByCategory/{category}")
    public ResponseEntity getBooksByCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(bookService.getBooksByCategory(category));
    }
    @GetMapping("/getByNumberOfPages")
    public ResponseEntity getBooksByNumberOfPages(){
        return ResponseEntity.status(200).body(bookService.getBooksByNumberOfPages());
    }

    @GetMapping("/getByAuthor/{author}")
    public ResponseEntity getBooksByAuthor(@PathVariable String author){
        return ResponseEntity.status(200).body(bookService.getBooksByAuthor(author));
    }

    @GetMapping("/getByTitle/{title}")
    public ResponseEntity getBooksByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(bookService.getBookByTitle(title));
    }


}
