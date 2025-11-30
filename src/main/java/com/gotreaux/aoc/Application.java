package com.gotreaux.aoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
@CommandScan(basePackages = "com.gotreaux.aoc.commands")
public class Application {
    static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
