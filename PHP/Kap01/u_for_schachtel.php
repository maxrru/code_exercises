<!DOCTYPE HTML>
<html>
  <head>
    <meta charset = "utf-8">
  </head>
  <body>
  
  <table style="border: 2px solid black">
    <?php 
      for($i = 1; $i <= 10; $i++){
        echo '<tr>';
        for($j = 1; $j <= 10; $j++){
          echo '<td style="border: 2px solid black">' . $i*$j . "</td>";
          /* if($j == 10){
            echo "<br>";
          } */
        }
        echo "</tr>";
      }
    
    
    
    ?>
  </table>
  </body>
</html>