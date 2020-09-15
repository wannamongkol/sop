package kmitl.demo.wnmk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class SpringBootService {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootService.class, args);
	}
@RequestMapping(value = "/", method = RequestMethod.POST)
public String hello(@RequestBody Object object) {
	return String.format("{\"payload\":\"%s\"}", object);
	}
}


