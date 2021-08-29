package net.frankie.api.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityTest {
    @Test @DisplayName("패스워드 암호화 테스트")
    void main(){
        int i = 0;
        while(i<5){
            String password = "123456";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPw = passwordEncoder.encode(password);
            //값은 123456 인데 매번 달라야함
            System.out.println(hashedPw);
            i++;
        }
    }

}
