package draft1.TheArenaApp1.core.user;

import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;
import draft1.TheArenaApp1.security.config.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;
    private PasswordConfig passwordConfig;

    @Autowired
    public UserManager(UserDao userDao, PasswordConfig passwordConfig) {

        this.userDao = userDao;
        this.passwordConfig = passwordConfig;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao
                .findUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );
    }



    public void add(User user) throws Exception {

        user.setPassword(passwordConfig.passwordEncoder().encode(user.getPassword()));

        List<User> listForEmail = this.userDao.findUsersByEmail(user.getEmail());
        boolean emailExists = !listForEmail.isEmpty();
        List<User> listForUsername = this.userDao.findUsersByUsername(user.getUsername());
        boolean usernameExists = !listForUsername.isEmpty();
        if (usernameExists && emailExists) {

            throw new Exception("Email and username are already exist");

        } else if (usernameExists) {

            throw new Exception("Username is already exists");

        } else if (emailExists) {

            throw new Exception("Email is already exists");

        } else this.userDao.save(user);

    }

    public void delete(User user) {

        this.userDao.delete(user);

    }

    public List<User> getAll() {
        return this.userDao.findAll();
    }


}

