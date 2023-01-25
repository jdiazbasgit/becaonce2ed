package banco.cuentas;


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

	public void setAlias(String alias){
		this.alias = alias;
	}


	public void setNumeroCuenta(int numeroCuenta){
		this.numeroCuenta=numeroCuenta;
	}
}