package draft1.TheArenaApp1.core.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import draft1.TheArenaApp1.core.utils.CustomDeserializer;
import draft1.TheArenaApp1.entities.model.Pitch;
import draft1.TheArenaApp1.entities.model.Player;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.*;


@Entity
@Table(name = "user",uniqueConstraints={
        @UniqueConstraint(columnNames = "user_email")})
@Getter
@Setter
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","userPitches"})

public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @JsonIgnore
    private int userId;
    @NotBlank(message = "Username can not be empty")
    @Column(name = "user_username",unique = true)
    private String username;
    @NotBlank(message = "Password can not be empty")
    @Column(name = "user_password")
    private String password;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email can not be empty")
    @Column(name = "user_email",unique = true)
    private String email;

    //@OneToMany(mappedBy = "grantedAuthorities")
    @Transient
    @JsonIgnore
    @JsonDeserialize(using = CustomDeserializer.class)
    private List<? extends GrantedAuthority> grantedAuthorities;

    @Column(name = "role")
    private UserRole userRole;

    @OneToMany(mappedBy = "userPitch")
    private List<Pitch> userPitches;

    @Column(name = "isAccountNonExpired")
    private boolean isAccountNonExpired;

    @Column(name = "isAccountNonLocked")
    private boolean isAccountNonLocked;

    @Column(name = "isCredentialsNonExpired")
    private boolean isCredentialsNonExpired;

    @Column(name = "isEnabled")
    private boolean isEnabled;


    @OneToOne(
            mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade =  CascadeType.MERGE,
            orphanRemoval = true
            )
    @JsonIgnore
    private Player playerLink;

    public User() {
    }

    public User(int userId, String username, String password, String email, UserRole userRole, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled, Player playerLink) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.playerLink = playerLink;
    }

    @JsonDeserialize(using = CustomDeserializer.class)
    @Override
    //@JsonDeserialize(using = CustomDeserializer.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set <? extends GrantedAuthority> authorities = userRole.getGrantedAuthorities();

        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getField(String fieldName){

        if (fieldName.equals("username")){

            return "username";

        }
        else if(fieldName.equals("email")) {

            return "email";

        }
        else return "error on";

    }
}



