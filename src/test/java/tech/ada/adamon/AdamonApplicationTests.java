package tech.ada.adamon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
class AdamonApplicationTests {

	@Value("${legume.cozinha}")
	String value;


	@Test
	void contextLoads() {
		System.out.println(value);
	}

}
