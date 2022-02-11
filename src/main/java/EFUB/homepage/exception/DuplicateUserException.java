package EFUB.homepage.exception;

public class DuplicateUserException extends RuntimeException {
	public DuplicateUserException(){
		super("이미 지원하셨습니다.");
	}
}
