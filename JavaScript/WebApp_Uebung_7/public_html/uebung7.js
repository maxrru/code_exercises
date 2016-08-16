/* 
 * Author:         Maximilian Ungar
 * 
 * Creation Date:  11.07.2015 17:26:53
 * File:           uebung7.js
 */



/*Aufgabe 7.1.1 Erstellung des Student-Objekts */

function Student(matrikelnummer, nachname, vorname, semester, geburtsdatum) {
    this.matrikelnummer = matrikelnummer;
    this.nachname = nachname;
    this.vorname = vorname;
    this.semester = semester;
    this.geburtsdatum = geburtsdatum;
}

var informatikstudent = new Student(634893, "Ungar", "Radu", 6, "1992-09-02");


console.log(informatikstudent.matrikelnummer);

function student2() {
    this.matrikelnummer = 1234;
    this.nachname = "Degenhardt";
    this.vorname = "Christian";
    this.semester = 6;
    this.geburtsdatum = "1989-04-23";
}

var informatikstudent2 = new student2();

console.log(informatikstudent2.nachname);
informatikstudent2.nachname = "Friedrich";
console.log(informatikstudent2.nachname);



/*Aufgabe 7.1.2 Erstellung der Arrayklasse*/


function customArray(array) {
    this.array = array;
}

    customArray.prototype.print = function ()
    {
        document.getElementById("uebung").innerHTML += "<br>Das Array " +
                "beinhaltet folgende Index|Wert-Paare: ";

        for (var index = 0; index < this.array.length; index++) {
            document.getElementById("uebung").innerHTML += "(" + index +
                    "|" + this.array[index] + "), ";
        }
    };

    customArray.prototype.sort = function ()
    {
        var i, j, tmp, tmp2;
        for (i = 0; i < this.array.length - 1; i++)
        {
            tmp = i;
            for (j = i + 1; j < this.array.length; j++) {
                if (this.array[j] < this.array[tmp]) {
                    tmp = j;
                }
            }
            if (tmp !== i) {
                tmp2 = this.array[tmp];
                this.array[tmp] = this.array[i];
                this.array[i] = tmp2;
            }
        }
        
    };




    var myArray = new Array();
    for (var myArrayIndex = 0; myArrayIndex < 200; myArrayIndex++) {
        myArray[myArrayIndex] = Math.floor(Math.random() * myArrayIndex) + 1;
}

var randomArray = new customArray(myArray);


/*Aufgabe 7.1.3 Müssen/sollten alle Methoden einer JavaScript-Klasse in der 
 *              Klasse selbst definiert werden? Nennen Sie ein Beispiel bzw. 
 *              Gegenbeispiel!*/

console.log("Die Methoden einer JavaScript-Klasse muessen nicht in der Klasse\n\
            selbst definiert werden. Ein Gegenbeispiel gibt es auf\n\
            http://www.w3schools.com/js/js_object_prototypes.asp . Dort wird\n\
            einer bestehenden Klasse eine neue Methode zugewiesen.");





