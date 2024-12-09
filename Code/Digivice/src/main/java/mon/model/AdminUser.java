package mon.model;

/**
 * Esta clase representa al usuario Admin, el cual tiene el poder de
 * editar la información en la base de datos
 */

public class AdminUser {
    private final String userName;
    private final String userPassword;

    public AdminUser(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
 }
