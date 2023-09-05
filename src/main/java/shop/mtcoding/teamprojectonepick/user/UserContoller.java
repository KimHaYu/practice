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

    /*
     * 1. 사용자가 회원 정보 수정 요청을 보낸다
     * 2. 컨트롤러가 DTO로 데이터를 받는다.
     */

    @PostMapping("/userUpdate")
    public String update(UserRequest.UpdateDTO updateDTO) {
        System.out.println(updateDTO);
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

    @GetMapping("/bizProfileForm")
    public String bizProfileForm() {
        return "/biz/bizProfileForm";
    }

    @GetMapping("/fixUserProfileForm")
    public String fixUserProfile() {
        return ("/user/fixUserProfileForm");
    }

    @GetMapping("/fixBizProfileForm")
    public String fixBizProfileForm() {
        return "/biz/fixBizProfileForm";
    }

    @PostMapping("/userJoin")
    public String userJoin(UserRequest.JoinDTO joinDTO) {
        userService.유저회원가입(joinDTO);

        return "/index/loginForm";
    }

    @PostMapping("/bizUserJoin")
    public String bizuserJoin(UserRequest.BizJoinDTO bizjoinDTO) {
        userService.기업유저회원가입(bizjoinDTO);

        return "/index/loginForm";
    }

    @GetMapping("/bizJoinForm")
    public String bizJoinForm() {
        return "/biz/bizJoinForm";
    }
}
