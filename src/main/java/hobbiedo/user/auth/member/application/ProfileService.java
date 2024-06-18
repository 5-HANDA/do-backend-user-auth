package hobbiedo.user.auth.member.application;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hobbiedo.user.auth.global.api.code.status.ErrorStatus;
import hobbiedo.user.auth.global.exception.MemberExceptionHandler;
import hobbiedo.user.auth.member.domain.Member;
import hobbiedo.user.auth.member.dto.response.ProfileResponseDto;
import hobbiedo.user.auth.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProfileService {

	private final MemberRepository memberRepository;

	public ProfileResponseDto getProfile(String uuid) {

		Optional<Member> member = memberRepository.findByUuid(uuid);

		if (member.isEmpty()) {
			throw new MemberExceptionHandler(ErrorStatus.NOT_FOUND_MEMBER);
		}

		return ProfileResponseDto.builder()
			.uuid(member.get().getUuid())
			.name(member.get().getName())
			.email(member.get().getEmail())
			.phoneNumber(member.get().getPhoneNumber())
			.birth(member.get().getBirth())
			.gender(member.get().getGender())
			.profileImageUrl(member.get().getImageUrl())
			.profileMessage(member.get().getProfileMessage())
			.build();
	}
}
