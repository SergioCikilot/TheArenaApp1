package draft1.TheArenaApp1.entities;

import javax.persistence.*;
import java.time.LocalDate;


    @Entity
    @Table(name="player")
    public class Player {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="player_id")
        private int id;
        @Column(name="player_playerName")
        private String playerName;
        @Column(name="player_sirName")
        private String playerSirName;
        @Column(name="player_birthDate")
        private LocalDate birthdate;
        //@Column(name="player_age")
        //private Age age;
        @Column(name="player_imageLink")
        private String imageLink;
        @Column(name="player_address")
        private String address;
        @Column(name="player_addressLink")
        private String addressLink;

        public Player(){}

        public Player(
                int id,
                String playerName,
                String playerSirName,
                LocalDate birthdate,
                String imageLink,
                String address,
                String addressLink) {

            this.id = id;
            this.playerName = playerName;
            this.playerSirName = playerSirName;
            this.birthdate = birthdate;
            this.imageLink = imageLink;
            this.address = address;
            this.addressLink = addressLink;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public String getPlayerSirName() {
            return playerSirName;
        }

        public void setPlayerSirName(String playerSirName) {
            this.playerSirName = playerSirName;
        }

        public LocalDate getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
        }

        public String getImageLink() {
            return imageLink;
        }

        public void setImageLink(String imageLink) {
            this.imageLink = imageLink;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddressLink() {
            return addressLink;
        }

        public void setAddressLink(String addressLink) {
            this.addressLink = addressLink;
        }
    }



