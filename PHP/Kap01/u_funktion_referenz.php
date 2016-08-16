<!DOCTYPE HTML>
<html>
  <head>
    <meta charset = "utf-8">
  </head>
  <body>
    <?php 
      function rechne(&$a, &$b, &$sum, &$prod){
        $sum = $a + $b;
        $prod = $a * $b;
      }
      
      $a1 = 42;
      $b1 = 21;
      $sum1;
      $prod1;
      
      rechne($a1, $b1, $sum1, $prod1);
      
      echo $sum1 . " / " . $prod1;
        
      
      
      
    
    ?>
  </body>
</html>