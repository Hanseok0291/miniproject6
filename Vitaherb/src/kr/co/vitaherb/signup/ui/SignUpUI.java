package kr.co.vitaherb.signup.ui;

import common.db.BaseUI;
import kr.co.vitaherb.mapper.UserMapper;

public class SignUpUI extends BaseUI {
	private UserMapper dao;
	
	public SignUpUI(UserMapper dao) {
		this.dao = dao;
	}
	
	public void service() {
		UserMapper user = new UserMapper();
		System.out.println("아래 정보를 작성해 주세요");
		System.out.print("이름 : ");
		
	}
}
