package draft1.TheArenaApp1.entities.dto.UserDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithEmailDto {

    private int id;
    private String email;

}
