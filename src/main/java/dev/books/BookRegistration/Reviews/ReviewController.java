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
    public ReviewModel createReview(@RequestBody ReviewModel review){
        return reviewService.createReview(review);
    }

    @GetMapping("/list/{id}")
    public ReviewModel showReviewById(@PathVariable UUID id){
        return reviewService.showReviewById(id);
    }

    @GetMapping("/list")
    public List<ReviewModel> showAllReviews(){
        return reviewService.showAllReviews();
    }

    @PutMapping("/update/{id}")
    public ReviewModel updateReview(@PathVariable UUID id, @RequestBody ReviewModel review){
        return reviewService.updateReview(id, review);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReview(@PathVariable UUID id){
        reviewService.deleteReview(id);
    }



}
