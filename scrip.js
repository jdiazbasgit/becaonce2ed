
function nombre() {  
        texto="eduardoRodriguez"     
        for (i = 0; i<=texto.lenght;i ++){
            if(i % 2 ==0){

            document.querySelector("#h1").innerHTML=  document.querySelector("#h1").innerHTML + texto.substring(i, i+1).toUpperCase(); 
        }else{
            document.querySelector("#h1").innerHTML=  document.querySelector("#h1").innerHTML + texto.substring(i, i+1).toUpperCase();
        }

            } 
}