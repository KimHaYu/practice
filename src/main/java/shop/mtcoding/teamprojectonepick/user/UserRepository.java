package shop.mtcoding.teamprojectonepick.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user_tb where login_id = :login_id", nativeQuery = true)
    User findByUsername(@Param("login_id") String loginId);

    // @Modifying
    // @Query("update User u set u.username = :username where u.login_id =
    // :login_id")
    // void updateUserByUsername(@Param("login_id") String loginId,
    // @Param("username") String username);
}