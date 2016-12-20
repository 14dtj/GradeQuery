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
            PreparedStatement pstmt = con.prepareStatement("select grade,courseName from grade,course,student where student.username=grade.username and grade.courseId=course.courseId and student.username=? and student.password=?;");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
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
