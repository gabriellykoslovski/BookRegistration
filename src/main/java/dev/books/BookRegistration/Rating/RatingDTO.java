package dev.books.BookRegistration.Rating;

import dev.books.BookRegistration.Books.BookModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDTO {
    private UUID id;
    private int rating;
    private BookModel book;
}
