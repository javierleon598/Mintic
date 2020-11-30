package com.example.demo;

//import org.springframework.boot.SpringApplication;
import com.example.demo.vistas.ventana;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
                 ventana ventana = new ventana();
                 
	}
        
        public static void iniciarSpring() {
		SpringApplication.run(DemoApplication.class);
                
                 
	}

}
