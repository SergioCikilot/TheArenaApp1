package draft1.TheArenaApp1.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;


    @Entity
    @Table(name="pitches")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","reservations"})

    public class Pitch {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "pitch_id")
        private int pitchId;

        @Column(name = "pitch_name")
        private String pitchName;

        @Column(name = "pitch_address")
        private String pitchAddress;

        @Column(name = "pitch_addressLink")
        private String pitchAddressLink;

        @Column(name = "pitch_price")
        private BigDecimal pitchPrice;

        @Column(name = "pitch_imageLink")
        private String pitchImageLink; //!!!

        @JsonFormat(pattern = "HH:mm:ss")
        @DateTimeFormat(pattern = "HH:mm:ss")
        @Column(name = "pitch_openingTime")
        private LocalTime pitchOpeningTime;

        @JsonFormat(pattern = "HH:mm:ss")
        @DateTimeFormat(pattern = "HH:mm:ss")
        @Column(name = "pitch_closingTime")
        private LocalTime pitchClosingTime;

        @JsonFormat(pattern = "HH:mm:ss")
        @DateTimeFormat(pattern = "HH:mm:ss")
        @Column(name = "pitch_matchDuration")
        private LocalTime pitchMatchDuration;

        @Column(name = "pitch_xCoordinate")
        private int pitchXCoordinate;

        @Column(name = "pitch_yCoordinate")
        private int pitchYCoordinate;

        @Column(name = "pitchLength")
        private int pitchLength;

        @Column(name = "pitch_isIllumination")
        private boolean pitchIsIllumination;

        @Column(name = "pitch_isCamera")
        private boolean pitchIsCamera;

        @OneToMany(mappedBy = "pitch")
        private List<Reservation> reservations;

        //players looking for

    }

