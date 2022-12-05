class animal{
    constructor(raza,especie){
        this.raza=raza;
        this.especie=especie;
    }
}

class perro extends animal{
    constructor(sonido,raza,especie){
        this.sonido=sonido;
        super(raza,especie); 
    }
}

class Peludo extends perro{
    constructor(sonido,raza,especie,pelo){
        this.pelo=pelo;
        super(sonido,raza,especie);
    }

    verPerro(){console.log(`el animal de raza ${this.raza} y especie ${this.especie}, emite sonido ${this.sonido} . Tiene el pelo ${this.pelo}` )

    }
}

lassie= new perro("guau", "pastor aleman", "canina")
console.log(`el animal de raza ${lassie.raza} y especie ${lassie.especie}, emite sonido ${lassie.sonido}`)
console.log("el animal de raza " +lassie.raza+" y especie " +lassie.especie+ ", emite sonido " +lassie.sonido)