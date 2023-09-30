package br.com.fiap.checkpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiap.checkpoint.controller.MaxConsecutiveOnesController;
import br.com.fiap.checkpoint.controller.ParenthesesValidatorController;
import br.com.fiap.checkpoint.controller.SingleNumberController;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(ParenthesesValidatorController.class, args);
        SpringApplication.run(MaxConsecutiveOnesController.class, args);
        SpringApplication.run(SingleNumberController.class, args);
    }

}
