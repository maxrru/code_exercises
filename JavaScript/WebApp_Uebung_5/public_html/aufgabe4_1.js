/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function randomArray(botLimit, topLimit, number)
{
    var randomNumbers = new Array();
    for(var x=0; x< number; x++)
    {
        randomNumbers[x] = Math.floor( (Math.random()*((topLimit-botLimit)+1))+botLimit);
    }
    
    return randomNumbers;
}


function alleAusgeben(numbersArray)
{
    document.write("<pre>");
    for(var x = 0; x < numbersArray.length; x++)
    {
        if(x%10 === 0 && x !== 0)
        {
            document.write("    ");
        }
        document.write(numbersArray[x] + " ");
    }
    document.write("</pre>");
}



function summe(numbersArray)
{
    var sum = 0;
    for(var x = 0; x < numbersArray.length; x++)
    {
        sum += numbersArray[x];
    }
    document.write("<br>Summe:" + sum);
    return sum;
}

function ersetzeZahl(index, wert, numbersArray)
{
    if(index>numbersArray.length || index < 0)
    {
        console.log("Index außerhalb des Bereichs");
    }
    else
    {
        numbersArray[index] = wert;
    }
}

function groessteZahl(numbersArray)
{
    highestNumber = Math.max.apply(Math,numbersArray);
    document.write("<br>Groeßte Zahl:" + highestNumber);
}

function datum()
{
    var days = ["Sonntag","Montag","Dienstag","Mittwoch","Donnerstag","Freitag","Samstag"];
    document.write("<br>"+days[new Date().getDay()]);
}

function multiArray()
{
    var items = [[1,2],[3,4],[5,6]];
    document.write("<br>"+items[0][0]); // 1
    return items;
}



var array = new Array();
array = randomArray(1, 100, 5);
// ersetzeZahl(4, 6000, array);
alleAusgeben(array);
groessteZahl(array);
summe(array);
datum();
multiArray();
