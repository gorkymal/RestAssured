package ReqresIn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties (ignoreUnknown = true)
@FieldDefaults (level = AccessLevel.PRIVATE)

public class SuccessReg {
    String name;
    String job;
    int id;
    String createdAt;
}














