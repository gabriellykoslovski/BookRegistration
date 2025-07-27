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

    @GetMapping("/boas-vindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Criar livro
    @PostMapping("/create")
    public BookModel createBook(@RequestBody BookModel book) {
        return bookService.createBook(book);
    }

    // Listar livro pelo ID
    @GetMapping("/list/{id}")
    public BookModel showBookById(@PathVariable UUID id) {
        return bookService.showBookById(id);
    }

    // Listar todos os livros
    @GetMapping("/list")
    public List<BookModel> showAllBooks() {
        return bookService.showAllBooks();
    }

    // Atualizar livro
    @PutMapping("/update/{id}")
    public BookModel updateBook(@PathVariable UUID id, @RequestBody BookModel book) {
        return bookService.updateBook(id, book);
    }

    // Deletar livro
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable UUID id) {
         bookService.deleteBook(id);
    }
}
