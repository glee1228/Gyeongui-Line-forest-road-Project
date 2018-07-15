package view;

import controller.Controller;
import domain.WalkerDTO;

public class StartView {
	public static void main(String[] args) {
	Controller controller =Controller.getInstance();
	
	controller.getNearRestaurants(new WalkerDTO("glee1228","¿Ãµø»∆",37.52058779,126.967566,false), 400);
	
	
	}
}
