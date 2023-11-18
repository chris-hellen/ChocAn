package accounts;

public class Manager {
	private String name;
	private String username;
	private String password;

	public Manager(String name, String username, String password){
        this.name = name;
		this.username= username;
		this.password = password;
    }

	public String getName() {
        return name;
    }
	public String getUsername() {
        return username;
    }
	
	public String getPassword() {
        return password;
    }

	public void setManagerCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}
}