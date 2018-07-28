package view;

import java.util.Scanner;

import controller.Controller;
import domain.CustomerDTO;

public class StartView {

	public static void main(String[] args) {
		Controller controller = Controller.getInstance();

		// controller.getNearRestaurants(450377.3174,193349.5963, 400);
		// controller.getNearRestRooms(450377.3174,193349.5963, 1000);
		// controller.getNearParkingWD(450377.3174,193349.5963,17, 100);
		// controller.getNearParkingWE(450377.3174,193349.5963,17, 2000);
		int userChoice;
		MenuView View = new MenuView();
		Scanner input2 = new Scanner(System.in);
		Scanner input3 = new Scanner(System.in);
		Scanner input4 = new Scanner(System.in);
		String inputid = null;
		String inputpw = null;
		String inputname = null;
		int locationChoice;
		String onoff = null;
		String retry = null;
		String newinfo = null;
		int choice = 0;

		while (true) {
			userChoice = View.menu();
			switch (userChoice) {
			case 0:
				System.out.println("입력오류입니다. 다시 입력하세요");
				break;
			//회원가입
			case 1:
				View.signUpMenu();
				break;
			//로그인
			case 2:
				//View.signInMenu();
				boolean endcheck = false;

				System.out.println("경의선 숲길의 다양한 검색 기능 이용하시겠습니까?");
				onoff = input2.nextLine();

				double latlng[] = new double[2];
				int limit = 0;
				String type =null;
				if (onoff.equals("y") || onoff.equals("Y")) {

					locationChoice = View.selectLocationMenu();
					latlng = View.goSelect(locationChoice);
					do {
						choice = View.selectDTOMenu();
						switch (choice) {
						case 0:
							System.out.println("입력오류입니다. 다시 입력하세요");
							break;
						// 화장실
						case 1:
							EndView.printMsg("탐색할 기준 거리를 입력해주세요(M)");
							limit = input2.nextInt();
							controller.getNearRestRooms(latlng[0], latlng[1], limit);
							EndView.printMsg("\n해당 결과 내 재검색 하시겠습니까?");
							retry = input3.nextLine();
							endcheck = controller.retrySelect(retry);
							if (endcheck) {
								type =View.selectTypeMenu(choice);
								controller.getNearRestRooms2(latlng[0], latlng[1], limit,type);
							} else if (!endcheck) {
								controller.selectExit();
							}
							break;
						// 음식점
						case 2:
							EndView.printMsg("탐색할 기준 거리를 입력해주세요(M)");
							limit = input2.nextInt();
							controller.getNearRestaurants(latlng[0], latlng[1], limit);
							EndView.printMsg("\n해당 결과 내 재검색 하시겠습니까?");
							retry = input3.nextLine();
							endcheck = controller.retrySelect(retry);
							if (endcheck) {
								type =View.selectTypeMenu(choice);
								controller.getNearRestaurants2(latlng[0], latlng[1], limit,type);
							} else if (!endcheck) {
								controller.selectExit();
								
							}
							break;
						// 주차장
						case 3:
							int endorday;
							int endtime;
							EndView.printMsg("탐색할 기준 거리를 입력해주세요(M)");
							limit = input2.nextInt();
							endorday=View.selectEndOrDay();
							endtime=View.selectEndTime();
							switch(endorday) {
							case 1:
								controller.getNearParkingWD(latlng[0], latlng[1],endtime, limit);
								break;
							case 2:
								controller.getNearParkingWE(latlng[0], latlng[1],endtime, limit);
								break;
							}
							
							EndView.printMsg("\n해당 결과 내 재검색 하시겠습니까?");
							retry = input3.nextLine();
							endcheck = controller.retrySelect(retry);
							if (endcheck) {
								type = View.selectTypeMenu(choice);
								switch(endorday) {
								case 1:
									controller.getNearParkingWD2(latlng[0], latlng[1],endtime, limit,type);
									break;
								case 2:
									controller.getNearParkingWE2(latlng[0], latlng[1],endtime, limit,type);
									break;
								}
								
							} else if (!endcheck) {
								controller.selectExit();
							}
							break;
						}
					} while (endcheck);
					onoff=null;
				} else if (onoff.equals("n") || onoff.equals("N")) {
					onoff=null;
					break;
				} else {
					System.out.println("올바르지 않은 입력입니다. 초기 화면으로 돌아갑니다.");
					onoff=null;
				}

				break;
			//회원 삭제
			case 3:
				View.deleteMenu();
				break;
			//시스템 종료
			case 4:
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
				break;
			}
		}
	}
}
