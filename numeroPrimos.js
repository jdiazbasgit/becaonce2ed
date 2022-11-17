function primo(numero) {
  for (var i = 2; i < numero; i++) {
    if (numero % i === 0) {
      return false;
    }
  }

  return true;
}


function crearFilaPrimo() {
  var numerosPrimos = [];
  //var cadena = 100;

  for (j = 0; j < 100; j++) {
    var tr = document.createElement("tr");
    var td = document.createElement("td");
    var td1 = document.createElement("td");

    if (primo(j)) {
      numerosPrimos.push(j);
      td.innerHTML = j;
      td1.innerHTML = "Es primo";

    } else {
      td.innerHTML = j;
      td1.innerHTML = "No es primo";
      //color en las celdas
      td.setAttribute("style","background-color:#EC2013; color:white");
      td1.setAttribute("style","background-color:#13C2EC; color:white");
    }

    tr.appendChild(td);
    tr.appendChild(td1);

    tabla1.appendChild(tr);

  }
}






