package com.tcboot.model;


import com.tcboot.enums.UserSexEnum;
import lombok.*;

import java.io.Serializable;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String passWord;
	private UserSexEnum userSex;
	private String nickName;

	public static void main(String[] args) {
		User xx = User.builder().passWord("xx").nickName("123").build();
	}
}
