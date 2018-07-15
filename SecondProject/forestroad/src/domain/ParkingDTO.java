package domain;

public class ParkingDTO extends PlaceDTO{
	private String id;
	private String parkid;
	private String district;
	private String address;
	private int volume;
	private String phone;
	
	public ParkingDTO() {};
	public ParkingDTO(String id, String parkid, String district, String address, int volume, String phone) {
		super();
		this.id = id;
		this.parkid = parkid;
		this.district = district;
		this.address = address;
		this.volume = volume;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParkid() {
		return parkid;
	}
	public void setParkid(String parkid) {
		this.parkid = parkid;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParkingDTO [id=");
		builder.append(id);
		builder.append(", parkid=");
		builder.append(parkid);
		builder.append(", district=");
		builder.append(district);
		builder.append(", address=");
		builder.append(address);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", phone=");
		builder.append(phone);
		builder.append("]");
		return builder.toString();
	}
	
	
}
