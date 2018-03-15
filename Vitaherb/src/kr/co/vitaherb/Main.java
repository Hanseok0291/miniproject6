package kr.co.vitaherb;

import kr.co.vitaherb.loginview.ui.LoginViewUI;

public class Main {
	public static void main(String[] args) {
		System.out.println("a");
		try {
			LoginViewUI ui = new LoginViewUI();
			ui.service();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
