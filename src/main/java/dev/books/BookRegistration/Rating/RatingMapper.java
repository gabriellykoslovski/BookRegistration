package dev.books.BookRegistration.Rating;

import dev.books.BookRegistration.Books.BookModel;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper {
    public RatingModel map(RatingDTO ratingDTO){
        RatingModel ratingModel = new RatingModel();
        ratingModel.setId(ratingDTO.getId());
        ratingModel.setRating(ratingDTO.getRating());
        ratingModel.setBook(ratingDTO.getBook());

        return ratingModel;
    }

    public RatingDTO map(RatingModel ratingModel){
        RatingDTO ratingDTO = new RatingDTO();
        ratingDTO.setId(ratingModel.getId());
        ratingDTO.setRating(ratingModel.getRating());
        ratingDTO.setBook(ratingModel.getBook());

        return ratingDTO;
    }
}
