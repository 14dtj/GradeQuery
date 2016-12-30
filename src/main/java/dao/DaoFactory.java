package dao;

/**
 * Created by tjDu on 2016/12/19.
 */
public class DaoFactory {

    public static UserDao getUserDao() {
        return UserDao.getInstance();
    }
}
