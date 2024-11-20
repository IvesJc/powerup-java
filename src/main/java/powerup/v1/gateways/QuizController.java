package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.QuizRequestDto;
import powerup.v1.dtos.response.QuizResponseDto;
import powerup.v1.entities.Quiz;
import powerup.v1.usecases.QuizService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/quiz/")
@Tag(name = "Quiz", description = "Endpoints destinados para a classe Quiz")
public class QuizController {

    private final QuizService quizService;

    @PostMapping
    public ResponseEntity<QuizRequestDto> create(@RequestBody QuizResponseDto quiz) {
        QuizRequestDto createdQuiz = quizService.create(quiz);
        return new ResponseEntity<>(createdQuiz, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuizRequestDto>> getAll() {
        List<QuizRequestDto> quizList = quizService.getAll();
        return new ResponseEntity<>(quizList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizRequestDto> getById(@PathVariable Integer id) {
        QuizRequestDto quiz = quizService.getById(id);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizRequestDto> update(@PathVariable Integer id, @RequestBody QuizResponseDto quiz) {
        QuizRequestDto updatedQuiz = quizService.update(id, quiz);
        return new ResponseEntity<>(updatedQuiz, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        quizService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
