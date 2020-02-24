package server;

import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {

    private class UserData {
        String login;
        String password;
        String nickname;

        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    private List<UserData> users;

    public SimpleAuthService() {
        users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            users.add(new UserData("login" + i, "pass" + i, "nick" + i));
        }
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        for (UserData o:users) {
            if(o.login.equals(login) && o.password.equals(password)){
                return o.nickname;
            }
        }
        return null;
    }
    public  int getIndex(String nickName){
        int i = 0;
        for (UserData u: users) {
            if(u.nickname.equals(nickName))
                return  i;
            i++;
        }
        return -1;
    }
}
