package study.core.member;

public class MemberServiceImpl implements MemberService{
	
	// db에 저장하거나 조회하는 로직이 작성되어 있고 그걸 사용하기 위해 memberRepository 인스턴스 생성
	
	// 여기도 마찬가지로 MemberServiceImpl이 memberRepository 역할과 함께 일한다만 알면 되는데 누가 할건지 까지 직접 정하고 잇음 이건 안됌
	private final MemberRepository memberRepository;
	
	
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	
	// 회원 가입
	@Override
	public void join(Member member) {
		// 다형성에 의해서 MemberRepository를 구현한 MemoryMemberRepository에 구현한 save 함수가 호출된다
		memberRepository.save(member);
	}

	// 회원 조회
	@Override
	public Member findMember(Long memberId) {
		// 다형성에 의해서 MemberRepository를 구현한 MemoryMemberRepository에 구현한 join 함수가 호출된다
		return memberRepository.findById(memberId);
	}

}
