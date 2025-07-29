package dev.books.BookRegistration.Books;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo livro", description = "Essa rota cria um novo livro no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Livro criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do livro"),
    })
    public ResponseEntity<String> createBook(@RequestBody BookDTO book) {
        BookDTO newBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Livro criado com sucesso: " + newBook.getTitle() + " (ID): " + newBook.getId());
    }

    @GetMapping("/list/{id}")
    @Operation(summary = "Busca um livro pelo ID", description = "Essa rota busca pelo ID o livro cadastrado no banco de dados e retorna seus dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livro encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    })
    public ResponseEntity<?> showBookById(@PathVariable UUID id) {
        BookDTO book = bookService.showBookById(id);
        if (book != null){
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O livro com ID " + id + " não foi encontrado.");
        }
    }

    @GetMapping("/list")
    @Operation(summary = "Lista todos os livros", description = "Essa rota lista todos os livros cadastrados no banco de dados")
    public ResponseEntity<List<BookDTO>> showAllBooks() {
        List<BookDTO> books = bookService.showAllBooks();
        return ResponseEntity.ok(books);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Atualiza um livro", description = "Essa rota atualiza o livro pelo ID no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado"),
    })
    public ResponseEntity<String> updateBook(
            @Parameter(description = "Usuário manda o ID no caminho da requisição")
            @PathVariable UUID id,
            @Parameter(description = "Usuário manda os dados do livro a ser atualizado no corpo da requisição")
            @RequestBody BookDTO book) {
        if (bookService.showBookById(id) != null){
            BookDTO bookSelected = bookService.updateBook(id, book);
            return ResponseEntity.ok("O livro " + bookSelected.getTitle() + " foi atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O livro com ID " + id + " não foi encontrado.");
        }

    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Excluí um livro", description = "Essa rota remove o livro pelo ID do banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livro removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado, não foi possível remover"),
    })
    public ResponseEntity<String> deleteBook(
            @Parameter(description = "Usuário manda o ID no caminho da requisição")
            @PathVariable UUID id
    ) {
        if (bookService.showBookById(id) != null) {
            bookService.deleteBook(id);
            return ResponseEntity.ok("Livro com o ID " + id + " foi excluído com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O livro com o ID " + id + " não foi encontrado");
        }
    }
}
