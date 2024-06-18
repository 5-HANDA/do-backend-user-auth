package hobbiedo.user.auth.member.vo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "프로필 이미지 업로드 요청")
public class ProfileImageRequestVo {

	private String profileImageUrl;

	public ProfileImageRequestVo(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
}
