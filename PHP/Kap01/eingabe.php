<!DOCTYPE HTML>
<HTML>
  <HEAD>
    <meta charset="utf-8">
  </HEAD>
  <BODY>
    
    <p>Ihre Adresse lautet:</p>
    <P>
    <?php
    //echo "wassup " . $_POST["vorname"] . " " . $_POST["nachname"];
      echo $_POST["vorname"] . " " . $_POST["nachname"] . "<BR>";
      echo $_POST["strasse"] . "<BR>";
      echo $_POST["plz"] . " " . $_POST["ort"];
    ?>
    </P>
  </BODY>
</HTML>