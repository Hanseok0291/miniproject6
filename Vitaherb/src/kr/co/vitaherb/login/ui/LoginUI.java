package kr.co.vitaherb.login.ui;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.User;
import kr.co.vitaherb.loginview.ui.LoginViewUI;
import kr.co.vitaherb.mainservice.ui.MainServiceUI;
import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.GoodsMapper;
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
		
		if(um.loginUser(userId)==null) {
			System.out.println("--------------------");
			System.out.println("없는 아이디입니다.");
			System.out.println("--------------------");
			System.out.print("1. 다시 시도하기"+"\n"+"2. 회원정보 찾기");
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 : 
		    LoginUI ui = new LoginUI(um);
			ui.service();
			break;
			case 2 : 
		    FindUserUI ui2 = new FindUserUI(um);
		    ui2.service();
		    break;
			}
		}
		
	
		if(passWord.equals(LoginViewUI.user.getUserPassword())) {
			System.out.println("--------------------");
			System.out.println("로그인에 성공했습니다.");
			System.out.println("--------------------");
			
			SqlSession session = MyAppSqlConfig.getSqlSession();
			CartMapper cm = session.getMapper(CartMapper.class);
			cm.deleteCart();
			
			MainServiceUI ui = new MainServiceUI();
			ui.service();
		} else if(um.loginUser(userId)!=null && passWord.equals(LoginViewUI.user.getUserPassword())) {
			System.out.println("--------------------");
			System.out.println("비밀번호가 일치하지 않습니다.");
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
