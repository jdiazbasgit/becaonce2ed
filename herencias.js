clase  Animal {
    constructor ( raza , especie ) {
        esto _ raza = raza ;
        esto _ especie = especie ;
    }
}

clase  Perro  extiende  Animal {
    constructor ( sonido , raza , especie ) {
        súper ( raza , especie ) ;
        esto _ sonido = sonido ;
        
    }
}

class  PerroPeludo  extiende  Perro {
    constructor ( sonido , raza , especie , tipoDePelo ) {
        super ( sonido , raza , especie ) ;
        esto _ tipoDePelo = tipoDePelo
    }

    VerPerro ( ) {
        consola _ log ( `El perro de raza ${ this . raza } y especie ${ this . especie } emite el sonidop ${ this . sonido } y tiene el pelo ${ this . tipoDePelo } ` )
    }
}

lassie =  nuevo  Perro ( "guau, guau, guau" , "pastor aleman" , "canina" ) ;
consola _ log ( `el animal de raza ${ lassie . raza } y especie ${ lassie . especie } emite el sonido ${ lassie . sonido } ` )
consola _ log ( "El animal de raza " + lassie . raza + " y especie " + lassie . especie + "emite el sonido " + lassie . sonido )

tobi = nuevo  PerroPeludo ( "guau, guau" , "caniche" , "canina" , "rizado" ) ;
tobi _ verperro ( )