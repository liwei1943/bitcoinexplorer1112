package io.lw.bitcoinexplorer1112background;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("io.lw.bitcoinexplorer1112background.dao")
public class Bitcoinexplorer1112backgroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(Bitcoinexplorer1112backgroundApplication.class, args);
    }

}
