package kr.co.vitaherb.domain;

//사용자 정보 테이블 
public class User {

	// 아이디 
	private String userId;

	// 비밀번호 
	private String userPassword;

	// 이름  
	private String userName;

	// 생년월일 
	private int userBirth;

	// 성별 
	private String userGender;

	// 이메일 
	private String userEmail;

	// 주소 
	private String userAddr;

	// 연락처 
	private String userPhone;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(int userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

}
