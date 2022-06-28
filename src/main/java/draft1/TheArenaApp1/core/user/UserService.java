package draft1.TheArenaApp1.core.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

public interface UserService extends UserDetailsService {

    void add(User user) throws Exception;
    void delete(User user);
    List<User> getAll();
    User findUserByUsername(String username);
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;








}
