package dooyaspring.boothello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"dooyaspring.boothello.mapper"})
public class BootHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootHelloApplication.class, args);
    }

}
