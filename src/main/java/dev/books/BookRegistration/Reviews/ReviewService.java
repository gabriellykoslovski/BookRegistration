package dev.books.BookRegistration.Reviews;

import dev.books.BookRegistration.Books.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<ReviewModel> showAllReviews() {
        return reviewRepository.findAll();
    }

    public ReviewModel showReviewById(UUID id){
        Optional<ReviewModel> reviewById = reviewRepository.findById(id);
        return reviewById.orElse(null);
    }

    public ReviewModel createReview(ReviewModel review){
        return reviewRepository.save(review);
    }

    public void deleteReview(UUID id){
        reviewRepository.deleteById(id);
    }

    public ReviewModel updateReview(UUID id, ReviewModel review){
        if(reviewRepository.existsById(id)){
            review.setId(id);
            return reviewRepository.save(review);
        }
        return null;
    }

}
