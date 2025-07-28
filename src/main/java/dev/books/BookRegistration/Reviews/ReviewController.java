package dev.books.BookRegistration.Reviews;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("reviews")

public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    public ReviewDTO createReview(@RequestBody ReviewDTO review){
        return reviewService.createReview(review);
    }

    @GetMapping("/list/{id}")
    public ReviewDTO showReviewById(@PathVariable UUID id){
        return reviewService.showReviewById(id);
    }

    @GetMapping("/list")
    public List<ReviewDTO> showAllReviews(){
        return reviewService.showAllReviews();
    }

    @PutMapping("/update/{id}")
    public ReviewDTO updateReview(@PathVariable UUID id, @RequestBody ReviewDTO review){
        return reviewService.updateReview(id, review);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReview(@PathVariable UUID id){
        reviewService.deleteReview(id);
    }



}
