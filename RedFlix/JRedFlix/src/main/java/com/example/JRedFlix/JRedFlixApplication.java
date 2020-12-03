package com.example.JRedFlix;

import com.example.JRedFlix.vistas.Ventana;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JRedFlixApplication {

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }

    public static void iniciarSpring() {
        SpringApplication.run(JRedFlixApplication.class);
    }

}
