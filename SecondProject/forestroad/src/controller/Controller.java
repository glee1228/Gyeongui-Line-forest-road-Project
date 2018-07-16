package controller;

import java.util.ArrayList;
import java.util.Scanner;

import domain.CustomerDTO;
import domain.ParkingDTO;
import domain.Pk_TimeTableDTO;
import domain.PlaceDTO;
import domain.RestaurantDTO;
import model.ForestRoadDAO;
import view.EndView;

public class Controller {
	private static Controller instance = new Controller();

	private Controller() {
	}

	public static Controller getInstance() {
		return instance;
	}

	public void getNearRestaurants(double lat, double lng, int meter) {
		try {
			ArrayList<RestaurantDTO> datas = ForestRoadDAO.getNearRestaurants(lat, lng, meter);
			if (datas.size() != 0) {
				EndView.printRestaurants(datas);
			} else {
				EndView.SuccessMsg("데이터가 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");

		}
	}
	public void getNearRestaurants2(double lat, double lng, int meter,String type) {
		try {
			ArrayList<RestaurantDTO> datas = ForestRoadDAO.getNearRestaurants2(lat, lng, meter,type);
			if (datas.size() != 0) {
				EndView.printRestaurants(datas);
			} else {
				EndView.SuccessMsg("데이터가 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");

		}
	}

	public void getNearRestRooms(double lat, double lng, int meter) {
		try {
			ArrayList<PlaceDTO> datas = ForestRoadDAO.getNearRestRooms(lat, lng, meter);
			if (datas.size() != 0) {
				EndView.printRestRooms(datas);
			} else {
				EndView.SuccessMsg("데이터가 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");

		}
	}
	public void getNearRestRooms2(double lat, double lng, int meter, String type) {
		try {
			ArrayList<PlaceDTO> datas = ForestRoadDAO.getNearRestRooms2(lat, lng, meter,type);
			if (datas.size() != 0) {
				EndView.printRestRooms(datas);
			} else {
				EndView.SuccessMsg("데이터가 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");

		}
		
	}

	public void getNearParkingWD(double lat, double lng,int time, int meter) {
		try {
			ArrayList<ParkingDTO> datas = ForestRoadDAO.getNearParkingsWD(lat, lng,time, meter);
			if (datas.size() != 0) {
				EndView.printParkings(datas);
			} else {
				EndView.SuccessMsg("이용가능한 주차장 목록이 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");

		}
	}
	public void getNearParkingWE(double lat, double lng,int time, int meter) {
		try {
			ArrayList<ParkingDTO> datas = ForestRoadDAO.getNearParkingsWE(lat, lng,time, meter);
			if (datas.size() != 0) {
				EndView.printParkings(datas);
			} else {
				EndView.SuccessMsg("이용가능한 주차장 목록이 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");

		}
	}
	public void getNearParkingWD2(double lat, double lng,int time, int meter,String type) {
		try {
			ArrayList<ParkingDTO> datas = ForestRoadDAO.getNearParkingsWD2(lat, lng,time, meter,type);
			if (datas.size() != 0) {
				EndView.printParkings(datas);
			} else {
				EndView.SuccessMsg("이용가능한 주차장 목록이 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");

		}
	}
	public void getNearParkingWE2(double lat, double lng,int time, int meter,String type) {
		try {
			ArrayList<ParkingDTO> datas = ForestRoadDAO.getNearParkingsWE2(lat, lng,time, meter,type);
			if (datas.size() != 0) {
				EndView.printParkings(datas);
			} else {
				EndView.SuccessMsg("이용가능한 주차장 목록이 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");

		}
	}
	public void insertCus(CustomerDTO newCus) {
		try {
			if(ForestRoadDAO.insertCus(newCus))
			EndView.SuccessMsg("성공적으로 회원가입되었습니다");
		}catch(Exception e){
			EndView.errorMsg("이미 존재하는 회원입니다.");
		}
	}
	public void deleteCus(CustomerDTO newCus) {
		try {
			if(ForestRoadDAO.deleteCus(newCus))
			EndView.SuccessMsg("성공적으로 삭제되었습니다");
			
		}catch(Exception e){
			EndView.errorMsg("존재하지 않는 회원입니다.");
		}
	}
	public boolean checkCus(String id,String pw) {
		try {
			if(ForestRoadDAO.checkCus(id,pw)) {
			EndView.SuccessMsg("성공적으로 로그인되었습니다");
			return true;
			}
		}catch(Exception e){
			EndView.errorMsg("아이디와 비밀번호가 올바르지 않습니다.");
		}
		return false;
	}
	public boolean retrySelect(String retry) {
		if (retry.equals("y") || retry.equals("Y")) {
			return true;
		}else if (retry.equals("n") || retry.equals("N")) {
			return false;
		}
		return false;
	}

	public void selectExit() {
		Scanner input4 = new Scanner(System.in);
		String newinfo = null;
		EndView.printMsg("\n새로운 정보를 검색 하시겠습니까?");
		newinfo = input4.nextLine();
		if (newinfo.equals("n") || newinfo.equals("N")) {
			System.out.println("\n프로그램을 종료합니다.");
			System.exit(0);
		}
	}

	
	
	
}
