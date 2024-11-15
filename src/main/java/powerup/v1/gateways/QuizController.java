package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.QuizDto;
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
    public ResponseEntity<QuizDto> create(@RequestBody Quiz quiz) {
        QuizDto createdQuiz = quizService.create(quiz);
        return new ResponseEntity<>(createdQuiz, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuizDto>> getAll() {
        List<QuizDto> quizList = quizService.getAll();
        return new ResponseEntity<>(quizList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDto> getById(@PathVariable Integer id) {
        QuizDto quiz = quizService.getById(id);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizDto> update(@PathVariable Integer id, @RequestBody Quiz quiz) {
        QuizDto updatedQuiz = quizService.update(id, quiz);
        return new ResponseEntity<>(updatedQuiz, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        quizService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
