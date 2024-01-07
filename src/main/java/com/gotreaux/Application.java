package com.gotreaux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
@CommandScan(basePackages = "com.gotreaux.commands")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
