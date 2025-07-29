package dev.books.BookRegistration.Books;

import dev.books.BookRegistration.Rating.RatingModel;
import dev.books.BookRegistration.Reviews.ReviewModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_registration")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"rating", "reviews"})
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private String author;

    private LocalDate realeaseYear;

    private String publisher;

    @Column(name = "book_language" )
    private String bookLanguage;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(length = 1000)
    private String description;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<ReviewModel> reviews;

    @OneToOne
    @JoinColumn(name = "rating_id")
    private RatingModel rating;

    @Column(name = "book_image", nullable = true)
    private byte[] bookImage;


}
