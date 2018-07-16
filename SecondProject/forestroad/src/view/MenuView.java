package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Controller;
import domain.CustomerDTO;

public class MenuView {
	static Controller controller = Controller.getInstance();
	public static int menu() {
        int selection = 0;
        Scanner input = new Scanner(System.in);
        try {

        /*********************************************ㅇ******/
        System.out.println();
        System.out.println();
        System.out.println("경의선 숲길, 철길이 공원이 되다!");
        System.out.println("-------------------------\n");
        System.out.println("1 - 회원가입");
        System.out.println("2 - 로그인");
        System.out.println("3 - 계정 삭제");
        System.out.println("4 - 종료");

        selection = input.nextInt();
        }catch(InputMismatchException e) {
        	System.out.println(e+"의 오류입니다.");
        }finally {
        return selection;    
        }
    }
	public static void signUpMenu(){
		
		Scanner input2 = new Scanner(System.in);
		String inputid = null;
		String inputpw = null;
		String inputname = null;
		System.out.println("--------회원가입--------");
		do {
			System.out.println("아이디를 입력하세요.");
			inputid = input2.nextLine();
			if (inputid.contains("@") == false) {
				System.out.println("@를 포함한 완전한 이메일 주소를 입력하세요.");
			}
		} while (inputid.contains("@") == false);

		System.out.println("비밀번호를 입력하세요.");
		inputpw = input2.nextLine();
		System.out.println("이름을 입력하세요.");
		inputname = input2.nextLine();
		controller.insertCus(new CustomerDTO(inputid,inputpw,inputname));
	}
	public static void signInMenu() {
		 Scanner input2 = new Scanner(System.in);
		 String inputid=null;
		String inputpw=null;
		String inputname=null;
		boolean check = false;
		while(true) {
		System.out.println("--------로 그 인--------");
		System.out.println("아이디를 입력하세요");
		inputid = input2.nextLine();
		System.out.println("비밀번호를 입력하세요");
		inputpw = input2.nextLine();
		check=controller.checkCus(inputid,inputpw);
		if(check==true) break;
		}
		System.out.println("-------------------------------");
		System.out.println("로그인 완료");
		System.out.println("-------------------------------");

	}
	public static int selectLocationMenu() {
        int selection = 0;
        Scanner input = new Scanner(System.in);
        try {

			System.out.println("다음 중 현재 위치와 가까운 지점을 선택하세요");
			System.out.println("1. 가좌역 , 2.연남동 , 3.연트럴파크 , 4.홍대입구역 6번출구 ");
			System.out.println("5.서강대역 , 6. 공덕 파크자이 , 7. 공덕역 , 8.효창공원역");


        selection = input.nextInt();
        }catch(InputMismatchException e) {
        	System.out.println(e+"의 오류입니다.");
        }finally {
        return selection;    
        }
    }
	public static double[] goSelect(int locationChoice) {
		double lat;
		double lng;
		double latlng[] = new double[2];
		switch(locationChoice) {
		case 1:
			//가좌역
			lat = 451971.946107582;
			lng = 192717.616589885;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 2:
			//연남동
			lat = 451517.774663308;
			lng = 193041.251024662;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 3:
			//연트럴파크
			lat = 450883.088700056;
			lng = 193465.757524748;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 4:
			//홍대입구역 6번출구
			lat = 450780.143705472;
			lng = 193699.887851319;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 5:
			//서강대역
			lat = 450254.679232483;
			lng = 194303.299598457;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 6:
			//공덕 파크 자이
			lat = 449444.296307022;
			lng = 195438.908462775;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 7:
			//공덕역
			lat = 449337.621935957;
			lng = 195696.429757503;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 8:
			//효창공원역
			lat = 448861.574123286;
			lng = 196565.818966246;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		}
		return latlng;
	}

