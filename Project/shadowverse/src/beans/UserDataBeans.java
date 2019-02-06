package beans;

import java.io.Serializable;

public class UserDataBeans implements Serializable {
	private String name;
	private String address;
	private String password;
	private int id;

	public UserDataBeans(String name,String address) {
		this.name = name;
		this.address =address;
	}
	public UserDataBeans(int id,String name,String address,String password) {
		this.id=id;
		this.name=name;
		this.address=address;
		this.password=password;
	}
	// コンストラクタ
	public UserDataBeans() {
		this.name = "";
		this.address = "";
		this.password = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}