package users;

public class Address {
	private String cyti;
	private String country;
	private String street;
	private int houseNumber;
	private int flat;
	
	
	public Address() {
		super();
	}
	
	public String getCyti() {
		return cyti;
	}
	public void setCyti(String cyti) {
		this.cyti = cyti;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public int getFlat() {
		return flat;
	}
	public void setFlat(int flat) {
		this.flat = flat;
	}

	@Override
	public String toString() {
		return "Address [cyti=" + cyti + ", country=" + country + ", street=" + street + ", houseNumber=" + houseNumber
				+ ", flat=" + flat + "]";
	}
	
	
}
