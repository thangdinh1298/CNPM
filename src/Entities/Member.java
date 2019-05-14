package Entities;

public class Member {
    private int id;
    private String sername;
    private String password;
    private String fullname;
    private String role;
    private String idcard;
    private String address;
    private String tel;

    public Member(int id, String sername, String password, String fullname,
                  String role, String idcard, String address, String tel) {
        this.id = id;
        this.sername = sername;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.idcard = idcard;
        this.address = address;
        this.tel = tel;
    }
}
