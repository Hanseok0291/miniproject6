package kr.co.vitaherb.signup.ui;

import common.db.BaseUI;
import kr.co.vitaherb.domain.User;
import kr.co.vitaherb.mapper.UserMapper;

public class SignUpUI extends BaseUI {
    private UserMapper um;
    
    public SignUpUI(UserMapper um) {
        this.um = um;
    }
    
    public void service() {
        User user = new User();
        System.out.println("아래 정보를 작성해 주세요");
        user.setUserName(getStr("이름 : "));
        user.setUserBirth(getInt("생년월일 : "));
        user.setUserGender(getStr("성별 : "));
        user.setUserId(getStr("아이디 : "));
        user.setUserPassword(getStr("비밀번호 : "));
        user.setUserEmail(getStr("이메일 : "));
        user.setUserAddr(getStr("주소 : "));
        user.setUserPhone(getStr("연락처 : "));
        um.insertUser(user);
        System.out.println("회원가입이 완료되었습니다.");
    }
}
