package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.CustomerDTO;
import domain.ParkingDTO;
import domain.Pk_TimeTableDTO;
import domain.PlaceDTO;
import domain.RestaurantDTO;
import util.DButil;

public class ForestRoadDAO {

	//검색기능
	//음식점 검색 - 몇 M이내에 있는 음식점을 검색할까요? 
	//walkerDTO, int meter입력하여 음식점 정보 반환
	//-> 음식 종류를 입력하세요.
	public static ArrayList<RestaurantDTO> getNearRestaurants(double lat,double lng,int meter) throws Exception{
		Connection con =null;
		PreparedStatement pstmt =null;
		String sql = "select p.id, p.name, p.type, p.usage, p.lat, p.lng, r.district, r.address, r.phone "
				+ "from place p, restaurant r "
				+ "where p.id=r.id and p.type='restaurant' and sqrt(power((p.lat-?),2)+power((p.lng-?),2))<?";
		

		ResultSet rs = null;
		double dist =0.0;
		
		ArrayList<RestaurantDTO> datas = new ArrayList<RestaurantDTO>();
		try {
			con = DButil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1,lat);
			pstmt.setDouble(2, lng);
			pstmt.setDouble(3,(double)meter);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dist=Math.sqrt(Math.pow((rs.getDouble(5)-lat),2)+Math.pow((rs.getDouble(6)-lng),2));
				datas.add(new RestaurantDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)
						,dist,rs.getString(7),rs.getString(8),rs.getString(9)));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DButil.close(con,pstmt,rs);
		}
		
		return datas;
		
	}
	public static ArrayList<RestaurantDTO> getNearRestaurants2(double lat,double lng,int meter,String type) throws Exception{
		Connection con =null;
		PreparedStatement pstmt =null;
		String sql = "select p.id, p.name, p.type, p.usage, p.lat, p.lng, r.district, r.address, r.phone "
				+ "from place p, restaurant r "
				+ "where p.id=r.id and p.type='restaurant' and p.usage=? and sqrt(power((p.lat-?),2)+power((p.lng-?),2))<?";
		

		ResultSet rs = null;
		double dist =0.0;
		
		ArrayList<RestaurantDTO> datas = new ArrayList<RestaurantDTO>();
		try {
			con = DButil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,type);
			pstmt.setDouble(2, lat);
			pstmt.setDouble(3, lng);
			pstmt.setDouble(4,(double)meter);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dist=Math.sqrt(Math.pow((rs.getDouble(5)-lat),2)+Math.pow((rs.getDouble(6)-lng),2));
				datas.add(new RestaurantDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)
						,dist,rs.getString(7),rs.getString(8),rs.getString(9)));
				
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
	public static ArrayList<PlaceDTO> getNearRestRooms(double lat,double lng ,int meter) throws SQLException{
		Connection con =null;
		PreparedStatement pstmt =null;
		String sql = "select p.id, p.name, p.type, p.usage, p.lat, p.lng "
				+ "from place p "
				+ "where p.type='restroom' and sqrt(power((p.lat-?),2)+power((p.lng-?),2))<?";
		
		double dist= 0.0;
		ResultSet rs = null;
		
		ArrayList<PlaceDTO> datas = new ArrayList<PlaceDTO>();
		try {
			con = DButil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1,lat);
			pstmt.setDouble(2, lng);
			pstmt.setDouble(3,(double)meter);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dist=Math.sqrt(Math.pow((rs.getDouble(5)-lat),2)+Math.pow((rs.getDouble(6)-lng),2));
				datas.add(new PlaceDTO(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),dist));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DButil.close(con,pstmt,rs);
		}
		
		return datas;
		
	}
	public static ArrayList<PlaceDTO> getNearRestRooms2(double lat,double lng ,int meter,String type) throws SQLException{
		Connection con =null;
		PreparedStatement pstmt =null;
		String sql = "select p.id, p.name, p.type, p.usage, p.lat, p.lng "
				+ "from place p "
				+ "where p.type='restroom' and p.usage=? and sqrt(power((p.lat-?),2)+power((p.lng-?),2))<?";
		
		double dist= 0.0;
		ResultSet rs = null;
		
		ArrayList<PlaceDTO> datas = new ArrayList<PlaceDTO>();
		try {
			con = DButil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,type);
			pstmt.setDouble(2, lat);
			pstmt.setDouble(3, lng);
			pstmt.setDouble(4,(double)meter);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dist=Math.sqrt(Math.pow((rs.getDouble(5)-lat),2)+Math.pow((rs.getDouble(6)-lng),2));
				datas.add(new PlaceDTO(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),dist));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DButil.close(con,pstmt,rs);
		}
		
		return datas;
		
	}
	// 주차장 검색 - 몇시까지 주차를 할 예정이신가요? -> 몇 M 이내에 있는 주차장을 검색할까요? -> **M 이내의 운영중인 주차장은 현재
	
	public static ArrayList<ParkingDTO> getNearParkingsWD(double lat,double lng,int time,int meter) throws SQLException{
		Connection con =null;
		PreparedStatement pstmt =null;
		PreparedStatement pstmt2 =null;
		String sql = "select to_char(sysdate,'HH24') from dual";
		String sql2 = "select p.id,p.name,p.usage,pk.district,pk.address,pk.phone,pk.volume,pkt.wd_start,pkt.wd_end,p.lat,p.lng "
				+ "from place p,parking pk,pk_timetable pkt "
				+ "where p.id=pk.id and pk.parkid=pkt.parkid and sqrt(power((p.lat-?),2)+power((p.lng-?),2))<?";
		int result=0;
		int endtime = time;
		double dist = 0.0;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList<ParkingDTO> datas = new ArrayList<ParkingDTO>();
	
		
		try {
			con = DButil.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setDouble(1,lat);
			pstmt2.setDouble(2, lng);
			pstmt2.setDouble(3,(double)meter);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
				System.out.println("\n지금 시간부터 "+time+"시 까지 이용가능한 "+meter+"M 이내에 있는 주차장 결과");
			}
			rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				if (rs2.getInt(8) < result && rs2.getInt(9) > result&&rs2.getInt(8) < endtime && rs2.getInt(9) > endtime) {
					dist=Math.sqrt(Math.pow((rs2.getDouble(10)-lat),2)+Math.pow((rs2.getDouble(11)-lng),2));
					datas.add(new ParkingDTO(rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4),
							rs2.getString(5),rs2.getString(6),rs2.getInt(7),dist));
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DButil.close(con,pstmt,rs);
		}
		
		return datas;
		
	}
	public static ArrayList<ParkingDTO> getNearParkingsWD2(double lat,double lng,int time,int meter,String type) throws SQLException{
		Connection con =null;
		PreparedStatement pstmt =null;
		PreparedStatement pstmt2 =null;
		String sql = "select to_char(sysdate,'HH24') from dual";
		String sql2 = "select p.id,p.name,p.usage,pk.district,pk.address,pk.phone,pk.volume,pkt.wd_start,pkt.wd_end,p.lat,p.lng "
				+ "from place p,parking pk,pk_timetable pkt "
				+ "where p.id=pk.id and pk.parkid=pkt.parkid and p.usage=? and sqrt(power((p.lat-?),2)+power((p.lng-?),2))<?";
		int result=0;
		int endtime = time;
		double dist = 0.0;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList<ParkingDTO> datas = new ArrayList<ParkingDTO>();
	
		
		try {
			con = DButil.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1,type);
			pstmt2.setDouble(2, lat);
			pstmt2.setDouble(3, lng);
			pstmt2.setDouble(4,(double)meter);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
				System.out.println("\n지금 시간부터 "+time+"시 까지 이용가능한 "+meter+"M 이내에 있는 주차장 결과");
			}
			rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				if (rs2.getInt(8) < result && rs2.getInt(9) > result&&rs2.getInt(8) < endtime && rs2.getInt(9) > endtime) {
					dist=Math.sqrt(Math.pow((rs2.getDouble(10)-lat),2)+Math.pow((rs2.getDouble(11)-lng),2));
					datas.add(new ParkingDTO(rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4),
							rs2.getString(5),rs2.getString(6),rs2.getInt(7),dist));
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DButil.close(con,pstmt,rs);
		}
		
		return datas;
		
	}
	public static ArrayList<ParkingDTO> getNearParkingsWE(double lat,double lng,int time,int meter) throws SQLException{
		Connection con =null;
		PreparedStatement pstmt =null;
		PreparedStatement pstmt2 =null;
		String sql = "select to_char(sysdate,'HH24') from dual";
		String sql2 = "select p.id,p.name,p.usage,pk.district,pk.address,pk.phone,pk.volume,pkt.we_start,pkt.we_end,p.lat,p.lng "
				+ "from place p,parking pk,pk_timetable pkt "
				+ "where p.id=pk.id and pk.parkid=pkt.parkid and sqrt(power((p.lat-?),2)+power((p.lng-?),2))<?";
		int result=0;
		int endtime = time;
		double dist = 0.0;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList<ParkingDTO> datas = new ArrayList<ParkingDTO>();
	
		
		try {
			con = DButil.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setDouble(1,lat);
			pstmt2.setDouble(2, lng);
			pstmt2.setDouble(3,(double)meter);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
				System.out.println("\n지금 시간부터 "+time+"시 까지 이용가능한 "+meter+"M 이내에 있는 주차장 결과");
			}
			rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				if (rs2.getInt(8) < result && rs2.getInt(9) > result&&rs2.getInt(8) < endtime && rs2.getInt(9) > endtime) {
					dist=Math.sqrt(Math.pow((rs2.getDouble(10)-lat),2)+Math.pow((rs2.getDouble(11)-lng),2));
					datas.add(new ParkingDTO(rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4),
							rs2.getString(5),rs2.getString(6),rs2.getInt(7),dist));
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DButil.close(con,pstmt,rs);
		}
		
		return datas;
		
	}
	public static ArrayList<ParkingDTO> getNearParkingsWE2(double lat,double lng,int time,int meter,String type) throws SQLException{
		Connection con =null;
		PreparedStatement pstmt =null;
		PreparedStatement pstmt2 =null;
		String sql = "select to_char(sysdate,'HH24') from dual";
		String sql2 = "select p.id,p.name,p.usage,pk.district,pk.address,pk.phone,pk.volume,pkt.we_start,pkt.we_end,p.lat,p.lng "
				+ "from place p,parking pk,pk_timetable pkt "
				+ "where p.id=pk.id and pk.parkid=pkt.parkid and p.usage=? and sqrt(power((p.lat-?),2)+power((p.lng-?),2))<?";
		int result=0;
		int endtime = time;
		double dist = 0.0;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList<ParkingDTO> datas = new ArrayList<ParkingDTO>();
	
		
		try {
			con = DButil.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1,type);
			pstmt2.setDouble(2, lat);
			pstmt2.setDouble(3, lng);
			pstmt2.setDouble(4,(double)meter);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
				System.out.println("\n지금 시간부터 "+time+"시 까지 이용가능한 "+meter+"M 이내에 있는 주차장 결과");
			}
			rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				if (rs2.getInt(8) < result && rs2.getInt(9) > result&&rs2.getInt(8) < endtime && rs2.getInt(9) > endtime) {
					dist=Math.sqrt(Math.pow((rs2.getDouble(10)-lat),2)+Math.pow((rs2.getDouble(11)-lng),2));
					datas.add(new ParkingDTO(rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4),
							rs2.getString(5),rs2.getString(6),rs2.getInt(7),dist));
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DButil.close(con,pstmt,rs);
		}
		
		return datas;
		
	}
	
	//삽입기능
	//id,pw,name입력 후 database에 저장.
	public static boolean insertCus(CustomerDTO one) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = "insert into CUSTOMER values(?,?,?)";

			try {
				con = DButil.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, one.getCusid());
				pstmt.setString(2, one.getCuspw());
				pstmt.setString(3, one.getCusname());
				int result = pstmt.executeUpdate();
				if (result == 0) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				DButil.close(con, pstmt);
			}
			return true;
		}
		
	public static boolean checkCus(String id,String pw) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from customer where cusid=? and cuspw=?";

		try {
			con = DButil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			int result = pstmt.executeUpdate();
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DButil.close(con, pstmt);
		}
		return true;
	}
	public static boolean deleteCus(CustomerDTO one) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete from CUSTOMER where cusid=? and cuspw=?";

		try {
			con = DButil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, one.getCusid());
			pstmt.setString(2, one.getCuspw());
			int result = pstmt.executeUpdate();
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DButil.close(con, pstmt);
		}
		return true;
	}
	

	//내정보 삭제 시, id로 회원테이블 delete
	
	

}
