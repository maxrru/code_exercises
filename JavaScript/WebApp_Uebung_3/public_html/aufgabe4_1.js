/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var xzibit = randomArray(10, 70, 45);
var thisDay = ["Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"];
//var tagNr = new Date().getDay();


function randomArray(botLimit, topLimit, number)
{
    var randomNumbers = new Array();
    for(x=0; x< number; x++){
    randomNumbers[x] = Math.floor( (Math.random()*((topLimit-botLimit)+1))+botLimit);
//    document.write(randomNumbers[x]);
    }
    
    return randomNumbers;
}

function alleAusgeben(numbersArray)
{
    document.write("<pre>");
    for(x = 0; x < numbersArray.length; x++){
        if(x%10 === 0 && x !== 0){
            document.write("    ");
        }
        document.write(numbersArray[x] + " ");
    }
    document.write("</pre>");
}

function summe(numbersArray)
{
    var sum = 0;
    for(x = 0; x < numbersArray.length; x++){
        sum += numbersArray[x];
    }
    document.write("<br>Summe:" + sum);
    return sum;
}


/**
 * 
 * @param {number} index
 * @param {number} wert
 * @returns {undefined}
 */
function ersetzeZahl(index, wert)
{
   if(index < xzibit.length ){
       if(index >= 0){
           xzibit[index]=wert;
       }
       else{
            console.log("ersetzeZahl: index nicht im Wertebereich!");
       }
       
   }
   else{
       console.log("ersetzeZahl: index nicht im Wertebereich!");
   }
    
    
}


function groessteZahl()
{
    var groesste;
    if(xzibit.length === 0){
        console.log("Array leer!");
    }
    else{
        for(var index = 0; index < xzibit.length; index++){
            if(index === 0){
                groesste = xzibit[index];
            }
            else if(groesste < xzibit[index]){
                groesste = xzibit[index];
            }
            
        }
    }
    return groesste;
}






alleAusgeben(xzibit);
summe(xzibit);
document.write("<p>Die groesste Zahl im Array lautet: " + groessteZahl()+ "</p>");
document.write("<p>Heute ist " + thisDay[new Date().getDay()] + "</p>");