<!DOCTYPE HTML>
<HTML>
  <HEAD>
    <meta charset="utf-8">
  </HEAD>
  <BODY>
    <?php 
    $super = 1.40;
    $normal = 1.35;
    $sorte;
    $gesamtpreis;
    
    if($_POST["sorte"] == "N"){
      $gesamtpreis = $normal * $_POST["liter"];
      $sorte = "Normalbenzin";
    }else if($_POST["sorte"] == "S"){
      $gesamtpreis = $super * $_POST["liter"];
      $sorte = "Superbenzin";
    }else{
      echo "Irgendein Wert stimmt nicht!!";
    }
    
    if($_POST["liter"] >= 100){
      echo 'Großkunde! 2% Rabatt!!<BR>';
      $gesamtpreis = $gesamtpreis * 0.98;
    }
    
    echo $_POST["liter"] . " Liter " . $sorte . " kosten " . $gesamtpreis;
    
    ?>
  </BODY>
</HTML>