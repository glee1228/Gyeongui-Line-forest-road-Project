package view;

import java.util.ArrayList;

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


}
