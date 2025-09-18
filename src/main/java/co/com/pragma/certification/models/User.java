package co.com.pragma.certification.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {
    String name;
    String email;
    String password;
    String confirmPassword;
    String gender;
    String terms;
}