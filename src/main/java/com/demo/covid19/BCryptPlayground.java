package com.demo.covid19;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptPlayground {

    public static void main(String... args) {
        String password = "123456";
//        String hashedPassword = "$2a$10$Y9KsSjabinBHJvWVVS3SvuJBWRWRcS75qQ9Dt0HEXMcdr5qDuMLne";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        if (BCrypt.checkpw(password, hashed)) {
            System.out.println("match");
            System.out.println(hashed);
        } else {
            System.out.println("not");
        }

//        $2a$10$xQcuJWzADdz7geu5Ee0bG.PxylD41cU3IMv3BPMXREzwPSwXeO8pK
//        $2a$10$Y9KsSjabinBHJvWVVS3SvuJBWRWRcS75qQ9Dt0HEXMcdr5qDuMLne

    }
}
