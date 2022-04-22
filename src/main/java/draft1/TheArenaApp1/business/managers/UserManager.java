package draft1.TheArenaApp1.business.managers;

import draft1.TheArenaApp1.business.services.UserService;
import draft1.TheArenaApp1.core.entities.User;
import draft1.TheArenaApp1.dataAccess.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {

        userDao.save(user);

    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }
}
