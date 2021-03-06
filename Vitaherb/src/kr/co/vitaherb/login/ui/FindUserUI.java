package kr.co.vitaherb.login.ui;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.User;
import kr.co.vitaherb.loginview.ui.LoginViewUI;
import kr.co.vitaherb.mapper.UserMapper;

public class FindUserUI extends BaseUI {

	private UserMapper um;
	public FindUserUI(UserMapper um) {
		this.um = um;
	}

	public void service() {

		System.out.println(" ");
		System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*");
		System.out.println("[아이디, 비밀번호 찾기]");
		String email = getStr("이메일 입력 : ");

		LoginViewUI.user = new User();
		LoginViewUI.user = um.findUser(email);
		System.out.println("--------------------");
		System.out.println("   아이디 : " + LoginViewUI.user.getUserId());
		System.out.println("   비밀번호 : " + LoginViewUI.user.getUserPassword());
		System.out.println("--------------------");


	}

}
