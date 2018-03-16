package common.db;

import java.util.Scanner;

import kr.co.vitaherb.domain.Goods;

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
