package dev.books.BookRegistration.Rating;

import dev.books.BookRegistration.Books.BookModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RatingService {

    private RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<RatingModel> showAllRatings(){
        return ratingRepository.findAll();
    }

    public RatingModel showRatingById(UUID id){
        Optional<RatingModel> ratingById = ratingRepository.findById(id);
        return ratingById.orElse(null);
    }

    public RatingModel createRating(RatingModel rating){
        return ratingRepository.save(rating);
    }

    public void deleteRaiting(UUID id){
        ratingRepository.deleteById(id);
    }

    public RatingModel updateRating(UUID id, RatingModel rating){
        if(ratingRepository.existsById(id)){
            rating.setId(id);
            return ratingRepository.save(rating);
        }

        return null;
    }
}
