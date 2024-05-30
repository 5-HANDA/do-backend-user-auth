package hobbiedo.user.auth.global.api.code.status;

import org.springframework.http.HttpStatus;

import hobbiedo.user.auth.global.api.code.BaseErrorCode;
import hobbiedo.user.auth.global.api.dto.ErrorReasonDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
	VALID_EXCEPTION(HttpStatus.BAD_REQUEST, "GLOBAL400", "데이터베이스 유효성 에러"),

	USER_INTEGRATED_LOGIN_FAIL(HttpStatus.BAD_REQUEST, "USER401", "아이디 혹은 비밀번호가 일치하지 않습니다."),
	USER_REFRESH_EXPIRED(HttpStatus.UNAUTHORIZED, "USER402", "리프레시 토큰의 유효기간이 만료되었습니다."),
	NOT_REFRESH_TOKEN_TYPE(HttpStatus.UNAUTHORIZED, "USER403", "해당 토큰은 리프레시 토큰 타입이 아닙니다."),
	ALREADY_USE_LOGIN_ID(HttpStatus.BAD_REQUEST, "MEMBER401", "이미 사용 중인 아이디입니다."),
	ALREADY_USE_EMAIL(HttpStatus.BAD_REQUEST, "MEMBER402", "이미 사용 중인 이메일입니다."),
	ALREADY_USE_PHONE_NUMBER(HttpStatus.BAD_REQUEST, "MEMBER403", "이미 사용 중인 전화번호입니다."),
	NOT_EXIST_TOKEN(HttpStatus.NOT_FOUND, "USER404", "존재하지 않는 리프레시 토큰입니다."),
	FIND_LOGIN_ID_FAIL(HttpStatus.BAD_REQUEST, "MEMBER406", "회원 아이디 찾기에 실패했습니다");

	private final HttpStatus httpStatus;
	private final String status;
	private final String message;

	/**
	 * getReason()함수를  사용해야 할 때
	 * 1. 간결성과 보안: API 응답에서 꼭 필요한 정보만을 포함시키기 위해 사용(ex: API 응답의 크기 감소, 민감한 데이터 제한)
	 * 2. 내부 처리용: API 응답 전송 전,내부 로그나 모니터링 시스템에 오류 정보를 기록할때 사용 로그 데이터의 크기를 줄이거나 처리를 단순화
	 * 3. HTTP 상태 코드 분리: getReason()을 사용하여 오류 코드와 메시지만을 전달하고, HTTP 상태 코드는 별도로 처리 가능
	 * 4. 성능 최적화: 성능이 중요한 환경에서는 가능한 한 응답을 간단하게 유지하여 이러한 오버헤드를 최소화
	 * 5. API 설계의 일관성: 오류 처리를 통합하여 여러 다른 API에서 일관된 방식으로 오류를 보고하고 싶을 때 유용
	 */
	@Override
	public ErrorReasonDto getReason() {
		return ErrorReasonDto
			.builder()
			.code(status)
			.message(message)
			.build();
	}

	@Override
	public ErrorReasonDto getReasonHttpStatus() {
		return ErrorReasonDto
			.builder()
			.httpStatus(httpStatus)
			.code(status)
			.message(message)
			.build();
	}
}
