package domain;

public class CustomerDTO {
	private String cusid;
	private String cuspw;
	private String cusname;
	public CustomerDTO(String cusid,String cuspw) {
		this.cusid=cusid;
		this.cuspw=cuspw;
	}
	public CustomerDTO(String cusid, String cuspw, String cusname) {
		this.cusid = cusid;
		this.cuspw = cuspw;
		this.cusname = cusname;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public String getCuspw() {
		return cuspw;
	}
	public void setCuspw(String cuspw) {
		this.cuspw = cuspw;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("�� ���̵�=");
		builder.append(cusid);
		builder.append(", ��й�ȣ=");
		builder.append(cuspw);
		builder.append(", �̸�=");
		builder.append(cusname);
		
		return builder.toString();
	}
	
	
	
	
}
