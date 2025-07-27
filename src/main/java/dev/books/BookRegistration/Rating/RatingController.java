package dev.books.BookRegistration.Rating;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("ratings")
public class RatingController {

    private RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/create")
    public RatingModel createRating(@RequestBody RatingModel rating) {
        return ratingService.createRating(rating);
    }

    @GetMapping("/list/{id}")
    public RatingModel showRatingById(@PathVariable UUID id) {
        return ratingService.showRatingById(id);
    }

    @GetMapping("/list")
    public List<RatingModel> showAllRatings() {
        return ratingService.showAllRatings();
    }

    @PutMapping("/update/{id}")
    public RatingModel updateRating(@PathVariable UUID id, RatingModel rating) {
        return ratingService.updateRating(id, rating);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRating(@PathVariable UUID id) {
        ratingService.deleteRaiting(id);
    }
}
