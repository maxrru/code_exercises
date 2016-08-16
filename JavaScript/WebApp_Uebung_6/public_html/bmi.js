/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function calculateBMI()
{
    var weight = document.getElementById("gewicht").value;
    var height = document.getElementById("groesse").value;
    var bmi = weight / (height * height);
    document.getElementById("bmitxt").innerHTML = bmi.toFixed(2);
}



function testNameAnmerk()
{
    var name = document.getElementById("uname").value;
    var anmerk = document.getElementById("anmerk").value;

    var nameTest = /^[a-zA-Z]+\s+[a-zA-Z]+$/.test(name);
    var anmerkTest = /<[A-Za-z=""\s]+>/g.test(anmerk);

    console.log("nameTest " + nameTest);
    console.log("anmerkTest " + anmerkTest);

    if (nameTest === true) {
        if (anmerkTest === false) {
            console.log("Alles Ok");
            return true;
        }
        else {
            alert("Formularübermittlung fehlgeschlagen! Feld 'Anmerkungen' enthält illegale Zeichen!");
            return false;
        }
    }
    else {
        alert("Formularübermittlung fehlgeschlagen! Der Name entspricht nicht dem Format!");
        return false;
    }




}

/**
 * Hier steht der Javascript-Teil zu Aufgabe 8: Berechnung BMI mit PHP
 */


function phpbmi() {
    var weight = document.getElementById("gewicht").value;
    var height = document.getElementById("groesse").value;

    var xmlhttp = new XMLHttpRequest({mozSystem: true});
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            var phpbmi = xmlhttp.responseText;
            var total = Math.round(phpbmi * 100)/100;
            
            document.getElementById("bmitxt").innerHTML = total;
        }

    };

    xmlhttp.open("GET", "http://localhost/WebApp_Uebung_08/BMIAjax.php" +
            "?weight=" + weight +
            "&height=" + height);
    xmlhttp.send();

}