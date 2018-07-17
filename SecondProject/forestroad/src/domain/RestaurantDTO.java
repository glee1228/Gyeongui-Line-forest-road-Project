package domain;

public class RestaurantDTO extends PlaceDTO {
	private String district;
	private String address;
	private String phone;
	
	public RestaurantDTO() {};
	public RestaurantDTO(String district, String address, String phone) {
		super();
		this.district = district;
		this.address = address;
		this.phone = phone;
	}
	public RestaurantDTO(String id, String name, String type, String usage, 
			double distance,String district, String address, String phone)
	{
		super();
		this.setId(id);
		this.setName(name);
		this.setType(type);
		this.setUsage(usage);
		this.setDistance(distance);
		this.district = district;
		this.address = address;
		this.phone = phone;
	};
	
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
		builder.append(", 전화번호=");
		builder.append(phone);
		builder.append(" ");
		return builder.toString();
	}
	
	
	
}
