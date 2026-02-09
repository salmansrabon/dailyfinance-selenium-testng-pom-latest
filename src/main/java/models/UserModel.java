package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {
    private String firstname;
    private String lastname;
    private String email;
    private String phonenumber;
    private String password;
    private String address;

    public UserModel(){}
}
