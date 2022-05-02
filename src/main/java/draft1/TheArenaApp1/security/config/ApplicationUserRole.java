package draft1.TheArenaApp1.security.config;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;





    public enum ApplicationUserRole implements GrantedAuthority {

        ROLE_USER,
        ROLE_ADMIN;

        @Override
        public String getAuthority() {
            return name();
        }
    }



