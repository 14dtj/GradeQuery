package service;

import dao.DaoFactory;
import model.Grade;

import java.util.List;

/**
 * Created by tjDu on 2016/12/30.
 */
public class UserService {
    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    /**
     * 根据登录名获得学生成绩
     * @param username
     * @param password
     * @return
     */
    public List<Grade> getGrade(String username, String password) {
        return DaoFactory.getUserDao().getGrade(username, password);
    }
}
