package EFUB.homepage.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class NotPassMidException extends RuntimeException {
	List<Long> userIds;

	public NotPassMidException(List<Long> userIds) {
		super("서류 과정에서 탈락한 지원자입니다.");
		this.userIds = userIds;
	}
}
