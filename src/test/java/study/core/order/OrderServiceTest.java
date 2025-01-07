package study.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import study.core.AppConfig;
import study.core.member.Grade;
import study.core.member.Member;
import study.core.member.MemberService;

public class OrderServiceTest {
	
	AppConfig appConfig = new AppConfig();
	
	MemberService memberService = appConfig.memberService();
	OrderService orderService = appConfig.orderService();
	
	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member (memberId , "memberA" , Grade.VIP);
		
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}

}
