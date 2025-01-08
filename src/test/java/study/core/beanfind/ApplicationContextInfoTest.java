package study.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import study.core.AppConfig;

public class ApplicationContextInfoTest {
	
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("application 빈 출력")
	void findAllApplicationBean() {
		String[] beans = ac.getBeanDefinitionNames();
		
		for (String name : beans) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(name);
			
			// ROLE_APPLICATION == 내가 직접 작성한 코드를 통해서 등록한 애플리케이션 빈
			// ROLE_INFRASTRUCTURE == 스프링이 내부에서 자체적으로 사용하는 빈
			if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
				Object bean = ac.getBean(name);
				System.out.println("name = " + name + " object = " + bean);
			}
		}
	}
}
