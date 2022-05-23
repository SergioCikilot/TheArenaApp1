package draft1.TheArenaApp1.entities.dto.PitchDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PitchDto {

    private int pitchId;

    private String pitchName;

    private String pitchAddress;

    private String pitchAddressLink;

    private int pitchRating;

    private BigDecimal pitchPrice;

    private String pitchImageLink; //!!!

    private String pitchOpeningTime;

    private String pitchClosingTime;

    private String pitchMatchDuration;

    private double pitchXCoordinate;

    private double pitchYCoordinate;

    private int pitchLength;

    private boolean pitchIsIllumination;

    private boolean pitchIsCamera;

}
