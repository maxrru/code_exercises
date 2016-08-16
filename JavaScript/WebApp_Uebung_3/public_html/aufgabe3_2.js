/* 
 * Author: Max Ungar
 * Date: 2015-05-08
 * Version: 1.0
 *
 *
 *http://www.inventpartners.com/javascript_is_int
 */


/*Aufgabe 2.1*/


document.write("Aufgabe 2.1<br>");
function halloFulda() {
    document.write("Hallo Fulda!");
}

halloFulda();



/*Aufgabe 2.2*/
document.write("<br><br>Aufgabe 2.2<br>");
function strCat(str1, str2)
{
    var str3 = str1 + str2;
//    document.write(str1 + str2);
    document.write(str3);
    return str3;
}


strCat("Hallo ", "du da!");

/*Aufgabe 2.3*/
document.write("<br><br>Aufgabe 2.3<br>");

function recurMultiply(factorOne, factorTwo)
{
    if (factorOne === 1){
        return factorTwo;

    }
    else{
        return factorTwo + recurMultiply(factorOne - 1, factorTwo);
    }


}



var fac1 = parseInt(prompt("Geben Sie die erste Zahl ein:"));
var fac2 = parseInt(prompt("Geben sie die zweite Zahl ein:"));



document.write("<br><br>Das Ergebnis der _rekursiven_ Multiplikation mit " + fac1 + " und " + fac2 + " lautet: ");
document.write(recurMultiply(fac1, fac2));



function iterMultiply(factorOne, factorTwo)
{
    var product = 0;
    while (factorOne > 0){
        product += factorTwo;
        factorOne--;
    }

    return product;
}

document.write("<br><br>Das Ergebnis der _iterativen_ Multiplikation mit " + fac1 + " und " + fac2 + " lautet: ");
document.write(iterMultiply(fac1, fac2));




function factorialCalc(faculty)
{
    if (faculty !== 0){
        if ((parseFloat(faculty) === parseInt(faculty)) && !isNaN(faculty)){
            var total = 1;
            while (faculty > 0){
                total = total * faculty;
                faculty--;

            }
            return total;
        } 
        else{
            console.log("Fehler! Eingabe keine natuerliche Zahl!");
        }

    }
    else{
        return 1;
    }
}

document.write("<br><br>Die Fakultät von " + fac1 + " ist: " + factorialCalc(fac1));

document.write("<br><br>Aufgabe 2.5<br><br>");



function baum(treeHeight)
{
    var digits = 1;
    var treeWidth = treeHeight;  
    
    for(var counter = 0; counter < treeHeight; counter++)
    {
        for(var innerCount = 0; innerCount < treeWidth; innerCount++)
        {
            document.write("_");
        }
         
        for(var digitCount = 0; digitCount < digits; digitCount++){
            document.write("+");
        }
        
        document.write("<br>");
        digits += 2;
        treeWidth--;
        
    }
   
}



baum(15);


function foo() {
  for (var i = 0; i < arguments.length; i++) {
    alert(arguments[i]);
  }
}


