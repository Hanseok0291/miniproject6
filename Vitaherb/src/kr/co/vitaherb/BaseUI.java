package kr.co.vitaherb;

import java.util.Scanner;

public abstract class BaseUI {

	Scanner sc = new Scanner(System.in);

	public abstract void service();

	public String getStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}

	public int getInt(String msg) {
		System.out.print(msg);
		return Integer.parseInt(sc.nextLine());
	}


}
