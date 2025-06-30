package dev.books.BookRegistration.Rating;

import dev.books.BookRegistration.Books.BookModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@Table(name = "tb_ratings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingModel {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int rating; // Exemplo: 1 a 5 estrelas
    @OneToOne
    @JoinColumn(name = "book_id")
    private BookModel book;

}
