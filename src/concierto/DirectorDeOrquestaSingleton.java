package concierto;

public class DirectorDeOrquestaSingleton {
	
	private static DirectorDeOrquestaSingleton directorDeOrquestaSingleton;
	private   String nombre;
	private DirectorDeOrquestaSingleton() {}
	public  String getNombre() {
		return nombre;
	}
	public  void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public  static DirectorDeOrquestaSingleton getDirectorDeOrquestaSingleton() {
		return DirectorDeOrquestaSingleton.directorDeOrquestaSingleton;
	}
	public static void setDirectorDeOrquestaSingleton(DirectorDeOrquestaSingleton directorDeOrquestaSingleton) {
		DirectorDeOrquestaSingleton.directorDeOrquestaSingleton = directorDeOrquestaSingleton;
	}
	public static DirectorDeOrquestaSingleton getInstance() {
		if(DirectorDeOrquestaSingleton.getDirectorDeOrquestaSingleton()==null)
			DirectorDeOrquestaSingleton.setDirectorDeOrquestaSingleton(new DirectorDeOrquestaSingleton());
		return DirectorDeOrquestaSingleton.getDirectorDeOrquestaSingleton();
	}
}
