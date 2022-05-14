package draft1.TheArenaApp1.core.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import draft1.TheArenaApp1.entities.model.Player;
import lombok.Data;
import org.checkerframework.common.aliasing.qual.Unique;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "user",uniqueConstraints={
        @UniqueConstraint(columnNames = "user_email")})
@Data
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

    public User(int id, String username, String password, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled, Player playerLink) {
        this.userId = id;
        this.username = username;
        this.password = password;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.playerLink = playerLink;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
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



