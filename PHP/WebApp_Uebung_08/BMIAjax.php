<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$weight = $_GET["weight"];
$height = $_GET["height"];
$bmi = $weight / ($height * $height);
echo $bmi;
