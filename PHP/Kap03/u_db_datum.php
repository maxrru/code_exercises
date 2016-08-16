﻿<!DOCTYPE HTML>
<html>
  <head>
    <meta charset = "utf-8">
  </head>
  <body>
    <?php 
      /*Verbindung aufbauen*/
      $sqlconnect = mysqli_connect("", "root");
      
      /*Datenbank auswählen*/
      mysqli_select_db($sqlconnect, "hardware");
      
      $sqlquery = "SELECT hersteller, typ, prod, artnummer FROM fp"
                 ." WHERE prod >= '2008-01-01' AND prod < '2008-07-01'"
                 ." ORDER BY prod";
      
      $result = mysqli_query($sqlconnect, $sqlquery);
      $num = mysqli_num_rows($result);
      
      if($num > 0){
        echo "Ergebnis: <br>";
      }else{
        echo "Keine Ergebnisse!<br>";
      }
      
      while($dsatz = mysqli_fetch_assoc($result)){
        echo $dsatz["hersteller"] . ", "
           . $dsatz["typ"] . ", "
           . $dsatz["prod"] . ", "
           . $dsatz["artnummer"] . "<br>";
      }
      
      
      mysqli_close($sqlconnect);
      
    ?>
  </body>
</html>