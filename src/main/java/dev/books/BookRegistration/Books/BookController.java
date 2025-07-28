package dev.books.BookRegistration.Books;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public BookDTO createBook(@RequestBody BookDTO book) {
        return bookService.createBook(book);
    }

    @GetMapping("/list/{id}")
    public BookDTO showBookById(@PathVariable UUID id) {
        return bookService.showBookById(id);
    }

    @GetMapping("/list")
    public List<BookDTO> showAllBooks() {
        return bookService.showAllBooks();
    }

    @PutMapping("/update/{id}")
    public BookDTO updateBook(@PathVariable UUID id, @RequestBody BookDTO book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable UUID id) {
         bookService.deleteBook(id);
    }
}
