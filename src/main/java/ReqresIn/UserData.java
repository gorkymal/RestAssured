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
@FieldDefaults (level = AccessLevel.PRIVATE)
@JsonIgnoreProperties (ignoreUnknown = true)

public class UserData {
    int id;
    String email;
    String first_name;
    String last_name;
    String avatar;
}
