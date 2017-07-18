package gevak.dto;


public class UserDTO {

    private int userId;
    private String userSurname;
    private String userName;
    private int userP1;
    private int userP2;
    private int userP3;
    private int userAtestat;
    private String userAvatar;


    public UserDTO() {
    }

    public UserDTO(int userId, String userSurname, String userName, int userP1, int userP2, int userP3, int userAtestat, String userAvatar) {
        this.userId = userId;
        this.userSurname = userSurname;
        this.userName = userName;
        this.userP1 = userP1;
        this.userP2 = userP2;
        this.userP3 = userP3;
        this.userAtestat = userAtestat;
        this.userAvatar = userAvatar;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserP1() {
        return userP1;
    }

    public void setUserP1(int userP1) {
        this.userP1 = userP1;
    }

    public int getUserP2() {
        return userP2;
    }

    public void setUserP2(int userP2) {
        this.userP2 = userP2;
    }

    public int getUserP3() {
        return userP3;
    }

    public void setUserP3(int userP3) {
        this.userP3 = userP3;
    }

    public int getUserAtestat() {
        return userAtestat;
    }

    public void setUserAtestat(int userAtestat) {
        this.userAtestat = userAtestat;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userSurname='" + userSurname + '\'' +
                ", userName='" + userName + '\'' +
                ", userP1=" + userP1 +
                ", userP2=" + userP2 +
                ", userP3=" + userP3 +
                ", userAtestat=" + userAtestat +
                '}';
    }
}
