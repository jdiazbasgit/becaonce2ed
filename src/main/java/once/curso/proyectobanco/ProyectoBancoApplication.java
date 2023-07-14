package once.curso.proyectobanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import once.curso.proyectobanco.threads.BancoThread;

@SpringBootApplication
public class ProyectoBancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoBancoApplication.class, args);

	}
	

}
