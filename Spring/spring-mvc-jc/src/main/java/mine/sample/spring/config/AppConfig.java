package mine.sample.spring.config;

import mine.sample.spring.bean.MyBean1;
import mine.sample.spring.bean.MyBean2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public MyBean1 myBeanOne() {
		return new MyBean1();
	}

	@Bean(name = { "myBeanTwo", "bean2" })
	public MyBean2 myBeanTwo() {
		return new MyBean2();
	}
}