	public static int selectDTOMenu() {
		int selection = 0;
		Scanner input = new Scanner(System.in);
		try {

			/********************************************* ㅇ ******/
			System.out.println();
			System.out.println();
			System.out.println("어떤 정보를 찾고 계세요?");
			System.out.println("-------------------------\n");
			System.out.println("1 - 화장실");
			System.out.println("2 - 음식점");
			System.out.println("3 - 주차장");

			selection = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(e + "의 오류입니다.");
		} finally {
			return selection;
		}
	}
	public static String selectTypeMenu(int locationChoice) {
		int selection = 0;
		String type=null;
		Scanner input = new Scanner(System.in);
		switch (locationChoice) {
		case 1:
			try {
				System.out.println();
				System.out.println();
				System.out.println("원하는 화장실 타입을 선택해주세요.");
				System.out.println("-------------------------\n");
				System.out.println("1 - 공공청사");
				System.out.println("2 - 공중");
				System.out.println("3 - 개방");

				selection = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e + "의 오류입니다.");
			}finally {
				switch(selection) {
				case 1:
					type ="공공청사";
					break;
				case 2:
					type ="공중";
					break;
				case 3:
					type ="개방";
					break;
				default :
					type="공중 or p.usage='공공청사' or p.usage='개방'"; 
					break;
				}
			}
			break;
		case 2:
			try {
				System.out.println();
				System.out.println();
				System.out.println("원하시는 식당 종류를 선택해주세요.");
				System.out.println("-------------------------\n");
				System.out.println("1 - 한식");
				System.out.println("2 - 일식");
				System.out.println("3 - 경양식");
				System.out.println("4 - 중국식");
				

				selection = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e + "의 오류입니다.");
			}finally {
				switch(selection) {
				case 1:
					type ="한식";
					break;
				case 2:
					type ="일식";
					break;
				case 3:
					type ="경양식";
					break;
				case 4:
					type ="중국식";
				default :
					type="한식 or p.usage='일식' or p.usage='경양식' or p.usage='중국식'"; 
					break;
				}
			}
			break;
		case 3:
			try {
				System.out.println();
				System.out.println();
				System.out.println("주차장 종류를 입력하세요.");
				System.out.println("-------------------------\n");
				System.out.println("1 - 노상 주차장");
				System.out.println("2 - 노외 주차장");				

				selection = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e + "의 오류입니다.");
			}finally {
				switch(selection) {
				case 1:
					type ="노상 주차장";
					break;
				case 2:
					type ="노외 주차장";
					break;
				default :
					type="노상 주차장 or p.usage='노외 주차장' "; 
					break;
				}
			}
			break;
			
		}
		return type;
	}
	public static int selectEndOrDay() {
        int selection = 0;
        Scanner input = new Scanner(System.in);
        try {

        /*********************************************ㅇ******/
        System.out.println();
        System.out.println();
        System.out.println("이용 날짜를 입력해주세요");
        System.out.println("-------------------------\n");
        System.out.println("1 - 주중");
        System.out.println("2 - 주말");
 

        selection = input.nextInt();
        }catch(InputMismatchException e) {
        	System.out.println(e+"의 오류입니다.");
        }finally {
        return selection;    
        }
    }
	public static int selectEndTime() {
		int selection = 0;
        Scanner input = new Scanner(System.in);
        try {

        /*********************************************ㅇ******/
        System.out.println();
        System.out.println();
        System.out.println("이용 종료시간를 입력해주세요");
        System.out.println("-------------------------\n");
        System.out.println("예 - 15시 -> 15, 21시 -> 21 ");
 

        selection = input.nextInt();
        }catch(InputMismatchException e) {
			System.out.println(e + "의 오류입니다.");
		} finally {
			return selection;
		}
	}

	public static void deleteMenu() {
		Scanner input5 = new Scanner(System.in);
		String inputid = null;
		String inputpw = null;
		System.out.println("--------회원삭제--------");
		do {
			System.out.println("아이디를 입력하세요.");
			inputid = input5.nextLine();
			if (inputid.contains("@") == false) {
				System.out.println("@를 포함한 완전한 이메일 주소를 입력하세요.");
			}
		} while (inputid.contains("@") == false);

		System.out.println("비밀번호를 입력하세요.");
		inputpw = input5.nextLine();

		controller.deleteCus(new CustomerDTO(inputid, inputpw));
	}
}
