package dev.books.BookRegistration.Books;

import dev.books.BookRegistration.Rating.RatingModel;
import dev.books.BookRegistration.Reviews.ReviewModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private UUID id;
    private String title;
    private String author;
    private LocalDate realeaseYear;
    private String publisher;
    private String bookLanguage;
    private StatusEnum status;
    private String description;
    private List<ReviewModel> reviews;
    private RatingModel rating;
    private byte[] bookImage;

}
