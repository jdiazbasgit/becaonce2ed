package banco.cuentas;

import java.io.Serializable;

/**
 * @author UsuarioM
 * @version 1.0
 * @created 23-ene.-2023 14:03:50
 */

@SuppressWarnings("serial")
public class Cuenta implements Comparable<Cuenta>,Serializable{

	private String alias;
	private int numeroCuenta;

	public Cuenta(){

	}

	public Cuenta(String alias, int numeroCuenta){
		
		setAlias(alias);
		setNumeroCuenta(numeroCuenta);

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
		this.numeroCuenta = numeroCuenta;
	}

	@Override
	public int compareTo(Cuenta otra) {
		return this.getAlias().compareTo(otra.getAlias());
	}

	 public int getSaldo() {
		// TODO Auto-generated method stub
		return 0;
	}

}