package dev.books.BookRegistration.Reviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.books.BookRegistration.Books.BookModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "tb_reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "book")
public class ReviewModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String review;
    @ManyToOne()
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private BookModel book;
}
