
function calculadora() {


    var body = document.getElementsByTagName("body")[0];


    var tabla = document.createElement("table");
    var tblBody = document.createElement("tbody");

    switch (i)





    // Crea las celdas
    for (var i = 0; i < 3; i++) {

        var hilera = document.createElement("tr"); 

        for (var j = 0; j < 3; j++) {

            tabla class= "table-bordered w-100"
            tbody class= "w-100"
            <th class= "text">Encabezado de la tabla</th>
            <tr class= "text">
                <td class= "w-50; 1">1</td>
            </tr>
 <tr class= "text">
 <td class= "w-50; 1">2</td>
</tr>
            
            




            var celda = document.createElement("td");
            var textoCelda = document.createTextNode("celda " + i + ", columna " + j);
            celda.appendChild(textoCelda);
            hilera.appendChild(celda);

        }

        tblBody.appendChild(hilera);
    }



    tabla.appendChild(tblBody);

    body.appendChild(tabla);

    tabla.setAttribute("border", "2");
}

console.log(calculadora)
