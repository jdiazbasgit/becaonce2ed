package banco.exepciones;

/**
 * @author UsuarioM
 * @version 1.0
 * @created 23-ene.-2023 14:04:01
 */

public class SinSaldoExepcion extends java.lang.Exception {

	public SinSaldoExepcion(String message) {
		super(message);
	}

}