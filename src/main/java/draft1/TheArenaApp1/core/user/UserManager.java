package draft1.TheArenaApp1.core.user;

import draft1.TheArenaApp1.core.exceptions.ExistingEntryException;
import draft1.TheArenaApp1.repository.UserDao;
import draft1.TheArenaApp1.security.config.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManager implements UserService {

    private final UserDao userDao;
    private final PasswordConfig passwordConfig;

    //cons--------------------------------------------------------------------------------------------------------------
    @Autowired
    public UserManager(UserDao userDao, PasswordConfig passwordConfig) {

        this.userDao = userDao;
        this.passwordConfig = passwordConfig;
    }
    //add---------------------------------------------------------------------------------------------------------------
    public void add(User user) throws Exception {
        //Re-write
        user.setPassword(
                passwordConfig
                        .passwordEncoder()
                        .encode(
                                user.getPassword()));
        List<User> listForEmail = this.userDao
                .findUsersByEmail(
                        user.getEmail());
        boolean emailExists = !listForEmail
                .isEmpty();
        List<User> listForUsername = this.userDao
                .findUsersByUsername(
                        user.getUsername());
        boolean usernameExists = !listForUsername
                .isEmpty();
        ArrayList<String> list = new ArrayList<>();

        if (usernameExists && emailExists) {
            list.add(
                    user.getField("username"));
            list.add(
                    user.getField("email"));
            throw new ExistingEntryException("Username and email are already exists",list);


        } else if (usernameExists) {
            list.add(
                    user.getField("username"));
            throw new ExistingEntryException("Username is already exists", list);


        } else if (emailExists) {
            list.add(
                    user.getField("email"));
            throw new ExistingEntryException("Email is already exists", list);
        }
        else
            this.userDao
                    .save(user);
    }
    //delete------------------------------------------------------------------------------------------------------------
    public void delete(User user) {
        this.userDao
                .delete(user);

    }
    //get---------------------------------------------------------------------------------------------------------------
    public List<User> getAll() {
        return this.userDao
                .findAll();
    }
    @Override
    public User findUserByUsername(String username) {
        return this.userDao.findUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format("Username %s not found", username)));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao
                .findUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format("Username %s not found", username)));
    }
}

