package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value = {"app.dao.mappers", "app.**.**.mappers", "app.dao.complex"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.printf("                                     \n" +
                "                                        /~~~~~\\        /~~~~~\\\n" +
                "                                       |    (~'        ~~~)   |\n" +
                "                                        \\    \\__________/    /\n" +
                "                                        /~::::::::         ~\\\n" +
                "                             /~~~~~~~-_| ::::::::             |_-~~~~~~~\\\n" +
                "                            \\ ======= /|  ::A::;      A     :|\\ ====== /\n" +
                "                             ~-_____-~ |  _----------------_::| ~-____-~\n" +
                "                                       |/~                  ~\\|\n" +
                "                                       /                      \\\n" +
                "                                      (        ()    ()        )\n" +
                "                                       `\\                   ./'\n" +
                "                                         ~-_______________-~\n" +
                "                                               /~~~~\\\n" +
                "                                              |      |\n" +
                "                                              |      |\n" +
                "                                             (________)    \n" +
                "                                                 ()              " + System.getProperty("line.separator"));

    }
}
