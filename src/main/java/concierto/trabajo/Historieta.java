package concierto.trabajo;

public class Historieta {
	import java.util.Scanner;

	public class Historieta {

	    public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);

	        System.out.println("¡Bienvenido! Soy un juglar que contará la historia de un valiente caballero andante.");
	        System.out.println("Este caballero se llama Juan y ha escuchado la triste noticia de que una princesa ha sido secuestrada por un malvado dragón.");
	        System.out.println("Juan, quien es un caballero muy valiente, decidió que es su deber rescatar a la princesa. Y así comienza nuestra historia...");

	        System.out.println("");
	        System.out.println("En su búsqueda de la princesa, Juan se encontró con muchas dificultades.");
	        System.out.println("Tuvo que luchar contra muchos monstruos y superar muchos obstáculos, pero finalmente llegó al castillo donde la princesa estaba prisionera.");
	        System.out.println("El castillo estaba rodeado de un foso lleno de lava, lo que hizo que el rescate fuera aún más peligroso.");

	        System.out.println("");
	        System.out.println("Juan se acercó al castillo y se dio cuenta de que el dragón estaba durmiendo afuera del castillo.");
	        System.out.println("El caballero decidió que era su oportunidad de rescatar a la princesa sin despertar al dragón.");
	        System.out.println("Pero el foso de lava era demasiado peligroso para cruzar.");

	        System.out.println("");
	        System.out.println("¿Qué debería hacer Juan?");
	        System.out.println("1. Buscar una manera de cruzar el foso de lava.");
	        System.out.println("2. Intentar caminar por el borde del foso.");
	        System.out.println("3. Esperar a que el dragón se despierte y luchar contra él para poder entrar al castillo.");

	        int opcion = scanner.nextInt();

