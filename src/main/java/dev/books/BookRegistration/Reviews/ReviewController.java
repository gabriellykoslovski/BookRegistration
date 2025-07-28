package dev.books.BookRegistration.Reviews;

import dev.books.BookRegistration.Books.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createReview(@RequestBody ReviewDTO review){
        ReviewDTO newReview = reviewService.createReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body("Review criada com sucesso.");
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> showReviewById(@PathVariable UUID id){
        ReviewDTO review = reviewService.showReviewById(id);
        if (review != null){
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A review com ID " + id + " não foi encontrada.");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<ReviewDTO>> showAllReviews(){
        List<ReviewDTO> reviews = reviewService.showAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateReview(@PathVariable UUID id, @RequestBody ReviewDTO review){
       if (reviewService.showReviewById(id) != null){
           reviewService.updateReview(id, review);
           return ResponseEntity.ok("A review foi atualizada com sucesso.");
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A review com ID " + id + " não foi encontrada.");
       }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable UUID id){
        if (reviewService.showReviewById(id) != null){
            reviewService.deleteReview(id);
            return ResponseEntity.ok("Review foi removida com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A review com ID " + id + " não foi encontrado.");
        }
    }



}
