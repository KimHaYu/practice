package shop.mtcoding.teamprojectonepick.user;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

public class UserRequest {
    @Getter
    @Setter
    public static class JoinDTO {
        private String loginId;
        private String password;
        private String username;
        private String email;
        private String tel;
        private String birth;

    }

    @Getter
    @Setter
    public static class LoginDTO {
        private String loginId;
        private String password;

    }

    @Getter
    @Setter
    public static class UpdateDTO {
        private String password;
        private String username;
        private String email;
        private String tel;
        private String birth;
        private String address;
        private MultipartFile pic;

    }
}
