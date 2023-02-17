package dto;

public class ContactDTO {

	private int contact_no;
	private String name;
	private String TEL;
	private String email;
	private String address;
	
	// 소스에서 유징필드
	public ContactDTO() { }

	public ContactDTO(int contact_no, String name, String tEL, String email, String address) {
		super();
		this.contact_no = contact_no;
		this.name = name;
		TEL = tEL;
		this.email = email;
		this.address = address;
	}


	public int getContact_no() {
		return contact_no;
	}

	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTEL() {
		return TEL;
	}

	public void setTEL(String tEL) {
		TEL = tEL;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "ContactDTO [contact_no=" + contact_no + ", name=" + name + ", TEL=" + TEL + ", email=" + email
				+ ", address=" + address + "]";
	}
	
}
