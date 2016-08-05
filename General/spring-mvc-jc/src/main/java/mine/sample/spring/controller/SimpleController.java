package mine.sample.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class SimpleController {

	@RequestMapping("/handlerMethod")
	public String returnView() {
		return "mySimpleRootView";
	}
}