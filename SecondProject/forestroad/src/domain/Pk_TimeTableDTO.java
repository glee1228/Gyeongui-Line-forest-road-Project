package domain;

public class Pk_TimeTableDTO extends ParkingDTO{
	private int wd_start;
	private int wd_end;
	private int we_start;
	private int we_end;
	private int hd_start;
	private int hd_end;
	private int fee_start;
	private int time_start;
	private int fee_unit;
	private int time_unit;
	public Pk_TimeTableDTO() {
		super();
	};
	public Pk_TimeTableDTO(String id,String name,String usage,
			String district,String address,int wd_start,int wd_end) {
		super();
		this.setId(id);
		this.setName(name);
		this.setUsage(usage);
		this.setDistrict(district);
		this.setAddress(address);
		this.wd_start=wd_start;
		this.wd_end=wd_end;
		
	}
	public Pk_TimeTableDTO(int wd_start, int wd_end, int we_start, int we_end,
			int hd_start, int hd_end, int fee_start, int time_start, int fee_unit, int time_unit) {
		super();
		this.wd_start = wd_start;
		this.wd_end = wd_end;
		this.we_start = we_start;
		this.we_end = we_end;
		this.hd_start = hd_start;
		this.hd_end = hd_end;
		this.fee_start = fee_start;
		this.time_start = time_start;
		this.fee_unit = fee_unit;
		this.time_unit = time_unit;
	}
	
	public int getWd_start() {
		return wd_start;
	}
	public void setWd_start(int wd_start) {
		this.wd_start = wd_start;
	}
	public int getWd_end() {
		return wd_end;
	}
	public void setWd_end(int wd_end) {
		this.wd_end = wd_end;
	}
	public int getWe_start() {
		return we_start;
	}
	public void setWe_start(int we_start) {
		this.we_start = we_start;
	}
	public int getWe_end() {
		return we_end;
	}
	public void setWe_end(int we_end) {
		this.we_end = we_end;
	}
	public int getHd_start() {
		return hd_start;
	}
	public void setHd_start(int hd_start) {
		this.hd_start = hd_start;
	}
	public int getHd_end() {
		return hd_end;
	}
	public void setHd_end(int hd_end) {
		this.hd_end = hd_end;
	}
	public int getFee_start() {
		return fee_start;
	}
	public void setFee_start(int fee_start) {
		this.fee_start = fee_start;
	}
	public int getTime_start() {
		return time_start;
	}
	public void setTime_start(int time_start) {
		this.time_start = time_start;
	}
	public int getFee_unit() {
		return fee_unit;
	}
	public void setFee_unit(int fee_unit) {
		this.fee_unit = fee_unit;
	}
	public int getTime_unit() {
		return time_unit;
	}
	public void setTime_unit(int time_unit) {
		this.time_unit = time_unit;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" wd_start=");
		builder.append(wd_start);
		builder.append(", wd_end=");
		builder.append(wd_end);
		builder.append(", we_start=");
		builder.append(we_start);
		builder.append(", we_end=");
		builder.append(we_end);
		builder.append(", hd_start=");
		builder.append(hd_start);
		builder.append(", hd_end=");
		builder.append(hd_end);
		builder.append(", fee_start=");
		builder.append(fee_start);
		builder.append(", time_start=");
		builder.append(time_start);
		builder.append(", fee_unit=");
		builder.append(fee_unit);
		builder.append(", time_unit=");
		builder.append(time_unit);
		builder.append(", getParkid()=");
		builder.append(getParkid());
		builder.append(", getDistrict()=");
		builder.append(getDistrict());
		builder.append(", getAddress()=");
		builder.append(getAddress());
		builder.append(", getVolume()=");
		builder.append(getVolume());
		builder.append(", getPhone()=");
		builder.append(getPhone());
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getName()=");
		builder.append(getName());
		builder.append(", getType()=");
		builder.append(getType());
		builder.append(", getUsage()=");
		builder.append(getUsage());
		builder.append(", getLat()=");
		builder.append(getLat());
		builder.append(", getLng()=");
		builder.append(getLng());
		return builder.toString();
	}

	
	
	
	
}
