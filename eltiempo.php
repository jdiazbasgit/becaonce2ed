<?php
header('Content-Type: text/html; charset=utf-8');

try{
    
$doc = new DOMDocument();
$doc->load('http://www.aemet.es/xml/municipios/localidad_28079.xml');
  
  
$origen = $doc->getElementsByTagName("origen");
  
    foreach($origen as $orig){
        if(!is_null($orig->nodeValue)) {
            /*$product = $orig->getElementsByTagName("productor");
            $productor = $product->item(0)->nodeValue;
            
            $dominio = $orig->getElementsByTagName("web");
            $web = $dominio->item(0)->nodeValue;
            
            $vinculo= $orig->getElementsByTagName("enlace");
            $enlace = $vinculo->item(0)->nodeValue;
            
            $leng= $orig->getElementsByTagName("language");
            $lenguage = $leng->item(0)->nodeValue;
            
            $copyr= $orig->getElementsByTagName("copyright");
            $copyright = $copyr->item(0)->nodeValue;
            
            $notleg= $orig->getElementsByTagName("nota_legal");
            $notalegal = $notleg->item(0)->nodeValue;
            
            
            echo "$productor"."<br/>";
            echo "$web"."<br/>";
            echo "$enlace"."<br/>";
            echo "$lenguage"."<br/>";
            echo "$copyright"."<br/>";
            echo "$notalegal"."<br/>";
            
            $eleborado = $doc->getElementsByTagName('elaborado')->item(0)->nodeValue;
    
            echo "$eleborado"."<br/>";*/            
            $provincia = $doc->getElementsByTagName('provincia')->item(0)->nodeValue;
            $nombre = $doc->getElementsByTagName('nombre')->item(0)->nodeValue;
            
        }
    }
    
    echo "$nombre"." "."($provincia)"."<br/>";
   
    
        
    $dias = array('Lunes','Martes','Miercoles','Jueves','Viernes','Sábado','Domingo');
    $meses = array('Enero', 'Febrero','Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre');


    $prediccion = $doc->getElementsByTagName("prediccion");

    foreach($prediccion as $pred){
        $fecha = $pred->getElementsByTagName("dia")->item(0)->getAttribute("fecha");
        $dia = substr($fecha,8,2);
        $mes = substr($fecha,5,2);
        $anyo = substr($fecha,0,4);
        
        $diadelasemana= $dias[calcula_numero_dia_semana($dia,$mes,$anyo)];
        $mes = $meses[calcula_numero_mes($dia,$mes,$anyo)];
        
        $hora = date("G");
        $minuto = date("i");
        $segundo = date("s");
        $horaactual = $hora.":".$minuto.":".$segundo;
        


        //for ($i=0;$i<=1;$i++) {
            //HOY
            if(($hora >= "0") && ($hora <= "12")){
                $probprec = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("prob_precipitacion")->item(0)->getAttribute("periodo");
                $probpreci = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("prob_precipitacion")->item(0)->nodeValue;
                $descripcion = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("estado_cielo")->item(0)->getAttribute("descripcion");
                $direccion = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("direccion")->item(0)->nodeValue;
                $velocidad = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("velocidad")->item(0)->nodeValue;
                $rachamax = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("racha_max")->item(0)->nodeValue;
            } elseif(($hora >= "12") && ($hora <= "24")){
                $probprec = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("prob_precipitacion")->item(1)->getAttribute("periodo");
                $probpreci = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("prob_precipitacion")->item(1)->nodeValue;
                $descripcion = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("estado_cielo")->item(1)->getAttribute("descripcion");
                $direccion = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("direccion")->item(1)->nodeValue;
                $velocidad = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("velocidad")->item(1)->nodeValue;
                $rachamax = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("racha_max")->item(1)->nodeValue;
            }
            
                $temperaturamax = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("temperatura")->item(0)->getElementsByTagName("maxima")->item(0)->nodeValue;
                $temperaturamin = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("temperatura")->item(0)->getElementsByTagName("minima")->item(0)->nodeValue;
                $humedadrelativamax = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("humedad_relativa")->item(0)->getElementsByTagName("maxima")->item(0)->nodeValue;
                $humedadrelativamin = $pred->getElementsByTagName("dia")->item(0)->getElementsByTagName("humedad_relativa")->item(0)->getElementsByTagName("minima")->item(0)->nodeValue;
            
            
            echo "$fecha".'<br/>'."$diadelasemana".', '."$dia".' del '."$mes".' de '. "$anyo".'<br/>';
            echo "$probprec"." => ".' probabilidad de precipitacion '."$probpreci".'%, Estado del cielo: '."$descripcion".'<br/>'.' Viento: '."$direccion".', velocidad: '."$velocidad".'km/h'.', racha m&aacute;x: '."$rachamax".'km/h'.', temperatura m&aacute;x: '."$temperaturamax".'&ordm;'.', temperatura min: '."$temperaturamin".'&ordm;'.', humedad relativa m&aacute;x: '."$humedadrelativamax".'%'.', humedad relativa min: '."$humedadrelativamin".'%.'.'<br/>';
            
        //MAÑANA
        $fecha = $pred->getElementsByTagName("dia")->item(1)->getAttribute("fecha");
        $dia = substr($fecha,8,2);
        $mes = substr($fecha,5,2);
        $anyo = substr($fecha,0,4);     

        $diadelasemana= $dias[calcula_numero_dia_semana($dia,$mes,$anyo)];
        $mes = $meses[calcula_numero_mes($dia,$mes,$anyo)];

        $hora = date("G");
        $minuto = date("i");
        $segundo = date("s");
        $horaactual = $hora.":".$minuto.":".$segundo;

        //for ($i=0;$i<=1;$i++) {
            if(($horaM >= "0") && ($horaM <= "12")){
                $probprec = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("prob_precipitacion")->item(0)->getAttribute("periodo");
                $probpreci = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("prob_precipitacion")->item(0)->nodeValue;
                $descripcion = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("estado_cielo")->item(0)->getAttribute("descripcion");
                $direccion = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("direccion")->item(0)->nodeValue;
                $velocidad = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("velocidad")->item(0)->nodeValue;
                $rachamax = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("racha_max")->item(0)->nodeValue;
            } elseif(($horaM >= "12") && ($horaM <= "24")){
                $probprec = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("prob_precipitacion")->item(1)->getAttribute("periodo");
                $probpreci = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("prob_precipitacion")->item(1)->nodeValue;
                $descripcion = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("estado_cielo")->item(1)->getAttribute("descripcion");
                $direccion = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("direccion")->item(1)->nodeValue;
                $velocidad = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("velocidad")->item(1)->nodeValue;
                $rachamax = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("racha_max")->item(1)->nodeValue;
            }
            
                $temperaturamax = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("temperatura")->item(0)->getElementsByTagName("maxima")->item(0)->nodeValue;
                $temperaturamin = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("temperatura")->item(0)->getElementsByTagName("minima")->item(0)->nodeValue;
                $humedadrelativamax = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("humedad_relativa")->item(0)->getElementsByTagName("maxima")->item(0)->nodeValue;
                $humedadrelativamin = $pred->getElementsByTagName("dia")->item(1)->getElementsByTagName("humedad_relativa")->item(0)->getElementsByTagName("minima")->item(0)->nodeValue;
            
            
            echo "$fecha".'<br/>'."$diadelasemana".', '."$dia".' del '."$mes".' de '. "$anyo".'<br/>';
            echo "$probprec"." => ".' probabilidad de precipitacion '."$probpreci".'%, Estado del cielo: '."$descripcion".'<br/>'.' Viento: '."$direccion".', velocidad: '."$velocidad".'km/h'.', racha m&aacute;x: '."$rachamax".'km/h'.', temperatura m&aacute;x: '."$temperaturamax".'&ordm;'.', temperatura min: '."$temperaturamin".'&ordm;'.', humedad relativa m&aacute;x: '."$humedadrelativamax".'%'.', humedad relativa min: '."$humedadrelativamin".'%.'.'<br/>';
            

        //}
    }
    
    
    
} catch (Exception $e){
    echo $e;
}

function calcula_numero_dia_semana($dia,$mes,$ano){ 
    $numerodiasemana = date('w', mktime(0,0,0,$mes,$dia,$ano)); 
    if ($numerodiasemana == 0) 
       $numerodiasemana = 6; 
    else 
       $numerodiasemana--; 
    return $numerodiasemana; 
}
 
function calcula_numero_mes($dia,$mes,$ano){ 
    $numeromes = date('n', mktime(0,0,0,$mes,$dia,$ano))-1; 
    return $numeromes; 
}
    
?>