	        switch (opcion) {
	            case 1:
	                System.out.println("");
	                System.out.println("Juan buscó alrededor y encontró un puente colgante que cruzaba el foso de lava.");
	                System.out.println("El puente era muy inestable y peligroso, pero Juan sabía que era su única opción para rescatar a la princesa.");
	                System.out.println("Con mucho cuidado, Juan cruzó el puente y logró llegar al otro lado del foso.");

	                System.out.println("");
	                System.out.println("Ahora que Juan estaba en el castillo, debía encontrar a la princesa.");
	                System.out.println("¿Qué debería hacer Juan?");
	                System.out.println("1. Buscar en las habitaciones del castillo.");
	                System.out.println("2. Preguntarle a los guardias si han visto a la princesa.");
	                System.out.println("3. Buscar en las mazmorras del castillo.");

	                opcion = scanner.nextInt();

	                switch (opcion) {
	                    case 1:
	                        System.out.println("");
	                        System.out.println("Juan buscó en todas las habitaciones del castillo, pero no encontró a la princesa.");
	                        System.out.println("Después de mucho tiempo buscando, finalmente encontró una pista que lo llevó a las mazmorras del castillo.");

	                        System.out.println("");
	                        System.out.println("En las mazmorras,Juan encontró a la princesa en una de las celdas de las mazmorras. Estaba muy feliz de haberla encontrado, pero el trabajo no había terminado todavía.
	                        		System.out.println (La princesa estaba muy débil y no podía caminar por sí sola, por lo que Juan tuvo que cargarla en sus brazos para escapar del castillo.
	                        		 
	                        				System.out.println  Pero el dragón había despertado y estaba furioso por la intrusión de Juan en su castillo.
	                        		                        Juan sabía que tendría que luchar contra el dragón para poder escapar con la princesa. 
	                        		 
	                        		                        System.out.println ¿Qué debería hacer Juan?
	                        		                        		System.out.println 1. Luchar contra el dragón con su espada. 
	                        		                        		System.out.println   2. Usar su escudo para defenderse del fuego del dragón. 
	                        		                        		System.out.println 3. Buscar una salida secreta en las mazmorras.
	                        		 
	                        		                        opcion = scanner.nextInt();
	                        		 
	                        		                        switch (opcion) 
	                        		                            case 1:
	                        		                                System.out.println(""); 
	                        	                                System.out.println(\"Juan sacó su espada y se preparó para luchar contra el dragón.\"); 
	                        		                                System.out.println(\"Fue una batalla épica y muy peligrosa, pero finalmente Juan logró vencer al dragón.\"); 
	                        		                                System.out.println(\"Con el camino despejado, Juan y la princesa escaparon del castillo y regresaron a su hogar.\"); 
	                        		 
	                        		                                System.out.println(\"\"); 
	                        		                                System.out.println(\"Y así, la historia del valiente caballero Juan, quien rescató a la princesa de las fauces del dragón, se convirtió en una leyenda que se contaría por generaciones.\"); 
	                        		 
	                        		                                break; 
	                        		                            case 2: 
	                        		                                System.out.println(\"\"); 
	                        		                                System.out.println(\"Juan usó su escudo para protegerse del fuego del dragón.\");
	                        		                                System.out.println(\"Fue una estrategia inteligente, pero el escudo no aguantó por mucho tiempo.\"); 
	                        		                                System.out.println(\"El dragón logró herir a Juan y la princesa, lo que hizo que la misión de rescate fracasara.\"); 
	                        		 
	                        		                                System.out.println(\"\"); 
	                        		                                System.out.println(\"La historia del valiente caballero Juan, quien intentó rescatar a la princesa de las fauces del dragón, se convirtió en una triste leyenda que se contaría por generaciones.\"); 
	                        		 
	                        		                                break; 
	                        		                            case 3: 
	                        		                                System.out.println(\"\");
	                        		                                System.out.println(\"Juan buscó alrededor de las mazmorras y encontró una salida secreta.\"); 
	                        		                                System.out.println(\"Logró escapar del castillo con la princesa sin tener que luchar contra el dragón.\"); 
	                        		                                System.out.println(\"Aunque no había derrotado al dragón, Juan se sentía muy feliz de haber salvado a la princesa.\"); 
	                        		 
	                        		                                System.out.println(\"\");
	                        		                                System.out.println(\"Y así, la historia del valiente caballero Juan, quien rescató a la princesa de las fauces del dragón sin tener que luchar, se convirtió en una historia de aventura que se contaría por generaciones.\"); 
	                        		 
	                        		                                break;
	                        		                            default: 
	                        		                                System.out.println(\"\"); 
	                        		                                System.out.println(\"Opción inválida.\"); 
	                        		                                break;
	                        		                        }
	                        		 
	                        		                        break; 
	                        		                    case 2: 
	                        		                        System.out.println(\"\"); 
	                        		                        System.out.println(\"Los guardias le dijeron a Juan que la princesa estaba en las mazmorras del castillo.\"); 
	                        		                        System.out.println(\"Juan agradeció la información y se dirigió a las mazmorras para encontrar a la princesa, pero el camino a las mazmorras no sería fácil. Juan tendría que pasar por la sala del trono, donde el rey estaba sentado en su trono, rodeado de sus guardias. 
	                        		                        		
	                        		                        		                    ¿Qué debería hacer Juan? 
	                        		                        		                    1. Atacar a los guardias para abrirse camino hacia las mazmorras.
	                        		                        		                    2. Intentar convencer al rey de que le permita rescatar a la princesa. 
	                        		                        		                    3. Buscar una ruta alternativa para evitar la sala del trono.
	                        		                        		 
	                        		                        		                    opcion = scanner.nextInt();
	                        		                        		 
	                        		                        		                    switch (opcion) {
	                        		                        		                        case 1: 
	                        		                        		                            System.out.println(\"\"); 
	                        		                        		                            System.out.println(\"Juan decidió atacar a los guardias para abrirse camino hacia las mazmorras.\");
	                        		                        		                            System.out.println(\"Fue una batalla difícil, pero Juan logró derrotar a los guardias y llegar a las mazmorras.\"); 
	                        		                        		                           System.out.println(\"Allí encontró a la princesa y la rescató de las fauces del dragón.\");
	                        		                     
	                        		                        		                            System.out.println(\"\");
	                        		                        		                            System.out.println(\"Y así, la historia del valiente caballero Juan, quien derrotó a los guardias y rescató a la princesa de las fauces del dragón, se convirtió en una leyenda que se contaría por generaciones.\"); 
	                        		                        
	                        		                        		                            break;
	                        		                        		                        case 2: 
	                        		                        		                            System.out.println(\"\");
	                        		                        		                            System.out.println(\"Juan decidió intentar convencer al rey de que le permita rescatar a la princesa.\"); 
	                        		                        		                            System.out.println(\"Aunque el rey se mostró reacio al principio, Juan logró persuadirlo de que era la única manera de salvar a la princesa.\"); 
	                        		                        		                            System.out.println(\"Finalmente, el rey le dio su bendición y Juan pudo rescatar a la princesa de las fauces del dragón.\");
	                        		                        		 
	                        		                        		                            System.out.println(\"\");
	                        		                        		                            System.out.println(\"Y así, la historia del valiente caballero Juan, quien persuadió al rey y rescató a la princesa de las fauces del dragón, se convirtió en una historia de valentía y diplomacia que se contaría por generaciones.\"); 
	                        		                        		 
	                        		                        		                            break;
	                        		                        		                        case 3: 
	                        		                        		                            System.out.println(\"\"); 
	                        		                        		                            System.out.println(\"Juan decidió buscar una ruta alternativa para evitar la sala del trono.\"); 
	                        		                        	                            System.out.println(\"Después de explorar el castillo, Juan encontró una ruta secreta que lo llevó directamente a las mazmorras.\"); 
	                        		                        		                            System.out.println(\"Allí encontró a la princesa y la rescató de las fauces del dragón.\");
	                        		                        		 
	                        		                        		                            System.out.println(\"\");
	                        		                        		                            System.out.println(\"Y así, la historia del valiente caballero Juan, quien encontró una ruta alternativa y rescató a la princesa de las fauces del dragón, se convirtió en una historia de astucia y determinación que se contaría por generaciones.\"); 
	                        		                        		 
	                        		                        		                            break;
	                        		                        		                        default: 
	                        		                        		                            System.out.println(\"\"); 
	                        		                        		                            System.out.println(\"Opción inválida.\"); 
	                        		                        		                            break;
	                        		                        		                    }
	                        		                        		
	                        		                        		                    break; 
	                        		                        		                default: 
	                        		                        		                    System.out.println(\"\"); 
	                        		                        		                    System.out.println(\"Opción inválida.\"); 
	                        		                        		                    break;
	                        		                        		 
	                        		                         
	                        		                        	 
	                        		                        		 
	                        		                        		}
	                        		

}
