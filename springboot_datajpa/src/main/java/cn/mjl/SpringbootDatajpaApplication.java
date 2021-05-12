package cn.mjl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching  //使用缓存
public class SpringbootDatajpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDatajpaApplication.class, args);
    }

}
