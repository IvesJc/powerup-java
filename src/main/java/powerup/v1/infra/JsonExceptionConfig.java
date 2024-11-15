package powerup.v1.infra;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JsonExceptionConfig {

    private HttpStatus httpStatus;
    private Integer statusCode;
    private String message;
}