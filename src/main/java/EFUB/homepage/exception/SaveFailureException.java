package EFUB.homepage.exception;

public class SaveFailureException extends RuntimeException {
	public SaveFailureException(){
		super("저장하는데 오류가 발생했습니다.");
	}
}
