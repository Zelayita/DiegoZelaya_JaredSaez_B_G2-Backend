package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DiegoZelayaJaredSaezBG2Application.class);
	}

}
