package shop.mtcoding.teamprojectonepick.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamprojectonepick.user.UserRequest.LoginDTO;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void 유저회원가입(UserRequest.JoinDTO joinDTO) {
        User user = User.builder()
                .loginId(joinDTO.getLoginId())
                .password(joinDTO.getPassword())
                .username(joinDTO.getUsername())
                .email(joinDTO.getEmail())
                .tel(joinDTO.getTel())
                .birth(joinDTO.getBirth())
                .build();
        userRepository.save(user);
    }

    @Transactional
    public User 유저로그인(LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getLoginId());

        // // 1. 유저네임 검증
        // if (user == null) {
        // throw new MyException("유저네임이 없습니다");
        // }

        // // 2. 패스워드 검증
        // if (!user.getPassword().equals(loginDTO.getPassword())) {
        // throw new MyException("패스워드가 잘못되었습니다");
        // }

        // 3. 로그인 성공
        return user;
    }
}
