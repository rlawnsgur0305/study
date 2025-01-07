package study.core.order;

import study.core.discount.DiscountPolicy;
import study.core.member.Member;
import study.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
	
	// OrderServiceImpl은 어떤 역할이랑 일 해야하는지만 알면 된다, 그 역할을 누가 수행하는지는 몰라도 됨  

	// 멤버 레포지토리를 통해 주문을 실시할 멤버 정보를 찾음
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	
	
	public OrderServiceImpl (MemberRepository memberRepository , DiscountPolicy discountPolicy) {
		// memberRepository 얘랑 discountPolicy 얘가 들어올건 생성자를 통해 알지만 이건 어디까지나 인터페이스지 구현체가 아님
		// 즉 orderServiceImpl은 어떤 구현체가 들어올지 모름 그냥 이 역할이랑 같이 일 하면 되는구나 이것만 알고 있는 상태에서 실행됨
		// 이 객체의 주입은 이제 외부 AppConfig에서 진행됨
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		// 멤버 레포지토리의 findById 메서드를 통해 주문을 실시할 멤버 인스턴스를 가져온다.
		Member member = memberRepository.findById(memberId);
		
		// 할인정책의 discount 메서드를 통해 멤버의 등급을 확인하고 할인시킬 원 금액을 통해 계산을 실시한다.
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		// 주문 정보를 리턴하는데 이때 담기는 정보는 멤버 id , 구매하고자 하는 상품의 이름 , 원래 아이템의 가격 , 할인 가격
		return new Order(memberId , itemName , itemPrice , discountPrice);
		 
	}
	
	

}
