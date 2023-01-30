package banco.exepciones;


/**
 * @author UsuarioM
 * @version 1.0
 * @created 23-ene.-2023 14:04:01
 */
@SuppressWarnings("serial")
public class SinSaldoExepcion extends Exception {

	public SinSaldoExepcion(String message) {
		super(message);
	}	
	
}//end SinSaldoExepcion