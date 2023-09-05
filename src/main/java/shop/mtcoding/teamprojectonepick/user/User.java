package shop.mtcoding.teamprojectonepick.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    // 유저
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 10000)
    String loginId;

    @Column(nullable = false, length = 10000)
    String password;

    @Column(nullable = false, length = 10000)
    String username;

    @Column(nullable = false, length = 10000)
    String email;

    @Column(nullable = true, length = 10000) // 수정페이지에서 구현
    String address;

    @Column(nullable = false, length = 10000)
    String tel;

    @Column(length = 10000) // 유일하게 유저에게만 들어가는 값
    String birth;

    // 기업 유저

    @Column(length = 10000)
    String manageBizname; // 회사명

    private Timestamp createdAt;

    // 개인 기업 구분 코드 -> 개인이면 1, 기업이면 2
    @Column(nullable = false)
    int usercode;

    private String picUrl;

    @Builder
    public User(Integer id, String loginId, String password, String username, String email, String address, String tel,
            String birth, String manageBizname, Timestamp createdAt, int usercode,
            String picUrl) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.username = username;
        this.email = email;
        this.address = address;
        this.tel = tel;
        this.birth = birth;
        this.manageBizname = manageBizname;
        this.createdAt = createdAt;
        this.usercode = usercode;
        this.picUrl = picUrl;
    }

}
