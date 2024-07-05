package hobbiedo.user.auth.member.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdatePasswordDTO {
	private String uuid;
	private String currentPassword;
	private String newPassword;
}
