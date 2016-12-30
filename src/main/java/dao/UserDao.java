package dao;

import model.Grade;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tjDu on 2016/12/18.
 */
public class UserDao {
    private static UserDao userDao;

    public static UserDao getInstance() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    /**
     * 根据登录名获得学生成绩
     *
     * @param username
     * @return
     */
    public List<Grade> getGrade(String username, String password) {
        List<Grade> result = new ArrayList<Grade>();
        Connection con = JDBCUtil.getCon();
        try {
            PreparedStatement state = con.prepareStatement("select grade,courseName from grade,course,student where student.username=grade.username and grade.courseId=course.courseId and student.username=? and student.password=?;");
            state.setString(1, username);
            state.setString(2, password);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                Grade grade = new Grade();
                grade.setCourse(rs.getString("courseName"));
                grade.setGrade(rs.getDouble("grade"));
                result.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
