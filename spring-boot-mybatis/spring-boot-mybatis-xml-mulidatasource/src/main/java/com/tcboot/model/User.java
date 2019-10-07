package com.tcboot.model;


import com.tcboot.enums.UserSexEnum;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
    private String passWord;
    private UserSexEnum userSex;
    private String nickName;


    public User(String userName, String passWord, UserSexEnum userSex) {
        this.passWord = passWord;
        this.userName = userName;
        this.userSex = userSex;
    }


}