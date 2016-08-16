<!DOCTYPE HTML>
<html>
  <head>
    <meta charset = "utf-8">
  </head>
  <body>
  
  
  <table>
  <tr>
  <td>Spieler 1</td>
  <td>Spieler 2</td>
  </tr>
  
    <?php
    
    srand((double)microtime()*1000000);
    $player1 = 0;
    $player2 = 0;
    
    
    while($player1 < 25 && $player2 < 25){
      
      $randnum = rand(1, 6);
      $player1 += $randnum;
      $randnum = rand(1,6);
      $player2 += $randnum;
      
      echo "<tr><td> $player1 </td><td> $player2 </td></tr>";
    }
    ?>
    </table>
    <?php
      if($player1 == $player2){
        echo "<p>Unentschieden!</p>";
      }
      else if($player1 > $player2){
        echo "<p>Spieler 1 hat gewonnen!</p>";
      }
      else{
        echo "<p>Spieler 2 hat gewonnen!</p>";
      }
      
    ?>
  </body>
</html>