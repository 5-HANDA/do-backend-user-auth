package hobbiedo.user.auth.member.dto.request;

import hobbiedo.user.auth.member.vo.request.ProfileImageRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileImageRequestDto {

	private String profileImageUrl;

	// Vo 객체를 Dto 객체로 변환
	public static ProfileImageRequestDto profileImageVoToDto(ProfileImageRequestVo profileImageRequestVo) {

		return ProfileImageRequestDto.builder()
				.profileImageUrl(profileImageRequestVo.getProfileImageUrl())
				.build();
	}
}
