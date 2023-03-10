package concierto.configuracion;

import java.sql.SQLException;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.mysql.cj.jdbc.Driver;

@Configuration
@ComponentScan({"concierto.instrumentos","concierto.musicos","concierto.aspectos"})
@EnableAspectJAutoProxy
public class ConfiguracionSpring {

	@Bean
	public Driver getDriver() {
		try {
			return new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
