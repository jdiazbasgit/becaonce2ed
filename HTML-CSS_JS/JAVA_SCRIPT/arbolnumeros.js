/*function suma(...numeros){
    var resultado=0
    for(i=0;i<numeros.length;i++){
        resultado=resultado+numeros[i]
    }
    return resultado
}

console.log(suma(4,5,6,7))
console.log(suma(3,2))
console.log(suma(4,2))
console.log(suma(4,5,894564,544654,45646,5646546))
console.log("cambiamos comillas")
console.log(suma(3,2,"22"))*/


function ordenar(...numeros){
    var fin=false;
    while(!fin){
        fin=true;
        for(i=0;i<numeros.length-1;i++){
            if(numeros[i>numeros[i+1]]){
                temporal=numeros[i]
                numeros=numeros[i+1]
                numeros[i+1]=temporal
                fin=false
            }
        }
    }
    return numeros;
}

numeros=[8,1,5,7,66,84,10,11];
console.log("antes de ordenar");
console.log(numeros)
ordenar(numeros)
console.log("despues de ordenar")
console.log(numeros)


