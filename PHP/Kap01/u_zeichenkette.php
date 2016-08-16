<!DOCTYPE HTML>
<HTML>
  <HEAD>
    <meta charset="utf-8">
  </HEAD>
  <BODY>
    <?php 
    
    $artikel01 = 10;
    $artikel02 = 18;
    $artikel03 = 13;
    
    $mwst = 19;
    $netto = $artikel01 + $artikel02 + $artikel03;
    $brutto = $netto * $mwst / 100 + $netto;
    
    
    
    echo "Artikel 1: " . $artikel01 . "<BR>";
    echo "Artikel 2: " . $artikel02 . "<BR>";
    echo "Artikel 3: " . $artikel03 . "<BR><BR>";
    
    echo "Nettosumme: " . $netto . "<BR>";
    echo "Umsatzsteuer: " . $mwst . " %<BR>";
    echo "Bruttosumme: " . $brutto . "<BR>";
    
    ?>
  </BODY>
</HTML>