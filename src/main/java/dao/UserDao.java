package dao;

import java.sql.*;
import java.util.HashMap;
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
    public Map<String, String> getGrade(String username, String password) {
        Map<String, String> result = new HashMap<String, String>();
        Connection con = JDBCUtil.getCon();
        try {
            PreparedStatement pstmt = con.prepareStatement("select grade,courseName from grade,course,student where student.username=grade.username and grade.courseId=course.courseId and student.username=? and student.password=?;");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                result.put(rs.getString("courseName"), rs.getString("grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
