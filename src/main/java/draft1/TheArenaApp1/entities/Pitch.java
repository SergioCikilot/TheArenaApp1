package draft1.TheArenaApp1.entities;

import javax.persistence.*;
import java.math.BigDecimal;


    @Entity
    @Table(name = "pitch")

    public class Pitch {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "pitch_id")
        private int id;
        @Column(name = "pitch_name")
        private String pitchName;
        @Column(name = "pitch_address")
        private String address;
        @Column(name = "pitch_addressLink")
        private String addressLink;
        @Column(name = "pitch_price")
        private BigDecimal price;
        @Column(name = "pitch_imageLink")
        private String imageLink; //!!!
        @Column(name = "pitch_openingTime")
        private String openingTime;
        @Column(name = "pitch_closingTime")
        private String closingTime;
        @Column(name = "pitch_isIllumination")
        private boolean isIllumination;
        @Column(name = "pitch_isCamera")
        private boolean isCamera;
        //location coordinates
        //length of the pitch
        //rezervations
        //players looking for


        public Pitch() {
        }

        public Pitch(
                int id,
                String pitchName,
                String address,
                String addressLink,
                BigDecimal price,
                String imageLink,
                String openingTime,
                String closingTime,
                boolean isIllumination,
                boolean isCamera) {

            this.id = id;
            this.pitchName = pitchName;
            this.address = address;
            this.addressLink = addressLink;
            this.price = price;
            this.imageLink = imageLink;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.isIllumination = isIllumination;
            this.isCamera = isCamera;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPitchName() {
            return pitchName;
        }

        public void setPitchName(String pitchName) {
            this.pitchName = pitchName;
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

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getImageLink() {
            return imageLink;
        }

        public void setImageLink(String imageLink) {
            this.imageLink = imageLink;
        }

        public String getOpeningTime() {
            return openingTime;
        }

        public void setOpeningTime(String openingTime) {
            this.openingTime = openingTime;
        }

        public String getClosingTime() {
            return closingTime;
        }

        public void setClosingTime(String closingTime) {
            this.closingTime = closingTime;
        }

        public boolean isIllumination() {
            return isIllumination;
        }

        public void setIllumination(boolean illumination) {
            isIllumination = illumination;
        }

        public boolean isCamera() {
            return isCamera;
        }

        public void setCamera(boolean camera) {
            isCamera = camera;
        }

    }

