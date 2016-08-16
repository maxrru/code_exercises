<!DOCTYPE HTML>
<HTML>
  <HEAD>
    <meta charset = "utf-8">
  </HEAD>
  <BODY>
  <?php
    if($_POST['uname'] != ""){
      if($_POST["uname"] == "Max" && $_POST["pw"] == "asdf"){
        echo "Zugriff gestattet";
      } else{
        echo "Zugriff verweigert";
      }
    }else{
      if($_POST["pw"] == "popocatepetl"){
        echo "Zugriff gestattet";
      } else{
        echo "Zugriff verweigert";
      }
    }
  
  ?>
  
  
  </BODY>
</HTML>