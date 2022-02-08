package EFUB.homepage.exception;

public class NoSuchUserException extends RuntimeException {
	public NoSuchUserException(){
		super("검색 조건을 만족하는 지원자가 없습니다.");
	}
}
