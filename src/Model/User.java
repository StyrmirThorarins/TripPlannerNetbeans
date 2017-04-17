package Model;

/**
 * Created by Styrmir on 22.3.2017.
 */
public class User {
	// I think id should be final, if we need
	// a new profile we need to create new instance
	// Recommend negative int for id for "fake" profiles
	private final int id;
	private String name;
	private char sex;
	private String address;
	private String email;
	private String phone;
	private String nationality;
        
        // preference settings
        private String preferences;        


	public User(int id) {
		this.id = id;	
	};

	// setters, getters
	public int getId() {
		return this.id;
	}

	// public void setId(int id){
	// this.id = id;
	// }

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return this.sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
            if (this.phone == null) {
                return "0";
            }
		return this.phone;
	}

	public void setPhone(String phone) {
		this.name = phone;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPreferences() {
		return this.preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}                
}
