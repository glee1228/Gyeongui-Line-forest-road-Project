package domain;

public class ParkingDTO extends PlaceDTO{
	private String parkid;
	private String district;
	private String address;
	private int volume;
	private String phone;
	
	public ParkingDTO() {
		super();
	};
	public ParkingDTO(String id,String name,String usage, String district, String address,String phone,int volume,double distance) {
		this.setId(id);
		this.setName(name);
		this.setUsage(usage);
		this.district = district;
		this.address = address;
		this.phone = phone;
		this.volume=volume;
		this.setDistance(distance);
	}
	public ParkingDTO( String parkid, String district, String address, int volume, String phone) {
		super();
		this.parkid = parkid;
		this.district = district;
		this.address = address;
		this.volume = volume;
		this.phone = phone;
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
		builder.append(super.toString());
		builder.append("지역구=");
		builder.append(district);
		builder.append(", 주소=");
		builder.append(address);
		builder.append(", 주차 차량 가능 수=");
		builder.append(volume);
		builder.append(", 전화 번호=");
		builder.append(phone);
		return builder.toString();
	}

	
	
}
