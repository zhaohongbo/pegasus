package net.eric.domain;

/**
 * @author Eric Zhao
 * @date 2018/2/13
 */
public class UserInfo {
    private int id;
    private int uid;
    private String nickname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
