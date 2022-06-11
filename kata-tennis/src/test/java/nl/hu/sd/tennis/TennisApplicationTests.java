package nl.hu.sd.tennis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TennisApplicationTests {

	@SuppressWarnings("EmptyMethod")
	//Deze test is nog steeds nuttig, omdat het achter de schermen een Application Context maakt.
	//Mocht je dus ergens een @Component oid. vergeten zijn, dan is er een goede kans dat deze test dat vangt.
	@Test
	void contextLoads() {
	}

}
