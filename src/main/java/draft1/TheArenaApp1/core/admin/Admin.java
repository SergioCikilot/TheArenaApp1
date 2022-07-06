package draft1.TheArenaApp1.core.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import draft1.TheArenaApp1.entities.model.Player;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;


public class Admin implements UserDetails {

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

    /*@Transient
    private Set<? extends GrantedAuthority> grantedAuthorities;*/

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

    public Admin() {
    }

    public Admin(int userId, String username, String password, String email, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled, Player playerLink) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
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
