package dev.books.BookRegistration.Rating;

import dev.books.BookRegistration.Books.BookModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    public RatingService(RatingRepository ratingRepository, RatingMapper ratingMapper) {
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
    }

    public List<RatingDTO> showAllRatings(){
        List<RatingModel> ratings = ratingRepository.findAll();
        return ratings.stream()
                .map(ratingMapper::map)
                .collect(Collectors.toList());
    }

    public RatingDTO showRatingById(UUID id){
        Optional<RatingModel> ratingById = ratingRepository.findById(id);
        return ratingById.map(ratingMapper::map).orElse(null);
    }

    public RatingDTO createRating(RatingDTO ratingDTO){
        RatingModel rating = ratingMapper.map(ratingDTO);
        rating = ratingRepository.save(rating);
        return ratingMapper.map(rating);
    }

    public void deleteRaiting(UUID id){
        ratingRepository.deleteById(id);
    }

    public RatingDTO updateRating(UUID id, RatingDTO ratingDTO){
       Optional<RatingModel> ratingSelected = ratingRepository.findById(id);
       if(ratingSelected.isPresent()){
           RatingModel rating = ratingMapper.map(ratingDTO);
           rating.setId(id);
           RatingModel ratingToSave = ratingRepository.save(rating);
           return ratingMapper.map(ratingToSave);
       }

        return null;
    }
}
