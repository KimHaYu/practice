package shop.mtcoding.teamprojectonepick.core.error.ex;

public class PasswordNotMatchedException extends RuntimeException {

    public PasswordNotMatchedException() {
        super("비밀번호 오류!!");
    }

    public PasswordNotMatchedException(String message) {
        super(message);
    }
}
