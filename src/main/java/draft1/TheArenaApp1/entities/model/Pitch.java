package draft1.TheArenaApp1.entities.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import draft1.TheArenaApp1.core.entities.comments.Comment;
import draft1.TheArenaApp1.core.entities.ratings.PitchRating;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

import java.util.List;


    @Entity
    @Table(name="pitches")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","reservations","remarkedComments","remarkedRatings"})

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

        @Column(name = "pitch_rating")
        private double pitchRatingAvg;

        @Column(name = "pitch_price")
        private BigDecimal pitchPrice;

        @Column(name = "pitch_imageLink")
        private String pitchImageLink; //!!!

        @Column(name = "pitch_openingTime")
        private String pitchOpeningTime;

        @Column(name = "pitch_closingTime")
        private String pitchClosingTime;

        @Column(name = "pitch_matchDuration")
        private String pitchMatchDuration;

        @Column(name = "pitch_xCoordinate")
        private double pitchXCoordinate;

        @Column(name = "pitch_yCoordinate")
        private double pitchYCoordinate;

        @Column(name = "pitchLength")
        private int pitchLength;

        @Column(name = "pitch_isIllumination")
        private boolean pitchIsIllumination;

        @Column(name = "pitch_isCamera")
        private boolean pitchIsCamera;

        @OneToMany(mappedBy = "pitch")
        private List<Comment> receivedComments;

        @OneToMany(mappedBy = "pitch")
        private List<PitchRating> receivedRatings;

        @OneToMany(mappedBy = "pitch")
        private List<Reservation> reservations;

        //players looking for

    }

