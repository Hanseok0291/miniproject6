package kr.co.vitaherb.loginview.ui;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.User;
import kr.co.vitaherb.login.ui.FindUserUI;
import kr.co.vitaherb.login.ui.LoginUI;
import kr.co.vitaherb.mapper.CartMapper;
import kr.co.vitaherb.mapper.UserMapper;
import kr.co.vitaherb.signup.ui.SignUpUI;

public class LoginViewUI {
	public static User user;
	private UserMapper um;
	private CartMapper cm;
	private Scanner sc = new Scanner(System.in);

	public LoginViewUI() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		um = session.getMapper(UserMapper.class);
		cm = session.getMapper(CartMapper.class);
	}

	public void service() throws Exception {
		BaseUI ui = null;
		while(true) {
			switch(menu()) {
			case 1 : ui = new SignUpUI(um); break;
			case 2 : ui = new LoginUI(um,cm); break;
			case 3 : ui = new FindUserUI(um);
			}
			ui.service();
		}
	}

	private int menu() {

		System.out.println(" ");
		System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*");
		System.out.println("Vitaherb에 오신 것을 환영합니다.");
		System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 아이디, 비밀번호 찾기");
		System.out.println("----------------------------");
		System.out.print("원하시는 메뉴를 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

}
