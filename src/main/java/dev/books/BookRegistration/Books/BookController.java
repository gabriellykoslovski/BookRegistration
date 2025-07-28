package dev.books.BookRegistration.Books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createBook(@RequestBody BookDTO book) {
        BookDTO newBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Livro criado com sucesso: " + newBook.getTitle() + " (ID): " + newBook.getId());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> showBookById(@PathVariable UUID id) {
        BookDTO book = bookService.showBookById(id);
        if (book != null){
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O livro com ID " + id + " não foi encontrado.");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<BookDTO>> showAllBooks() {
        List<BookDTO> books = bookService.showAllBooks();
        return ResponseEntity.ok(books);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBook(@PathVariable UUID id, @RequestBody BookDTO book) {
        if (bookService.showBookById(id) != null){
            BookDTO bookSelected = bookService.updateBook(id, book);
            return ResponseEntity.ok("O livro " + bookSelected.getTitle() + " foi atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O livro com ID " + id + " não foi encontrado.");
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id) {
        if (bookService.showBookById(id) != null) {
            bookService.deleteBook(id);
            return ResponseEntity.ok("Livro com o ID " + id + " foi excluído com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O livro com o ID " + id + " não foi encontrado");
        }
    }
}
