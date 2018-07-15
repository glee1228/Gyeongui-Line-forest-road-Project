package domain;

public class WalkerDTO {
	private String id;
	private String name;
	private double lat;
	private double lng;
	private boolean hasacar;
	
	public WalkerDTO() {};
	public WalkerDTO(String id, String name, double lat, double lng, boolean hasacar) {
		super();
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.hasacar = hasacar;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public boolean isHasacar() {
		return hasacar;
	}
	public void setHasacar(boolean hasacar) {
		this.hasacar = hasacar;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WalkerDTO [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", lat=");
		builder.append(lat);
		builder.append(", lng=");
		builder.append(lng);
		builder.append(", hasacar=");
		builder.append(hasacar);
		builder.append("]");
		return builder.toString();
	}
	
}
