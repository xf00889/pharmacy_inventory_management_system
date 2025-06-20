/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_management_system;

/**
 *
 * @author Mariz
 */
public class UserSession {

    
    
 private static UserSession instance;
    private boolean isLoggedIn;
    private String userType;

    private UserSession() {
        isLoggedIn = false;
        userType = "";
         
    }
public void logout() {
    isLoggedIn = false;
    userType = "";
}

    public static synchronized UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
        
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    
}
