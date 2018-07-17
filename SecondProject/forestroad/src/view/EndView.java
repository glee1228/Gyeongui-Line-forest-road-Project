package view;

import java.util.ArrayList;

import domain.ParkingDTO;
import domain.Pk_TimeTableDTO;
import domain.PlaceDTO;
import domain.RestaurantDTO;

public class EndView {

	public static void errorMsg(String msg) {
		System.out.println("비정상 실행 : " +msg);
	}

	public static void SuccessMsg(String msg) {
		System.out.println("정상 실행 : " +msg);
	}

	public static void printRestaurants(ArrayList<RestaurantDTO> datas) {
		for(RestaurantDTO dto:datas){
			System.out.println(dto);
		}
	}

	public static void printRestaurant(RestaurantDTO data) {
		System.out.println(data);
	}

	public static void printRestRooms(ArrayList<PlaceDTO> datas) {
		for(PlaceDTO dto:datas){
			System.out.println(dto);
		}
		
	}

	public static void printParkings(ArrayList<ParkingDTO> datas) {
		for(ParkingDTO dto:datas){
			System.out.println(dto);
		}
		
	}
	public static void printMsg(String msg) {
		System.out.println(msg);
	}


}
