cargarpaises  =  ( continente )  =>  {
    buscar ( "https://restcountries.com/v3.1/region/"  +  continente )
        . luego ( ( respuesta )  =>  respuesta . json ( ) )
        . entonces ( paises  =>  {

            var  paisesSelect  =  documento . querySelector ( "#paises" ) ;
            paisesSeleccionar . HTML interno  =  ""
            let  selecionaPais  =  documento . createElement ( "opción" )
            selecciónPaís . valor  =  "0"
            selecciónPaís . text  =  "Selecciona pais" ;
            paisesSeleccionar . appendChild ( seleccionaPais ) ;
            paises _ paraCada ( pais  =>  {

                let  opción  =  documento . createElement ( "opción" ) ;
                opción _ valor  =  país . nombre _ común _
                opción _ texto  =  opción . valor
                paisesSeleccionar . appendChild ( opción )
                // consola.log(paises[i].nombre.común);

            } )

        } )
}
vaciarElemento  =  ( elemento )  =>  {
    elemento _ childNodes . paraCada ( hijo  =>  {
        elemento _ renovar _ renoveChild ( hijo ) ;
    } )
}


















































/*bandera https://goo.gl/maps/uDWEUaXNcZTng1fP6
escudo https://mainfacts.com/media/images/coats_of_arms/pe.svg
*/
https : //restcountries.com/v3.1/name/peru

cargarBanderas  =  ( )  =>  {
    let  selectpaises  =  documento . querySelector ( # país )
    dameDatos ( urlrespaises  +  / nombre /  +  seleccionarpaises.valor ) _ _
        . luego ( ( respuesta )  =>  respuesta . json ( ) )
        . entonces ( paises  =>  {
        } 
}
pintarBanderas  =  ( )  =>  {
    dameDatos ( urlrescountries  +  / alpha /  +  flags )
        . luego ( ( respuesta )  =>  respuesta . json ( ) )
        . entonces ( paises  =>  {
        }
        }

pintarescudos  =  ( )  =>  {
    dameDatos ( urlrescountries  +  / alpha /  +  pais . flag . coatOfArmsº )
        . luego ( ( respuesta )  =>  respuesta . json ( ) )
        . entonces ( paises  =>  {
        }
/ *
            consola _ registro  ( banderas )
            var  principal  =  documento . querySelector ( "principal" );
            principal _ HTML interno  = ""
            principal _ listaclases . añadir _ aplicar ( "centro de texto" )
            sea  ​​h21  =  documento . crearElemento ( "h2" ) ;
            let  th1  =  documento . crearElemento ( "th" ) ;
            principal _ appendChild ( principal )
            mesa _ appendChild ( tabla )
            tr1 _ agregarNiño ( tr )
            th1 . agregar niñ
            
            
            
            ( th1 )

 vaciarElemento  =  ( element
    
    
    
    )  =>  {
    elemento _ childNodes . p
    
    
    
    raCada ( hijo  =>  {
        elemento _ renovar _ 
        
        
        
        enoveChild ( hijo ) ;
   
    } )
 } 
}




























































