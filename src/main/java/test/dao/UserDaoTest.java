package test.dao;

import dao.UserDao;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * UserDao Tester.
 *
 * @author <tj>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 19, 2016</pre>
 */
public class UserDaoTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getGrade(String username)
     */
    @Test
    public void testGetGrade() throws Exception {
        UserDao dao = new UserDao();
        System.out.print(dao.getGrade("tj","123456"));
    }


} 
