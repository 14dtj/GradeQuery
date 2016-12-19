package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by tjDu on 2016/12/18.
 */
public class JDBCUtil {
    private static Connection con = null;

    public static Connection getCon() {
        if (con == null) {
            try {
                Context ic = new InitialContext();
                DataSource source = (DataSource) ic.lookup("java:comp/env/jdbc/gradeQuery");
                con = source.getConnection();
            } catch (NamingException e) {
                System.out.println("数据源没找到！");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("获取数连接对象失败！");
                e.printStackTrace();
            }
        }
        return con;
    }

    public static void close() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
