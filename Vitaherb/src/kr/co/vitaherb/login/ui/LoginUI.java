package kr.co.vitaherb.login.ui;

import java.util.Scanner;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.User;
import kr.co.vitaherb.loginview.ui.LoginViewUI;
import kr.co.vitaherb.mainservice.ui.MainServiceUI;
import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.UserMapper;

public class LoginUI extends BaseUI {
//	private UserMapper um;
//	public Scanner sc = new Scanner(System.in);
//
//	public LoginUI(UserMapper um) {
//		this.um = um;
//	}
	
	private UserMapper um;
	private CartMapper cm;
	public Scanner sc = new Scanner(System.in);
	public LoginUI(UserMapper um) {
		this.um = um;
	}

	public LoginUI(UserMapper um,CartMapper cm) {
		this.um = um;
		this.cm = cm;
	}

	public void service() {

		LoginViewUI.user = new User();

		System.out.println(" ");
		System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*");
		System.out.println("[로그인]");

		String userId = getStr("아이디 : ");
		LoginViewUI.user = um.loginUser(userId);

		String passWord = getStr("비밀번호 : ");

		if(um.loginUser(userId)==null) {
			System.out.println("--------------------");
			System.out.println("     [로그인 실패]   ");
			System.out.println("    없는 아이디입니다.    ");
			System.out.println("--------------------");
			System.out.print("1. 다시 시도하기"+"\n"+"2. 회원정보 찾기");
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 : 
				LoginUI ui = new LoginUI(um,cm);
				ui.service();
				break;
			case 2 : 
				FindUserUI ui2 = new FindUserUI(um);
				ui2.service();
				break;
			}
		} else if(um.loginUser(userId)!=null && !passWord.equals(LoginViewUI.user.getUserPassword())) {
			System.out.println("--------------------");
			System.out.println("      [로그인 실패]   ");
			System.out.println(" 비밀번호가 일치하지 않습니다.");
			System.out.println("--------------------");
			System.out.print("1. 다시 시도하기"+"\n"+"2. 회원정보 찾기");
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 : 
				LoginUI ui = new LoginUI(um,cm);
				ui.service();
				break;
			case 2 : 
				FindUserUI ui2 = new FindUserUI(um);
				ui2.service();
				break;
			}

		} else if(passWord.equals(LoginViewUI.user.getUserPassword())) {
			System.out.println("--------------------");
			System.out.println("  로그인에 성공했습니다.   ");
			System.out.println("--------------------");
//			cm.deleteCart();
			MainServiceUI ui = new MainServiceUI();
			ui.service();
		} 

	}
}
