package dev.books.BookRegistration.Reviews;

import dev.books.BookRegistration.Books.BookModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String review;
    @ManyToOne()
    @JoinColumn(name = "book_id") // Foreing key
    private BookModel book;
}
