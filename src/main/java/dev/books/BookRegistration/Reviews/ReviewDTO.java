package dev.books.BookRegistration.Reviews;

import dev.books.BookRegistration.Books.BookModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private UUID id;
    private String review;
    private BookModel book;

}
