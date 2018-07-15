package controller;

import java.util.ArrayList;

import domain.RestaurantDTO;
import domain.WalkerDTO;
import model.ForestRoadDAO;
import view.EndView;

public class Controller {
	private static Controller instance = new Controller();
	private Controller() {}
	
	public static Controller getInstance() {
		return instance;
	}
	public void getNearRestaurants(WalkerDTO walker,int meter) {
		try {
			ArrayList<RestaurantDTO> datas = ForestRoadDAO.getNearRestaurants(walker,meter);
			if(datas.size()!=0) {
				EndView.printRestaurants(datas);
			}else {
				EndView.SuccessMsg("데이터가 없습니다");
			}
		}catch(Exception e) {
			e.printStackTrace();
			EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");
			
		}
	}
}
