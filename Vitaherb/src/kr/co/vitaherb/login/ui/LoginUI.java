package kr.co.vitaherb.login.ui;

import java.util.Scanner;

import common.db.BaseUI;
import kr.co.vitaherb.domain.User;
import kr.co.vitaherb.loginview.ui.LoginViewUI;
import kr.co.vitaherb.mainservice.ui.MainServiceUI;
import kr.co.vitaherb.mapper.UserMapper;

public class LoginUI extends BaseUI {
	private UserMapper um;
	public Scanner sc = new Scanner(System.in);
	
	public LoginUI(UserMapper um) {
		this.um = um;
	}
	
//	public boolean loginCheck(String id, String password) {
//		boolean result = false;
//		return result;
//	}
	
	public void service() {
		LoginViewUI.user = new User();
		System.out.println(" ");
		System.out.println("<로그인>");
		
		String userId = getStr("아이디 : ");
		
		LoginViewUI.user = um.loginUser(userId);
		
		String passWord = getStr("비밀번호 : ");
		
		if(passWord.equals(LoginViewUI.user.getUserPassword())) {
			System.out.println("--------------------");
			System.out.println("로그인에 성공했습니다.");
			System.out.println("--------------------");
			MainServiceUI ui = new MainServiceUI();
			ui.service();
		} else {
			System.out.println("--------------------");
			System.out.println("회원정보가 일치하지 않습니다.");
			System.out.println("--------------------");
			LoginViewUI ui2 = new LoginViewUI();
				try {
					ui2.service();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		
		
		
//		um.loginUser(user);
//		System.out.println(user.getUserId());
		
//		user = um.loginUser(user);
//		System.out.println(user.getUserId());
//		user.setUserId(sc.nextLine());
//		System.out.print("비밀번호 : ");
//		user.setUserPassword(sc.nextLine());
//		
//		System.out.println(user.getUserId());
	
		
//		
//		if (userId.equals(user.getUserId()) && userPw.equals(user.getUserPassword())) {
//			System.out.println("로그인 성공");
//		} 
//		System.out.println("로그인 실패");
		
		
//		if (userId == ) {
//			System.out.println("로그인 성공");
//		} System.out.println("로그인 실패");
		
		
		
//		boolean login = loginCheck(user.getUserId(), user.getUserPassword());
//		System.out.println(login);
//		String userId = sc.nextLine();
		
//		System.out.println(user.getUserId());
//		um.insertUser(user.getUserId(), user.getUserPassword());
		
//		if (userId == user.getUserId()) {
//			System.out.println("로그인 성공");
//		}
//		System.out.println("<로그인 실패>");
	}
}
