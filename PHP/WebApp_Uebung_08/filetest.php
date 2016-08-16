<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        $count_my_page = ("counter.txt");
        $hits = file($count_my_page);
        $hits[0] ++;
        $fp = fopen($count_my_page, "w");
        fputs($fp, "$hits[0]");
        fclose($fp);
        echo $hits[0];
        ?>
        <p>Hallo Welt!</p>
    </body>
</html>
