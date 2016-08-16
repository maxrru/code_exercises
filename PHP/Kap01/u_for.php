<!DOCTYPE HTML>
<HTML>
  <HEAD>
    <meta charset = "utf-8">
  </HEAD>
  <BODY>
    <?php 
      
      $it = 1;
      
      for($i = 1; $i <= 6; $i++){
        if($i % 2 == 1){
          echo "a ";
        }else{
          echo "b" . $it . " ";
          $it++;
        }
      }
      echo "<BR>";
      
      
      $sec_char = "";
      $third_char = 2;
      
      for($i = 0; $i < 6; $i++){
      
      if($i % 2 == 0){
        $third_char = 2;
      }else{
        $third_char = 3;
      }
      
      if($i >= 2 && $i <4){
        $sec_char = 1;
      }
      if($i >= 4){
        $sec_char = 2;
      }
      
      echo "c" . $sec_char . $third_char . " ";  
      }
      
      
    
    ?>
  </BODY>
</HTML>