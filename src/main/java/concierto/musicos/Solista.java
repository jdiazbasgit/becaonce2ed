package concierto.musicos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import concierto.anotaciones.Conectar;
import concierto.instrumentos.Instrumento;
import lombok.Data;

@Component("federico")
@Data

public class Solista extends Musico {
	
	private Connection conexion;
	
	@Override
	@Conectar
	public void tocar() {
		System.out.println(getInstrumento().sonar());
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
