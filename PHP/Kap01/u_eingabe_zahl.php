<!DOCTYPE HTML>
<HTML>
  <HEAD>
    <meta charset="utf-8">
  </HEAD>
  <BODY>
    <?php 
    $basis = doubleval($_POST["basis"]);
    echo $basis . " zum Quadrat ist " . ($basis * $basis);
    ?>
  </BODY>
</HTML>