package banco.cuentas;

import java.io.Serializable;

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

	public void finalize() throws Throwable {

	}

	public String getAlias(){
		return alias;
	}

	public int getNumeroCuenta(){
		return numeroCuenta;
	}

	public void setAlias(String alias){
		this.alias = alias;
	}

	public void setNumeroCuenta(int numeroCuenta){
		this.numeroCuenta = numeroCuenta;
	}

	public int compareTo(Cuenta otra) {
		return this.getAlias().compareTo(otra.getAlias());
	}
}