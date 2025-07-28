package dev.books.BookRegistration.Rating;

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
@RequestMapping("ratings")
public class RatingController {

    private RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/create")
    @Operation(summary = "Cria uma nova avaliação", description = "Essa rota cria uma nova avaliação no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "A avaliação foi feita com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação da avaliação"),
    })
    public ResponseEntity<String> createRating(@RequestBody RatingDTO rating) {
        RatingDTO newRating = ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body("A avaliação foi feita com sucesso.");
    }

    @GetMapping("/list/{id}")
    @Operation(summary = "Busca uma avaliação pelo ID", description = "Essa rota busca pelo ID a avaliação cadastrado no banco de dados e retorna seus dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Avaliação encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Avaliação não encontrada")
    })
    public ResponseEntity<?> showRatingById(
            @Parameter(description = "Usuário manda o ID no caminho da requisição")
            @PathVariable UUID id
    ) {
        RatingDTO rating = ratingService.showRatingById(id);
        if (rating != null) {
            return ResponseEntity.ok(rating);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A avaliação com ID " + id + " não foi encontrada.");
        }

    }

    @GetMapping("/list")
    @Operation(summary = "Lista todas as avaliações", description = "Essa rota lista todas as avaliações cadastradas no banco de dados")
    public ResponseEntity<List<RatingDTO>> showAllRatings() {
        List<RatingDTO> ratings = ratingService.showAllRatings();
        return ResponseEntity.ok(ratings);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Atualiza uma avaliação", description = "Essa rota atualiza a avaliação pelo ID no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Avaliação atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Avaliação não encontrada"),
    })
    public ResponseEntity<String> updateRating(
            @Parameter(description = "Usuário manda o ID no caminho da requisição")
            @PathVariable UUID id,
            @Parameter(description = "Usuário manda os dados da avaliação a ser atualizada no corpo da requisição")
            @RequestBody
            RatingDTO rating) {
        if (ratingService.showRatingById(id) != null){
            RatingDTO ratingSelected = ratingService.updateRating(id, rating);
            return ResponseEntity.ok("A avaliação foi atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A avaliação com ID " + id + " não foi encontrada.");
        }
    }

}
