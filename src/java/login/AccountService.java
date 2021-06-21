
package login;
import users.Users;

/**
 *
 * @author m-navarro
 */
public class AccountService {
    
    
    public Users login (String username, String password){
    
        
        if(username.equals("adam") || username.equals("betty") && password.equals("password")){
            return new Users(username,null);
        }
        return null;
            
           
    }
    
}
