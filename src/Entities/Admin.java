package Entities;

public class Admin extends Member {
    public Admin(int id, String Username, String password, String fullname,
                 String role, String address, String tel) {
        super(id, Username, password, fullname, role, address, tel);
    }
}
