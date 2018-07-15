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

	//검색기능
	//음식점 검색 - 몇 M이내에 있는 음식점을 검색할까요? 
	//walkerDTO, int meter입력하여 음식점 정보 반환
	//-> 음식 종류를 입력하세요.
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
	
		
		//화장실 검색 - 몇 M 이내에 있는 화장실을 검색할까요?
		//유저DTO, int meter를 입력하여 select p.name,p.type,p.usage from place p where p.type='restroom' and sqrt(pow((p.lat-userDTO.lat),2)+pow((p.lng-userDTO.lng),2))<meter; 
		
		//주차장 검색 - 몇시까지 주차를 할 예정이신가요? -> 몇 M 이내에 있는 주차장을 검색할까요? -> **M 이내의 운영중인 주차장은 현재 N개 있습니다. 
		//유저DTO, int endtime,int meter를 입력하여
		//select sum(id) from place p , parking pk, pk_timetable pkt group by p.id having p.id=pk.id and pk.parkid=pkt.parkid and p.type='parking' and pkt_timetable.we_end<=any(select to_date(sysdate,'HH24MI') sys_date24 from dual);
		
		//결과는 다음과 같습니다. 
		




		//희망시간까지 주차할 경우, 저렴한 주차장 순입니다.
		 

	//삭제기능
	//유저DTO를 입력하여 delete from user where userDTO.id=id ;
	
	//삽입기능
	//내정보 등록 후 등록받은 값들은 UserDTO에 저장한 후 insert into user ( id,name,lat,lng,hasacar) values( ?,?,?,?,?);
	
	//수정기능
	//변경할 위치 선택한 후, update user set lat=? where id=dto.id ; update user set lng=? where id=dto.id;
	
	

	//내정보 수정 시, 회원정보 update
	//내정보 등록 시, 회원테이블 insert -> id,name,내위치 지정(1~14개 지점), 차량 보유 여부, 
	//내정보 삭제 시, id로 회원테이블 delete

}
