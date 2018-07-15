package domain;

public class Pk_TimeTableDTO extends ParkingDTO{
	private String parkid;
	private String wd_start;
	private String wd_end;
	private String we_start;
	private String we_end;
	private String hd_start;
	private String hd_end;
	private int fee_start;
	private int time_start;
	private int fee_unit;
	private int time_unit;
	public Pk_TimeTableDTO() {};
	public Pk_TimeTableDTO(String parkid, String wd_start, String wd_end, String we_start, String we_end,
			String hd_start, String hd_end, int fee_start, int time_start, int fee_unit, int time_unit) {
		super();
		this.parkid = parkid;
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
	public String getParkid() {
		return parkid;
	}
	public void setParkid(String parkid) {
		this.parkid = parkid;
	}
	public String getWd_start() {
		return wd_start;
	}
	public void setWd_start(String wd_start) {
		this.wd_start = wd_start;
	}
	public String getWd_end() {
		return wd_end;
	}
	public void setWd_end(String wd_end) {
		this.wd_end = wd_end;
	}
	public String getWe_start() {
		return we_start;
	}
	public void setWe_start(String we_start) {
		this.we_start = we_start;
	}
	public String getWe_end() {
		return we_end;
	}
	public void setWe_end(String we_end) {
		this.we_end = we_end;
	}
	public String getHd_start() {
		return hd_start;
	}
	public void setHd_start(String hd_start) {
		this.hd_start = hd_start;
	}
	public String getHd_end() {
		return hd_end;
	}
	public void setHd_end(String hd_end) {
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
		builder.append("Pk_TimeTableDTO [parkid=");
		builder.append(parkid);
		builder.append(", wd_start=");
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
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
