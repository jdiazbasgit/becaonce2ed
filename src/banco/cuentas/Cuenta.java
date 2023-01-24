package banco.cuentas;


/**
 * @author UsuarioM
 * @version 1.0
 * @created 23-ene.-2023 14:03:50
 */
public class Cuenta {

	private String alias;
	private int numeroCuenta;

	public Cuenta(){

	}

	public void finalize() throws Throwable {

	}
	public String getAlias(){
		return alias;
	}

	public int getNumeroCuenta(){
		return numeroCuenta;
	}

	/**
	 * 
	 * @param alias
	 */
	public void setAlias(String alias){
		this.alias = alias;
	}

	/**
	 * 
	 * @param numeroCuenta
	 */
	public void setNumeroCuenta(int numeroCuenta){
		this.numeroCuenta=numeroCuenta;
	}
}//end Cuenta