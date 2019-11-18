import java.io.Serializable;

public class User implements Serializable{
    private String username;
    private String password;
    private String privilege;

    public void setUsername(String username) throws EmptyFieldException{
        if (username == null || username.length() == 0)
			throw new EmptyFieldException ("Please enter a username");
        this.username = username;
    }
    public void setPassword(String password) throws EmptyFieldException{
        if (password == null || password.length() == 0)
			throw new EmptyFieldException ("Please enter a password");
        this.password = password;
    }
    public void setPrivilege(String privilege) throws EmptyFieldException{
        if (privilege == null || privilege.length() == 0)
			throw new EmptyFieldException ("Please select a privilege");
        this.privilege = privilege;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getPrivilege() {
        return privilege;
    }
    public String toString() {
		return username + " (" + privilege + ")";
	}
}