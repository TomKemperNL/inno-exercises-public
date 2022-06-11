package nl.hu.sd.inno.dddrefactoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    //Deze main doet niets, maar zonder een @SpringBootApplication class werkt alles net-even-anders. Dus vooruit dan maar.
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
