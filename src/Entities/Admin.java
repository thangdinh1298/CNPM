package Entities;

public class Admin extends Member {
    public Admin(int id, String sername, String password, String fullname,
                 String role, String idcard, String address, String tel) {
        super(id, sername, password, fullname, role, idcard, address, tel);
    }
}
