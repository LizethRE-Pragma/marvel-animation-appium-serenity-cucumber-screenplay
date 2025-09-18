package co.com.pragma.certification.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Character {
    String name;
    String nickName;
}