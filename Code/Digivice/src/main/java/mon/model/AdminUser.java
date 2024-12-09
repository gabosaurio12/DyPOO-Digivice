package mon.model;

/**
 * Esta clase representa al usuario Admin, el cual tiene el poder de
 * editar la información en la base de datos
 */

public class AdminUser {
    private String userName;
    private String userPassword;

    public AdminUser(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
}
