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
				EndView.SuccessMsg("�����Ͱ� �����ϴ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");

		}
	}
	public void getNearRestaurants2(double lat, double lng, int meter,String type) {
		try {
			ArrayList<RestaurantDTO> datas = ForestRoadDAO.getNearRestaurants2(lat, lng, meter,type);
			if (datas.size() != 0) {
				EndView.printRestaurants(datas);
			} else {
				EndView.SuccessMsg("�����Ͱ� �����ϴ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");

		}
	}

	public void getNearRestRooms(double lat, double lng, int meter) {
		try {
			ArrayList<PlaceDTO> datas = ForestRoadDAO.getNearRestRooms(lat, lng, meter);
			if (datas.size() != 0) {
				EndView.printRestRooms(datas);
			} else {
				EndView.SuccessMsg("�����Ͱ� �����ϴ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");

		}
	}
	public void getNearRestRooms2(double lat, double lng, int meter, String type) {
		try {
			ArrayList<PlaceDTO> datas = ForestRoadDAO.getNearRestRooms2(lat, lng, meter,type);
			if (datas.size() != 0) {
				EndView.printRestRooms(datas);
			} else {
				EndView.SuccessMsg("�����Ͱ� �����ϴ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");

		}
		
	}

	public void getNearParkingWD(double lat, double lng,int time, int meter) {
		try {
			ArrayList<ParkingDTO> datas = ForestRoadDAO.getNearParkingsWD(lat, lng,time, meter);
			if (datas.size() != 0) {
				EndView.printParkings(datas);
			} else {
				EndView.SuccessMsg("�̿밡���� ������ ����� �����ϴ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");

		}
	}
	public void getNearParkingWE(double lat, double lng,int time, int meter) {
		try {
			ArrayList<ParkingDTO> datas = ForestRoadDAO.getNearParkingsWE(lat, lng,time, meter);
			if (datas.size() != 0) {
				EndView.printParkings(datas);
			} else {
				EndView.SuccessMsg("�̿밡���� ������ ����� �����ϴ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");

		}
	}
	public void getNearParkingWD2(double lat, double lng,int time, int meter,String type) {
		try {
			ArrayList<ParkingDTO> datas = ForestRoadDAO.getNearParkingsWD2(lat, lng,time, meter,type);
			if (datas.size() != 0) {
				EndView.printParkings(datas);
			} else {
				EndView.SuccessMsg("�̿밡���� ������ ����� �����ϴ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");

		}
	}
	public void getNearParkingWE2(double lat, double lng,int time, int meter,String type) {
		try {
			ArrayList<ParkingDTO> datas = ForestRoadDAO.getNearParkingsWE2(lat, lng,time, meter,type);
			if (datas.size() != 0) {
				EndView.printParkings(datas);
			} else {
				EndView.SuccessMsg("�̿밡���� ������ ����� �����ϴ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");

		}
	}
	public void insertCus(CustomerDTO newCus) {
		try {
			if(ForestRoadDAO.insertCus(newCus))
			EndView.SuccessMsg("���������� ȸ�����ԵǾ����ϴ�");
		}catch(Exception e){
			EndView.errorMsg("�̹� �����ϴ� ȸ���Դϴ�.");
		}
	}
	public void deleteCus(CustomerDTO newCus) {
		try {
			if(ForestRoadDAO.deleteCus(newCus))
			EndView.SuccessMsg("���������� �����Ǿ����ϴ�");
			
		}catch(Exception e){
			EndView.errorMsg("�������� �ʴ� ȸ���Դϴ�.");
		}
	}
	public boolean checkCus(String id,String pw) {
		try {
			if(ForestRoadDAO.checkCus(id,pw)) {
			EndView.SuccessMsg("���������� �α��εǾ����ϴ�");
			return true;
			}
		}catch(Exception e){
			EndView.errorMsg("���̵�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
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
		EndView.printMsg("\n���ο� ������ �˻� �Ͻðڽ��ϱ�?");
		newinfo = input4.nextLine();
		if (newinfo.equals("n") || newinfo.equals("N")) {
			System.out.println("\n���α׷��� �����մϴ�.");
			System.exit(0);
		}
	}

	
	
	
}
