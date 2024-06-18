package hobbiedo.user.auth.member.dto.request;

import hobbiedo.user.auth.member.vo.request.ProfileImageRequestVo;
import hobbiedo.user.auth.member.vo.request.ProfileMessageRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileMessageRequestDto {

	private String profileMessage;

	// Vo 객체를 Dto 객체로 변환
	public static ProfileMessageRequestDto profileMessageVoToDto(
		ProfileMessageRequestVo profileMessageRequestVo) {

		return ProfileMessageRequestDto.builder()
				.profileMessage(profileMessageRequestVo.getProfileMessage())
				.build();
	}
}
