package boundries;

public class UserProfile {

	String userName;
	String password;
	
	public UserProfile(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public String getPassword(){
		return password;
	}
}
