package hobbiedo.user.auth.member.vo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "프로필 메시지 요청")
public class ProfileMessageRequestVo {

	private String profileMessage;

	public ProfileMessageRequestVo(String profileMessage) {
		this.profileMessage = profileMessage;
	}
}
