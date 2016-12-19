package dao;

/**
 * Created by tjDu on 2016/12/19.
 */
public class DaoFactory {
    private static UserDao userDao;

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }
}
