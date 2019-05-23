import java.io.Serializable;

public class Input implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userid;
	private String password;
	private String email;

	Input() {
	};

	Input(String userid, String password, String email) {
		this.userid = userid;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "userid:" + userid + "\npassword: " + password + "\nemail: " + email;
	}
}