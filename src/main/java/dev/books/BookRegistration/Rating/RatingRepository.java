package dev.books.BookRegistration.Rating;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RatingRepository extends JpaRepository<RatingModel, UUID> {
}
