class Animal{
    constructor(raza,especie){
        this.raza=raza;
        this.especie=especie;
    }
}

class Perro extends Animal{
    constructor(sonido,raza,especie){
        super(raza,especie);
        this.sonido=sonido;
        
    }
}

class PerroPeludo extends Perro{
    constructor(sonido,raza,especie,tipoDePelo){
        super(sonido,raza,especie);
        this.tipoDePelo=tipoDePelo
    }

    verPerro(){
        console.log(`El perro de raza ${this.raza} y especie ${this.especie} emite el sonidop ${this.sonido} y tiene el pelo ${this.tipoDePelo}`)
    }
}

lassie= new Perro("guau, guau, guau","pastor aleman","canina");
console.log(`el animal de raza ${lassie.raza} y especie ${lassie.especie} emite el sonido ${lassie.sonido}`)
console.log("El animal de raza "+lassie.raza+" y especie "+lassie.especie+"emite el sonido "+lassie.sonido)

tobi=new PerroPeludo("guau, guau","caniche","canina","rizado");
tobi.verPerro()

