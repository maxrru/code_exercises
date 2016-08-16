<!DOCTYPE HTML>
<HTML>
  <HEAD>
    <meta charset="utf-8">
  </HEAD>
  <BODY>
    <?php 
    
    $artikel01 = 10.99;
    $artikel02 = 155.95;
    $artikel03 = 13.37;
    
    $mwst = 1.19;
    
    $total = ($artikel01 + $artikel02 + $artikel03) * $mwst;
    
    echo $total;
    
    ?>
  </BODY>
</HTML>