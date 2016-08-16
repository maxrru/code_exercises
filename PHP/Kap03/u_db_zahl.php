<!DOCTYPE HTML>
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
      
      $sqlquery = "SELECT * FROM fp"
                 ." WHERE gb > 60 AND preis < 150"
                 ." ORDER BY gb DESC";
      
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
           . $dsatz["gb"] . ", "
           . $dsatz["preis"] . ", "
           . $dsatz["artnummer"] . ", "
           . $dsatz["prod"] . "<br>";
      }
      
      
      mysqli_close($sqlconnect);
      
    ?>
  </body>
</html>