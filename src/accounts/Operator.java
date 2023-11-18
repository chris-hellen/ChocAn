//@Author Colin Klich
package accounts;

public class Operator {
	private String name;
	private String username;
	private String password;

	public Operator(String name, String username, String password){
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

	public void setOperatorCredentials(String username, String password) {
    this.username = username;
	this.password = password;
    }

}