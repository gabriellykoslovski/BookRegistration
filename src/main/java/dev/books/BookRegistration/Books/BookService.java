package dev.books.BookRegistration.Books;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Listar todos os meus livros
    public List<BookModel> showAllBooks(){
        return bookRepository.findAll();
    }

    // Listar o livro por ID
    public BookModel showBookById(UUID id){
        Optional<BookModel> bookById = bookRepository.findById(id);
        return bookById.orElse(null);
    }

    // Cadastrar um novo livro
    public BookModel createBook(BookModel book){
        return bookRepository.save(book);
    }

    // Deletar um livro - Tem que ser um metodo VOID
    public void deleteBook(UUID id){
       bookRepository.deleteById(id);
    }

    // Atualizar os dados do livro
    public BookModel updateBook(UUID id, BookModel book){
        if(bookRepository.existsById(id)){
            book.setId(id);
            return bookRepository.save(book);
        }
        return null;
    }


}
