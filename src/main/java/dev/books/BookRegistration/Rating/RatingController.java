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
    public RatingDTO createRating(@RequestBody RatingDTO rating) {
        return ratingService.createRating(rating);
    }

    @GetMapping("/list/{id}")
    public RatingDTO showRatingById(@PathVariable UUID id) {
        return ratingService.showRatingById(id);
    }

    @GetMapping("/list")
    public List<RatingDTO> showAllRatings() {
        return ratingService.showAllRatings();
    }

    @PutMapping("/update/{id}")
    public RatingDTO updateRating(@PathVariable UUID id, RatingDTO rating) {
        return ratingService.updateRating(id, rating);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRating(@PathVariable UUID id) {
        ratingService.deleteRaiting(id);
    }
}
