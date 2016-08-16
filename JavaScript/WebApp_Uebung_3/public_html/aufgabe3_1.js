/* 
 *  Author: Max Ungar
 * Date: 2015-05-08
 * Version: 1.0
 */


/*Aufgabe 1.2*/
document.write("<br><br>Aufgabe 1.2<br>");
document.write("Hello World ");


/*Aufgabe 1.3*/

document.write("<br><br>Aufgabe 1.3<br>");
var one = 15;
var two = 20;

document.write("<br> One:" + one + "<br> Two:" + two);

var tmp = one;
one = two;
two = tmp;

document.write("<br> One:" + one + "<br> Two:" + two);


/*Aufgabe 1.4 - Forschleife, Whileschleife, Do-Whileschleife*/
/*Aufgabe 1.5 - Even/odd in jeder Schleife ausgeben*/
document.write("<br><br>Aufgabe 1.4 und 1.5<br>");
/*For*/
document.write("<br>Ausgabe der For-Schleife: ");
for(var forit=1; forit<11; forit++)
{
    document.write(forit + " ");
    if(forit%2 === 0){
        document.write("(even), ");
    }
    else
    {
        document.write("(odd), ");
    }
}


/*While-Do*/
document.write("<br>Ausgabe der While-Schleife: ");
var wit = 1;
while(wit <= 10)
{
    document.write(wit + " ");
    if(wit%2 === 0){
        document.write("(even), ");
    }
    else
    {
        document.write("(odd), ");
    }
    
    wit++;
}


/*Do-While*/
document.write("<br>Ausgabe der Do-While-Schleife: ");

var dwit = 1;
do{
    document.write(dwit + " ");
    if(dwit%2 === 0){
        document.write("(even), ");
    }
    else
    {
        document.write("(odd), ");
    }
    dwit++;
}while(dwit <= 10);


/*Aufgabe 1.6
 * Switch-Case Übung: Datumsausgabe*/
document.write("<br><br>Aufgabe 1.6<br>");
var day;
switch (new Date().getDay())
{
    case 0:
        day = "Sonntag";
        break;
    
    case 1:
        day = "Montag";
        break;
    
    case 2:
        day = "Dienstag";
        break;
        
    case 3:
        day = "Mittwoch";
        break;
    
    case 4:
        day = "Donnerstag";
        break;
    
    case 5: 
        day = "Freitag";
        break;
        
    case 6:
        day = "Samstag";
        break;
    
    default:
        document.write("Dies ist kein Tag!");
        break;
}

document.write("<br>Heute ist " + day + "!");


/*Aufgabe 1.7 prompt-, alert-, confirmboxen*/

document.write("<br><br>Aufgabe 1.7 (Boxen)<br>");
var person = prompt("Geben Sie bitte ihren Namen ein...");

alert("Ihr Name ist also \n\"" + person + "\"");

confirm(person + " ist ein schöner Name!");