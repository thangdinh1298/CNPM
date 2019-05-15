package Entities;

public class Member {
    protected int id;
    protected String Username;
    protected String password;
    protected String fullname;
    protected String role;
    protected String address;
    protected String tel;

    public Member(int id, String Username, String password, String fullname,
                  String role, String address, String tel) {
        this.id = id;
        this.Username = Username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.address = address;
        this.tel = tel;
    }

    public Member() {

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getRole() {
        return role;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
