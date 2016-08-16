<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

session_set_cookie_params(10800, '/', 'localhost');
session_start();

$counterdatei = fopen("counter.txt", "r+") or die("Sessionvariable nicht gesetzt");
$counterstand = fgets($counterdatei, 10);

if ($counterstand == "") {
    $counterstand = 0;
}

if (!isset($_SESSION['counter_ip'])) {
    $counterstand++;
    rewind($counterdatei);
    fwrite($counterdatei, $counterstand);
    $_SESSION['counter_ip'] = true;
}

fclose($counterdatei);


echo $counterstand;

$time = $_SERVER['REQUEST_TIME'];
$browser = get_browser(null, true);


$statsdatei = fopen("stats.dat", "a+");

if (!isset($_SESSION['databfrage'])){
    $statsString =   "Date: " . date('Y-m-d H:i:s', $time) .
                     " Browser: " . $browser["browser"] .
                     " Version: " . $browser["version"] .
                     " OS: " . $browser["platform"].PHP_EOL;
    fwrite($statsdatei, $statsString);
    $_SESSION['databfrage'] = true;
}

fclose($statsdatei);





//
//echo "Datum: " . date('Y-m-d H:i:s', $time) . "\n\n";
//echo "Browser: " . $browser["browser"] . "\n";
//echo "Version: " . $browser["version"] . "\n";
//echo "OS: " . $browser["platform"] . "\n";
// 