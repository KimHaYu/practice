package shop.mtcoding.teamprojectonepick.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserContoller {
    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;

    @PostMapping("/userLogin")
    public String userLogin(UserRequest.LoginDTO loginDTO) {
        User sessionUser = userService.유저로그인(loginDTO);
        session.setAttribute("sessionUser", sessionUser);

        System.out.println("테스트: " + sessionUser.getLoginId());
        return "redirect:/";
    }

    @GetMapping("/userLoginForm")
    public String userLoginForm() {
        return ("/index/loginForm");
    }

    @GetMapping("/userJoinForm")
    public String userJoinForm() {
        return ("/user/userJoinForm");
    }

    @GetMapping("/userProfileForm")
    public String userProfile() {
        return ("/user/userProfileForm");
    }

    @GetMapping("/fixUserProfileForm")
    public String fixUserProfile() {
        return ("/user/fixUserProfileForm");
    }

    @PostMapping("/userJoin")
    public String userJoin(UserRequest.JoinDTO joinDTO) {
        userService.유저회원가입(joinDTO);

        return "/index/loginForm";
    }
}
