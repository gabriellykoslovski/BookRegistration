package dev.books.BookRegistration.Rating;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createRating(@RequestBody RatingDTO rating) {
        RatingDTO newRating = ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body("A avaliação foi feita com sucesso.");
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> showRatingById(@PathVariable UUID id) {
        RatingDTO rating = ratingService.showRatingById(id);
        if (rating != null) {
            return ResponseEntity.ok(rating);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A avaliação com ID " + id + " não foi encontrada.");
        }

    }

    @GetMapping("/list")
    public ResponseEntity<List<RatingDTO>> showAllRatings() {
        List<RatingDTO> ratings = ratingService.showAllRatings();
        return ResponseEntity.ok(ratings);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRating(@PathVariable UUID id, RatingDTO rating) {
        if (ratingService.showRatingById(id) != null){
            RatingDTO ratingSelected = ratingService.updateRating(id, rating);
            return ResponseEntity.ok("A avaliação foi atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A avaliação com ID " + id + " não foi encontrada.");
        }
    }

}
