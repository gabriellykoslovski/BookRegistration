package dev.books.BookRegistration.Reviews;

import dev.books.BookRegistration.Books.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;
    private ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    public List<ReviewDTO> showAllReviews() {
        List<ReviewModel> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(reviewMapper::map)
                .collect(Collectors.toList());
    }

    public ReviewDTO showReviewById(UUID id){
        Optional<ReviewModel> reviewById = reviewRepository.findById(id);
        return reviewById.map(reviewMapper::map).orElse(null);
    }

    public ReviewDTO createReview(ReviewDTO reviewDTO){
        ReviewModel review = reviewMapper.map(reviewDTO);
        review = reviewRepository.save(review);
        return reviewMapper.map(review);
    }

    public void deleteReview(UUID id){
        reviewRepository.deleteById(id);
    }

    public ReviewDTO updateReview(UUID id, ReviewDTO reviewDTO){
        Optional<ReviewModel> reviewSelected = reviewRepository.findById(id);
        if (reviewSelected.isPresent()){
            ReviewModel review = reviewMapper.map(reviewDTO);
            review.setId(id);
            ReviewModel reviewToSave = reviewRepository.save(review);

            return reviewMapper.map(reviewToSave);
        }

        return null;
    }

}
