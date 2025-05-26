package dev.books.BookRegistration.Books;

import dev.books.BookRegistration.Rating.RatingModel;
import dev.books.BookRegistration.Reviews.ReviewModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_registration")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String title;
    private String author;
    private int realeaseYear;
    private String publisher;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    private String description;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<ReviewModel> reviews;
    @OneToOne
    @JoinColumn(name = "rating_id")
    private RatingModel rating;

}
