package draft1.TheArenaApp1.security.model;

import org.springframework.security.core.GrantedAuthority;


public enum ApplicationUserRole implements GrantedAuthority {

        ROLE_USER,
        ROLE_ADMIN;

        @Override
        public String getAuthority() {
            return name();
        }
    }



