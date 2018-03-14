package kr.co.vitaherb.mainservice.ui;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import common.db.BaseUI;
import common.db.MyAppSqlConfig;
import kr.co.vitaherb.login.ui.FindUserUI;
import kr.co.vitaherb.login.ui.LoginUI;
import kr.co.vitaherb.mapper.UserMapper;
import kr.co.vitaherb.signup.ui.SignUpUI;

public class MainServiceUI {
	private Scanner sc = new Scanner(System.in);
    private UserMapper usermap;
    
	public LoginViewUI() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		usermap = session.getMapper(UserMapper.class);
	}
	
	
	public void service() {
		while(true) {
			BaseUI ui = null;
			switch(menu()) {
			case 1 : ui = new SignUpUI(usermap); break;
			case 2 : ui = new LoginUI(usermap); break;
			case 3 : ui = new FindUserUI(usermap); break;
			}
			ui.service();
		}
	}
	
	
  private int menu() {
	  
	  System.out.println("Vitaherb에 오신 것을 환영합니다.");
	  System.out.println("************************");
	  System.out.println("1. 회원가입");
	  System.out.println("2. 로그인");
	  System.out.println("3. 아이디, 비밀번호 찾기");
	  System.out.println("************************");
	  System.out.print("원하시는 기능을 선택하세요 : ");
	  return Integer.parseInt(sc.nextLine());
	  
  }

}
