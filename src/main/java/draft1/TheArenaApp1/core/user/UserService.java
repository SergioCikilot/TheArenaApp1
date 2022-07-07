package draft1.TheArenaApp1.core.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    void add(User user) throws Exception;
    void delete(User user);
    List<User> getAll();
    User findUserByUsername(String username);
    User findUserByUserId(int id);
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    @Transactional
    void addPitchesToUser(List<Integer> pitchesId, String userName);
}
