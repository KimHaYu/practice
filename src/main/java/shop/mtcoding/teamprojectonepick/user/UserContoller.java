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

    @PostMapping("/user/update")
    public String update(UserRequest.UpdateDTO updateDTO) {
        // 1. 회원수정 (서비스)
        // 2. 세션동기화
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.회원수정(updateDTO, sessionUser.getId());
        session.setAttribute("sessionUser", user);
        return "redirect:/";
    }

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
