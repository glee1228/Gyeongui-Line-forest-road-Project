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
				EndView.SuccessMsg("�����Ͱ� �����ϴ�");
			}
		}catch(Exception e) {
			e.printStackTrace();
			EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");
			
		}
	}
}
