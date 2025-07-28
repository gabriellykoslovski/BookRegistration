package dev.books.BookRegistration.Books;

import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookModel map(BookDTO bookDTO){
        BookModel bookModel = new BookModel();
        bookModel.setId(bookDTO.getId());
        bookModel.setTitle(bookDTO.getTitle());
        bookModel.setAuthor(bookDTO.getAuthor());
        bookModel.setRealeaseYear(bookDTO.getRealeaseYear());
        bookModel.setPublisher(bookDTO.getPublisher());
        bookModel.setBookLanguage(bookDTO.getBookLanguage());
        bookModel.setStatus(bookDTO.getStatus());
        bookModel.setDescription(bookDTO.getDescription());
        bookModel.setReviews(bookDTO.getReviews());
        bookModel.setRating(bookDTO.getRating());
        bookModel.setBookImage(bookDTO.getBookImage());

        return bookModel;
    }

    public BookDTO map(BookModel bookModel){
        BookDTO bookDTO = new BookDTO();

        bookDTO.setId(bookModel.getId());
        bookDTO.setTitle(bookModel.getTitle());
        bookDTO.setAuthor(bookModel.getAuthor());
        bookDTO.setRealeaseYear(bookModel.getRealeaseYear());
        bookDTO.setPublisher(bookModel.getPublisher());
        bookDTO.setBookLanguage(bookModel.getBookLanguage());
        bookDTO.setStatus(bookModel.getStatus());
        bookDTO.setDescription(bookModel.getDescription());
        bookDTO.setReviews(bookModel.getReviews());
        bookDTO.setRating(bookModel.getRating());
        bookDTO.setBookImage(bookModel.getBookImage());

        return bookDTO;
    }


}
