<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


echo "Geschlecht: " . $_GET["radGender"] . "<br>";
echo "Groesse: " . $_GET["groesse"] . "<br>";
echo "Gewicht: " . $_GET["gewicht"] . "<br>";


$gewicht = $_GET["gewicht"];
$groesse = $_GET["groesse"];
$geschlecht = $_GET["radGender"];

$bmi = $gewicht / ($groesse * $groesse);

echo "Ihr BMI betraegt " . $bmi . "<br>";

if($geschlecht === "m"){
    if($bmi < 20){
        echo "Damit sind Sie zu dünn";
    }elseif($bmi < 25){
        echo "Damit haben Sie Idealgewicht";
    }else{
        echo "Damit sind Sie zu dick!";
    }
    
    
}
elseif($geschlecht === "w"){
    if($bmi < 19){
        echo "Damit sind Sie zu dünn";
    }elseif($bmi < 24){
        echo "Damit haben Sie Idealgewicht";
    }else{
        echo "Damit sind Sie zu dick!";
    }
}

