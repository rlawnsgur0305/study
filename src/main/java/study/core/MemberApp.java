package study.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import study.core.member.Grade;
import study.core.member.Member;
import study.core.member.MemberService;

public class MemberApp {
	
	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig();
		
		// 이렇게 생성된 memberService는 memberServiceImpl의 구현체가 들어있음
//		MemberService memberService = appConfig.memberService();
		
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService" , MemberService.class);
		
		Member member = new Member(1L , "memberA" , Grade.VIP);
		
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		
		System.out.println("new member is = " + member.getName());
		System.out.println("find member is = " + findMember.getName());
	}
}
