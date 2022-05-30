package draft1.TheArenaApp1.entities.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PitchPic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pitchPic_id")
    private int pitchPicId;

    @Column(name = "pitchPic_Url")
    private String pitchPicUrl;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="pitch_id")
    private Pitch pitch;

}
