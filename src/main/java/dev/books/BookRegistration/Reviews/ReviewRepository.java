package dev.books.BookRegistration.Reviews;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
