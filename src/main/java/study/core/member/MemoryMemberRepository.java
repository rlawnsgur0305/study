package study.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

	private static Map<Long , Member> store = new HashMap<>();
	
	
	// 회원 가입
	@Override
	public void save(Member member) {
		// 멤버를 저장하는 해시맵 store에 put 메서드를 통해 멤버 id와 연결되는 멤버 저장
		store.put(member.getId(), member);
		
	}

	// 회원 조회
	@Override
	public Member findById(long memberId) {
		// 멤버 id를 통해 일치하는 멤버 값 가져오기
		return store.get(memberId);
	}

}
