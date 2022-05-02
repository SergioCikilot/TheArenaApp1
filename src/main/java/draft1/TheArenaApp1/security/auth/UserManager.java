package draft1.TheArenaApp1.security.auth;

import draft1.TheArenaApp1.security.config.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;
    private PasswordConfig passwordConfig;


    @Autowired
    public UserManager(UserDao userDao,PasswordConfig passwordConfig) {

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

    public void add(User user) {

        user.setPassword(passwordConfig.passwordEncoder().encode(user.getPassword()));
        this.userDao.save(user);

    }


    public void delete(User user) {

        this.userDao.delete(user);

    }


    public List<User> getAll() {
        return this.userDao.findAll();
    }




}
