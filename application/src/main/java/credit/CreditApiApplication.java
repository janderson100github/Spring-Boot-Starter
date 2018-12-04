package credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"credit"})
public class CreditApiApplication {

    public CreditApiApplication() {
        // Spring boot start app
    }

    public static void main(String[] args) {
        SpringApplication.run(CreditApiApplication.class, args);
    }
}
