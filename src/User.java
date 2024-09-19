public class User {

    private String id = "Admin";
    private String pw = "Admin1234";
    private String name;
    private String phone;
    private String address;
    private boolean login_state = false;

    public User(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    boolean isLogin() {
        return login_state;
    }

    void setLogin(boolean login_state) {
        this.login_state = login_state;
    }

    void logout() {
        login_state = false;
    }
}
