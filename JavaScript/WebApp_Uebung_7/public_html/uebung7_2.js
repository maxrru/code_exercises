/* 
 * Author:         Maximilian Ungar
 * 
 * Creation Date:  12.07.2015 23:33:19
 * File:           uebung7_2.js
 */



/*Aufgabe 7.2 Vererbung und Zähler*/

function Person(name)
{
    this.name = name;
    Person.counter = (Person.counter || 0) + 1;
    console.log("Gesamte Anzahl Instanzen: " + Person.counter);
}


Person.prototype.essen = function() {
        console.log("Person " + this.name + " nimmt etwas zu sich.");
    };
    


function Student(name, matrikelnummer)
{
    Person.call(this, name);
    this.matrikelnummer = matrikelnummer;
    console.log("Student erzeugt.");
}

Student.prototype = new Person();
Student.prototype.constructor = Student;


 Student.prototype.lernen = function(){
        console.log("Student " + this.name + " lernt fleißig und schnell.");
 };
function Professor(name, persNr)
{
    Person.call(this, name);
    this.persNr = persNr;
    console.log("Professor erzeugt.");
}

Professor.prototype = new Person(); //Professor als Instanz von Person
Professor.prototype.constructor = Professor; //Konstruktor von Professor zurücksetzen


  Professor.prototype.lehren = function(){
        console.log("Der Professor " + this.name + " führt eine Vorlesung.");
    };


var Student01 = new Student("Frank Schaetzing", 111222);
var Student02 = new Student("Dieter Peter", 333444);
var Student03 = new Student("Daine Muda", 555666);
var prof01 = new Professor("Dr. Zoidberg", 1234);

prof01.lehren();
Student01.lernen();
Student02.lernen();
prof01.essen();
