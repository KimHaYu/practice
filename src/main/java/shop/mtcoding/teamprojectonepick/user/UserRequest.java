package shop.mtcoding.teamprojectonepick.user;

import lombok.ToString;
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
        private int usercode;
    }

    @Getter
    @Setter
    public static class BizJoinDTO {
        private String loginId;
        private String password;
        private String username;
        private String email;
        private String tel;
        private String manageBizname;
        private int usercode;
    }

    @Getter
    @Setter
    public static class LoginDTO {
        private String loginId;
        private String password;
    }

    @Getter
    @Setter
    @ToString
    public static class UpdateDTO {
        private String password;
        private String username;

        private String tel;
        private String birth;
        private String address;
        private MultipartFile pic;
    }

}
