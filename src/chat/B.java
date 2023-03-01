package chat;
import lombok.Data;
@Data
public class B extends A {

    

    private Integer numero;

  

    public B(Integer numero) {

                super(numero);
    }



    public static void main(String[] args) {

                B b= new B(30);
                A a= new A(30);

                System.out.println(b.getNumero());
                System.out.println(a.getNumero());



    }



}