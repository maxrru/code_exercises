<!DOCTYPE HTML>
<html>
  <head>
    <meta charset = "utf-8">
  </head>
  <body>
    <table style="border: 2px solid black">
    <?php 
      $name = ["Peter", "Markus", "Jens", "Julia", "Monika", "Gerd"];
      $alter = [35, 42, 16, 17, 42, 55];
      
      for($i = 0; $i < 6; $i++){
        echo "<tr><td style='border: 2px solid black'>$name[$i]</td><td style='border: 2px solid black'>$alter[$i]</td></tr>";
      }
    
    ?>
    </table>
  </body>
</html>