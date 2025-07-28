package dev.books.BookRegistration.Reviews;

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
@RequestMapping("reviews")

public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    @Operation(summary = "Cria uma nova review", description = "Essa rota cria uma nova review no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Review criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação da review"),
    })
    public ResponseEntity<String> createReview(@RequestBody ReviewDTO review){
        ReviewDTO newReview = reviewService.createReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body("Review criada com sucesso.");
    }

    @GetMapping("/list/{id}")
    @Operation(summary = "Busca uma review pelo ID", description = "Essa rota busca pelo ID a review cadastrado no banco de dados e retorna seus dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Review não encontrado")
    })
    public ResponseEntity<?> showReviewById(
            @Parameter(description = "Usuário manda o ID no caminho da requisição")
            @PathVariable UUID id
    ){
        ReviewDTO review = reviewService.showReviewById(id);
        if (review != null){
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A review com ID " + id + " não foi encontrada.");
        }
    }

    @GetMapping("/list")
    @Operation(summary = "Lista todas as reviews", description = "Essa rota lista todas as reviews cadastradas no banco de dados")
    public ResponseEntity<List<ReviewDTO>> showAllReviews(){
        List<ReviewDTO> reviews = reviewService.showAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Atualiza uma review", description = "Essa rota atualiza a review pelo ID no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Review não encontrado"),
    })
    public ResponseEntity<String> updateReview(
            @Parameter(description = "Usuário manda o ID no caminho da requisição")
            @PathVariable UUID id,
            @Parameter(description = "Usuário manda os dados da review a ser atualizada no corpo da requisição")
            @RequestBody ReviewDTO review){
       if (reviewService.showReviewById(id) != null){
           reviewService.updateReview(id, review);
           return ResponseEntity.ok("A review foi atualizada com sucesso.");
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A review com ID " + id + " não foi encontrada.");
       }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Excluí uma review", description = "Essa rota remove a review pelo ID do banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review foi removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Review não encontrado, não foi possível remover"),
    })
    public ResponseEntity<String> deleteReview(
            @Parameter(description = "Usuário manda o ID no caminho da requisição")
            @PathVariable UUID id
    ){
        if (reviewService.showReviewById(id) != null){
            reviewService.deleteReview(id);
            return ResponseEntity.ok("Review foi removida com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A review com ID " + id + " não foi encontrado.");
        }
    }



}
