package concierto.musicos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import concierto.anotaciones.Conectar;
<<<<<<< HEAD
import concierto.excepciones.SinSonidoException;
=======
import concierto.exception.SinSonidoException;
>>>>>>> branch 'springCore' of https://github.com/jdiazbasgit/becaonce2ed.git
import concierto.instrumentos.Instrumento;
import lombok.Data;

@Component("federico")
@Data

public class Solista extends Musico {
	
	private Connection conexion;
	
	@Override
	@Conectar
<<<<<<< HEAD
	public void tocar() throws SinSonidoException {
		System.out.println(getInstrumento().sonar());
=======
	public void tocar() {
		try {
			System.out.println(getInstrumento().sonar());
		} catch (SinSonidoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
>>>>>>> branch 'springCore' of https://github.com/jdiazbasgit/becaonce2ed.git
		try {
			ResultSet resultSet= getConexion().prepareStatement("select id,descripcion from cargos").executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+ " - "+ resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	@Autowired
	@Qualifier("trompeta")
	public void setInstrumento(Instrumento instrumento) {
		super.setInstrumento(instrumento);
	}

}
