package net.codejava;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//calls password encoder to encrpyt the password

public class PasswordEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "mark2022";
		String encodedPassword = encoder.encode(rawPassword);
		
		
		System.out.println(encodedPassword);
	}

}
