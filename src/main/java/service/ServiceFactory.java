package service;

/**
 * Created by tjDu on 2016/12/30.
 */
public class ServiceFactory {

    public static UserService getUserService() {
        return UserService.getInstance();
    }
}
