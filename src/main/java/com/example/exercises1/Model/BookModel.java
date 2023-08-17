package com.example.exercises1.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title must not be empty ")
    @Column(columnDefinition ="varchar(20) not null")
    private String title;

    @NotEmpty(message = "Author must not be empty ")
    @Column(columnDefinition ="varchar(20) not null")
    private String author;

    @NotEmpty(message = "Category must not be empty ")
    @Pattern(regexp = "Mystery|Novel", message = "Category must be Mystery or Novel")
    @Column(columnDefinition ="varchar(20) not null CHECK(category='Mystery' or category='Novel')")
    private String category;

    @NotNull(message = "ISBN must not be empty")
    @Column(columnDefinition ="int not null" )
    private Integer ISBN;

    @NotNull(message = "Number of pages must not be empty")
    @Min(value = 50, message = "Number of pages must be more than 50 ")
    @Column(columnDefinition ="int not null CHECK(numberOfPages>=4)")
    private Integer numberOfPages ;


}
