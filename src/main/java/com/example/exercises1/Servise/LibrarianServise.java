package com.example.exercises1.Servise;

import com.example.exercises1.Api.ApiException;
import com.example.exercises1.Model.BookModel;
import com.example.exercises1.Model.LibrarianModel;
import com.example.exercises1.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianServise {
    private final LibrarianRepository librarianRepository;


    public List<LibrarianModel> getLibrarians(){
        return  librarianRepository.findAll();
    }
    public void addLibrarian(LibrarianModel librarian){
        librarianRepository.save(librarian);
    }

    public void updateLibrarian(LibrarianModel librarianModel, Integer id){
        LibrarianModel librarian=librarianRepository.findLibrarianModelById(id);

        if(librarian==null)
            throw new ApiException("Id not found");
        librarian.setName(librarianModel.getName());
        librarian.setUsername(librarianModel.getUsername());
        librarian.setPassword(librarianModel.getPassword());
        librarian.setEmail(librarianModel.getEmail());
        librarianRepository.save(librarian);

    }

    public void deleteLibrarian(Integer id){
        LibrarianModel librarian=librarianRepository.findLibrarianModelById(id);

        if(librarian==null)
            throw new ApiException("Id not found");

        librarianRepository.delete(librarian);
    }

    public LibrarianModel getLibrarianModelById(Integer id){
        LibrarianModel librarian=librarianRepository.findLibrarianModelById(id);

        if(librarian==null)
            throw new ApiException("Id not found");

        return librarian;
    }


    public String getLibrarianModelByEmailAndPassword(String email, String password){
        LibrarianModel librarian=librarianRepository.findLibrarianModelByEmailAndPassword(email, password);

        if(librarian==null)
            throw new ApiException("Email And Password not found");

        return "Successful Login";
    }

    public LibrarianModel getLibrarianModelByEmail(String email){
        LibrarianModel librarian=librarianRepository.findLibrarianModelByEmail(email);

        if(librarian==null)
            throw new ApiException("Email not found");

        return librarian;
    }




}
