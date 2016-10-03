package users;

public class Admin extends User{
	private String password;
	private String login;
	
	public Admin() {
		super();
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Admin [password=" + password + ", login=" + login + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getSurname()=" + getSurname() + ", getAddres()=" + getAddres() + ", getClazz()=" + getClazz()
				+ ", getList()=" + getList() + ", getMap()=" + getMap() + "]";
	}

	
	
}
