package io.lw.bitcoinexplorer1112background;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@MapperScan("io.lw.bitcoinexplorer1112background.dao")
//@EnableScheduling
@EnableAsync
public class Bitcoinexplorer1112backgroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(Bitcoinexplorer1112backgroundApplication.class, args);
    }

}
