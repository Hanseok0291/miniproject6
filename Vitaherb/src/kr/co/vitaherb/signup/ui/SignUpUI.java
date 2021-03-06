package kr.co.vitaherb.signup.ui;

import kr.co.vitaherb.BaseUI;
import kr.co.vitaherb.domain.User;
import kr.co.vitaherb.loginview.ui.LoginViewUI;
import kr.co.vitaherb.mapper.UserMapper;

public class SignUpUI extends BaseUI {
	private UserMapper um;

	public SignUpUI(UserMapper um) {
		this.um = um;
	}

	public void service() {

		User user = new User();
		System.out.println(" ");
		System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*");
		System.out.println("[회원가입]");
		System.out.println("아래 정보를 작성해 주세요(*표시는 필수작성)");
		System.out.println(" ");

		while(true) {
			String userId = getStr("*아이디 : ");
			if (um.idCheck(userId)==null) {
				System.out.println("--------------------");
				System.out.println("사용할 수 있는 아이디 입니다.");
				System.out.println("--------------------");
				user.setUserId(userId);
				break;
			} else {
				System.out.println("--------------------");
				System.out.println("   중복된 아이디 입니다.   ");
				System.out.println("   다시 입력해 주세요.   ");
				System.out.println("--------------------");
				//			SignUpUI ui = new SignUpUI(um);
				//			ui.service();
			}
		}


		user.setUserPassword(getStr("*비밀번호 : "));
		user.setUserName(getStr("*이름 : "));
		user.setUserBirth(getInt("*생년월일 : "));
		user.setUserGender(getStr("*성별 : "));
		while(true) {
			String userEmail = getStr("*이메일 : ");
			if (um.emailCheck(userEmail)==null) {
				System.out.println("--------------------");
				System.out.println("사용할 수 있는 메일주소 입니다.");
				System.out.println("--------------------");
				user.setUserEmail(userEmail);
				break;
			} else {
				System.out.println("--------------------");
				System.out.println("   중복된 메일주소 입니다.  ");
				System.out.println("   다시 입력해 주세요.   ");
				System.out.println("--------------------");
				//			SignUpUI ui = new SignUpUI(um);
				//			ui.service();
			}
		}

		user.setUserAddr(getStr(" 주소 : "));
		user.setUserPhone(getStr(" 연락처 : "));
		um.insertUser(user);
		System.out.println(" ");
		System.out.println("--------------------");
		System.out.println(" 회원가입이 완료되었습니다. ");
		System.out.println("--------------------");

		LoginViewUI ui = new LoginViewUI();
		try {
			ui.service();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

