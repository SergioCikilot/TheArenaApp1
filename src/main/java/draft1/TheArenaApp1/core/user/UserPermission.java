package draft1.TheArenaApp1.core.user;

public enum UserPermission {

    A_READ("a:read"),
    A_WRITE("a:write"),
    U_WRITE("u:write"),
    U_READ("u:read");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
