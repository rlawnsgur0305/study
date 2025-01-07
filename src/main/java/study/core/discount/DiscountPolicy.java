package study.core.discount;

import study.core.member.Member;

public interface DiscountPolicy {
	
	// 할인 대상 금액을 리턴한다
	int discount(Member member , int price);
}
