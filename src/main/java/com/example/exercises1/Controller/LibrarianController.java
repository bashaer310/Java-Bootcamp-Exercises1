package com.example.exercises1.Controller;


import com.example.exercises1.Api.ApiResponse;
import com.example.exercises1.Model.BookModel;
import com.example.exercises1.Model.LibrarianModel;
import com.example.exercises1.Servise.LibrarianServise;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Librarian")
@RequiredArgsConstructor
public class LibrarianController {
    private final LibrarianServise librarianServise;


    @GetMapping("/get")
    public ResponseEntity getLibrarians(){
        return ResponseEntity.status(200).body(librarianServise.getLibrarians());
    }

    @PostMapping("/add")
    public ResponseEntity addLibrarian(@RequestBody @Valid LibrarianModel librarian){
        librarianServise.addLibrarian(librarian);
        return ResponseEntity.status(200).body(new ApiResponse("Librarian added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@RequestBody @Valid LibrarianModel librarian, @PathVariable Integer id){
        librarianServise.updateLibrarian(librarian,id);
        return ResponseEntity.status(200).body(new ApiResponse("Librarian updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
        librarianServise.deleteLibrarian(id);
        return ResponseEntity.status(200).body(new ApiResponse("Librarian deleted"));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity getLibrarianById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(librarianServise.getLibrarianModelById(id));
    }
    @GetMapping("/getByEmailAndPassword/{email}/{password}")
    public ResponseEntity getLibrarianById(@PathVariable String email,@PathVariable String password){
        return ResponseEntity.status(200).body(librarianServise.getLibrarianModelByEmailAndPassword(email,password));
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity getLibrarianByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(librarianServise.getLibrarianModelByEmail(email));
    }

}
