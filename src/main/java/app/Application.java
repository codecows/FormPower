package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("app.dao.mappers")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.printf("                               +---------------------------------------------+" + System.getProperty("line.separator"));
        System.out.printf("                               |           ---       启动成功     ---         |" + System.getProperty("line.separator"));
        System.out.printf("                               +---------------------------------------------+" + System.getProperty("line.separator"));

    }
}
