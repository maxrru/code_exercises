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
        
        //Aufgabe 8.1.1
        //Ausgabe Hello World!
        echo "Aufgabe 8.1.1<br>";
        echo "hello world!<br>";
        
        
        //Aufgabe 8.1.2
        //Nummern tauschen
        echo "Aufgabe 8.1.2<br>";
        
        $numberOne = 10;
        $numberTwo = 20;
       
        echo "Number 1:" . $numberOne . "<br>Number 2:" . $numberTwo . "<br>";
        
        $tmp = $numberOne;
        $numberOne = $numberTwo;
        $numberTwo = $tmp;
        
        echo "Number 1:" . $numberOne . "<br>Number 2:" . $numberTwo . "<br>";
        
        
        //Aufgabe 8.1.3
        //While- und Forschleife
        $loopLimit = 10;
        
        
        echo "Aufgabe 8.1.3<br>Forschleife:<br>";
        for($i = 1; $i <= $loopLimit; $i++){
            
            if($i < $loopLimit){
                echo "$i, ";
            }
            else{
                echo "$i<br>";
            }
            
            
            
        }
        echo "Whileschleife:<br>";
        $whileIndex = 1;
        while($whileIndex <= $loopLimit){
            if($whileIndex < $loopLimit){
                echo "$whileIndex, ";
            }
            else{
                echo "$whileIndex<br>";
            }
            $whileIndex++;
        }
        
        
        //Aufgabe 8.1.4
        //Funktion Konkatenation
        
        function conCat($str1, $str2)
        {
            return $str1 . $str2;
        }
        
        
        echo "Aufgabe 8.1.4<br>Konkatenation<br>";
        echo conCat("Hello ", "World!");
        
        
        
        
        
        
        
        
        
        
        ?>
    </body>
</html>
