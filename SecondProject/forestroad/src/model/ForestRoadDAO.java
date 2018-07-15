package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.RestaurantDTO;
import domain.WalkerDTO;
import util.DButil;

public class ForestRoadDAO {

	//�˻����
	//������ �˻� - �� M�̳��� �ִ� �������� �˻��ұ��? 
	//walkerDTO, int meter�Է��Ͽ� ������ ���� ��ȯ
	//-> ���� ������ �Է��ϼ���.
	public static ArrayList<RestaurantDTO> getNearRestaurants(WalkerDTO walker,int meter) throws Exception{
		Connection con =null;
		PreparedStatement pstmt =null;
		String sql = "select p.id, p.name, p.type, p.usage, p.lat, p.lng, r.district, r.address, r.phone "
				+ "from place p, restaurant r "
				+ "where p.id=r.id and p.type='restaurant' and sqrt(power((p.lat-?),2)+power((p.lng-?),2))<?";
		

		ResultSet rs = null;
		double meterToLoc = 0;
		meterToLoc = (double)meter *0.00001;
		ArrayList<RestaurantDTO> datas = new ArrayList<RestaurantDTO>();
		try {
			con = DButil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1,walker.getLat());
			pstmt.setDouble(2, walker.getLng());
			pstmt.setDouble(3,meterToLoc);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				datas.add(new RestaurantDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),
						rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getString(9)));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DButil.close(con,pstmt,rs);
		}
		
		return datas;
		
	}
	
		
		//ȭ��� �˻� - �� M �̳��� �ִ� ȭ����� �˻��ұ��?
		//����DTO, int meter�� �Է��Ͽ� select p.name,p.type,p.usage from place p where p.type='restroom' and sqrt(pow((p.lat-userDTO.lat),2)+pow((p.lng-userDTO.lng),2))<meter; 
		
		//������ �˻� - ��ñ��� ������ �� �����̽Ű���? -> �� M �̳��� �ִ� �������� �˻��ұ��? -> **M �̳��� ����� �������� ���� N�� �ֽ��ϴ�. 
		//����DTO, int endtime,int meter�� �Է��Ͽ�
		//select sum(id) from place p , parking pk, pk_timetable pkt group by p.id having p.id=pk.id and pk.parkid=pkt.parkid and p.type='parking' and pkt_timetable.we_end<=any(select to_date(sysdate,'HH24MI') sys_date24 from dual);
		
		//����� ������ �����ϴ�. 
		




		//����ð����� ������ ���, ������ ������ ���Դϴ�.
		 

	//�������
	//����DTO�� �Է��Ͽ� delete from user where userDTO.id=id ;
	
	//���Ա��
	//������ ��� �� ��Ϲ��� ������ UserDTO�� ������ �� insert into user ( id,name,lat,lng,hasacar) values( ?,?,?,?,?);
	
	//�������
	//������ ��ġ ������ ��, update user set lat=? where id=dto.id ; update user set lng=? where id=dto.id;
	
	

	//������ ���� ��, ȸ������ update
	//������ ��� ��, ȸ�����̺� insert -> id,name,����ġ ����(1~14�� ����), ���� ���� ����, 
	//������ ���� ��, id�� ȸ�����̺� delete

}
