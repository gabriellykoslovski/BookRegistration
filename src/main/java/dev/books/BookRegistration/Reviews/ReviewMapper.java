package dev.books.BookRegistration.Reviews;

import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public ReviewModel map(ReviewDTO reviewDTO){
        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setId(reviewDTO.getId());
        reviewModel.setReview(reviewDTO.getReview());
        reviewModel.setBook(reviewDTO.getBook());

        return reviewModel;
    }

    public ReviewDTO map(ReviewModel reviewModel){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(reviewModel.getId());
        reviewDTO.setReview(reviewModel.getReview());
        reviewDTO.setBook(reviewModel.getBook());

        return reviewDTO;
    }
}
