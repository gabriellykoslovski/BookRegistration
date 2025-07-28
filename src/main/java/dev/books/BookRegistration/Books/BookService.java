package dev.books.BookRegistration.Books;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDTO> showAllBooks(){
        List<BookModel> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::map)
                .collect(Collectors.toList());
    }

    public BookDTO showBookById(UUID id){
        Optional<BookModel> bookById = bookRepository.findById(id);
        return bookById.map(bookMapper::map).orElse(null);
    }

    public BookDTO createBook(BookDTO bookDTO){
        BookModel book = bookMapper.map(bookDTO);
        book = bookRepository.save(book);
        return bookMapper.map(book);
    }

    public void deleteBook(UUID id){
       bookRepository.deleteById(id);
    }

    public BookDTO updateBook(UUID id, BookDTO bookDTO){
        Optional<BookModel> bookSelected = bookRepository.findById(id);
        if (bookSelected.isPresent()){
            BookModel book = bookMapper.map(bookDTO);
            book.setId(id);
            BookModel bookToSave = bookRepository.save(book);
            return bookMapper.map((bookToSave));
        }
        return null;
    }


}
