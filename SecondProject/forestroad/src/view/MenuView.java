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

        /*********************************************��******/
        System.out.println();
        System.out.println();
        System.out.println("���Ǽ� ����, ö���� ������ �Ǵ�!");
        System.out.println("-------------------------\n");
        System.out.println("1 - ȸ������");
        System.out.println("2 - �α���");
        System.out.println("3 - ���� ����");
        System.out.println("4 - ����");

        selection = input.nextInt();
        }catch(InputMismatchException e) {
        	System.out.println(e+"�� �����Դϴ�.");
        }finally {
        return selection;    
        }
    }
	public static void signUpMenu(){
		
		Scanner input2 = new Scanner(System.in);
		String inputid = null;
		String inputpw = null;
		String inputname = null;
		System.out.println("--------ȸ������--------");
		do {
			System.out.println("���̵� �Է��ϼ���.");
			inputid = input2.nextLine();
			if (inputid.contains("@") == false) {
				System.out.println("@�� ������ ������ �̸��� �ּҸ� �Է��ϼ���.");
			}
		} while (inputid.contains("@") == false);

		System.out.println("��й�ȣ�� �Է��ϼ���.");
		inputpw = input2.nextLine();
		System.out.println("�̸��� �Է��ϼ���.");
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
		System.out.println("--------�� �� ��--------");
		System.out.println("���̵� �Է��ϼ���");
		inputid = input2.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		inputpw = input2.nextLine();
		check=controller.checkCus(inputid,inputpw);
		if(check==true) break;
		}
		System.out.println("-------------------------------");
		System.out.println("�α��� �Ϸ�");
		System.out.println("-------------------------------");

	}
	public static int selectLocationMenu() {
        int selection = 0;
        Scanner input = new Scanner(System.in);
        try {

			System.out.println("���� �� ���� ��ġ�� ����� ������ �����ϼ���");
			System.out.println("1. ���¿� , 2.������ , 3.��Ʈ����ũ , 4.ȫ���Ա��� 6���ⱸ ");
			System.out.println("5.�����뿪 , 6. ���� ��ũ���� , 7. ������ , 8.ȿâ������");


        selection = input.nextInt();
        }catch(InputMismatchException e) {
        	System.out.println(e+"�� �����Դϴ�.");
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
			//���¿�
			lat = 451971.946107582;
			lng = 192717.616589885;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 2:
			//������
			lat = 451517.774663308;
			lng = 193041.251024662;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 3:
			//��Ʈ����ũ
			lat = 450883.088700056;
			lng = 193465.757524748;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 4:
			//ȫ���Ա��� 6���ⱸ
			lat = 450780.143705472;
			lng = 193699.887851319;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 5:
			//�����뿪
			lat = 450254.679232483;
			lng = 194303.299598457;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 6:
			//���� ��ũ ����
			lat = 449444.296307022;
			lng = 195438.908462775;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 7:
			//������
			lat = 449337.621935957;
			lng = 195696.429757503;
			latlng[0]=lat;
			latlng[1]=lng;
			break;
		case 8:
			//ȿâ������
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

			/********************************************* �� ******/
			System.out.println();
			System.out.println();
			System.out.println("� ������ ã�� �輼��?");
			System.out.println("-------------------------\n");
			System.out.println("1 - ȭ���");
			System.out.println("2 - ������");
			System.out.println("3 - ������");

			selection = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(e + "�� �����Դϴ�.");
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
				System.out.println("���ϴ� ȭ��� Ÿ���� �������ּ���.");
				System.out.println("-------------------------\n");
				System.out.println("1 - ����û��");
				System.out.println("2 - ����");
				System.out.println("3 - ����");

				selection = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e + "�� �����Դϴ�.");
			}finally {
				switch(selection) {
				case 1:
					type ="����û��";
					break;
				case 2:
					type ="����";
					break;
				case 3:
					type ="����";
					break;
				default :
					type="���� or p.usage='����û��' or p.usage='����'"; 
					break;
				}
			}
			break;
		case 2:
			try {
				System.out.println();
				System.out.println();
				System.out.println("���Ͻô� �Ĵ� ������ �������ּ���.");
				System.out.println("-------------------------\n");
				System.out.println("1 - �ѽ�");
				System.out.println("2 - �Ͻ�");
				System.out.println("3 - ����");
				System.out.println("4 - �߱���");
				

				selection = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e + "�� �����Դϴ�.");
			}finally {
				switch(selection) {
				case 1:
					type ="�ѽ�";
					break;
				case 2:
					type ="�Ͻ�";
					break;
				case 3:
					type ="����";
					break;
				case 4:
					type ="�߱���";
				default :
					type="�ѽ� or p.usage='�Ͻ�' or p.usage='����' or p.usage='�߱���'"; 
					break;
				}
			}
			break;
		case 3:
			try {
				System.out.println();
				System.out.println();
				System.out.println("������ ������ �Է��ϼ���.");
				System.out.println("-------------------------\n");
				System.out.println("1 - ��� ������");
				System.out.println("2 - ��� ������");				

				selection = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e + "�� �����Դϴ�.");
			}finally {
				switch(selection) {
				case 1:
					type ="��� ������";
					break;
				case 2:
					type ="��� ������";
					break;
				default :
					type="��� ������ or p.usage='��� ������' "; 
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

        /*********************************************��******/
        System.out.println();
        System.out.println();
        System.out.println("�̿� ��¥�� �Է����ּ���");
        System.out.println("-------------------------\n");
        System.out.println("1 - ����");
        System.out.println("2 - �ָ�");
 

        selection = input.nextInt();
        }catch(InputMismatchException e) {
        	System.out.println(e+"�� �����Դϴ�.");
        }finally {
        return selection;    
        }
    }
	public static int selectEndTime() {
		int selection = 0;
        Scanner input = new Scanner(System.in);
        try {

        /*********************************************��******/
        System.out.println();
        System.out.println();
        System.out.println("�̿� ����ð��� �Է����ּ���");
        System.out.println("-------------------------\n");
        System.out.println("�� - 15�� -> 15, 21�� -> 21 ");
 

        selection = input.nextInt();
        }catch(InputMismatchException e) {
			System.out.println(e + "�� �����Դϴ�.");
		} finally {
			return selection;
		}
	}

	public static void deleteMenu() {
		Scanner input5 = new Scanner(System.in);
		String inputid = null;
		String inputpw = null;
		System.out.println("--------ȸ������--------");
		do {
			System.out.println("���̵� �Է��ϼ���.");
			inputid = input5.nextLine();
			if (inputid.contains("@") == false) {
				System.out.println("@�� ������ ������ �̸��� �ּҸ� �Է��ϼ���.");
			}
		} while (inputid.contains("@") == false);

		System.out.println("��й�ȣ�� �Է��ϼ���.");
		inputpw = input5.nextLine();

		controller.deleteCus(new CustomerDTO(inputid, inputpw));
	}
}
