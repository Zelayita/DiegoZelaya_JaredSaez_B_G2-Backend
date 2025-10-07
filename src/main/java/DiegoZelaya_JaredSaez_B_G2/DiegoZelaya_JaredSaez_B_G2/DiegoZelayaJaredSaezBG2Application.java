package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiegoZelayaJaredSaezBG2Application {

	public static void main(String[] args) {
		// Carga variables del .env al sistema
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);
		SpringApplication.run(DiegoZelayaJaredSaezBG2Application.class, args);
	}

}
