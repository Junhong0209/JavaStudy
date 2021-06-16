package kr.hs.dgsw.java.c2.programming_test.AddressBook;

public class NameCard {
	
	public int id;
	
	public String name;
	
	public String phoneNumber;
	
	public String address;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("{");
		buffer.append("'id' : " + id).append(", ");
		buffer.append("'name' : '" + name).append("', ");
		buffer.append("'phoneNumber' : '" + phoneNumber).append("', ");
		buffer.append("'address' : '" + address);
		buffer.append("}");
		
		return buffer.toString();
	}
}

