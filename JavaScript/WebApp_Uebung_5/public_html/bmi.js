/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function calculateBMI()
{
    var weight = document.getElementById("gewicht").value;
    var height = document.getElementById("groesse").value;
    var bmi =  weight / (height * height);
    document.getElementById("bmitxt").innerHTML=bmi.toFixed(2);
}



function testNameAnmerk()
{
    var name = document.getElementById("uname").value;
    var anmerk = document.getElementById("anmerk").value;
    
    var nameTest = /^[a-zA-Z]+\s+[a-zA-Z]+$/.test(name);
    var anmerkTest = /<[A-Za-z=""\s]+>/g.test(anmerk);
    
    console.log("nameTest " + nameTest);
    console.log("anmerkTest " + anmerkTest);
    
    if(nameTest === true){
        if(anmerkTest === false){
            console.log("Alles Ok");
            return true;
        }
        else{
            alert("Formularübermittlung fehlgeschlagen!");
            return false;
        }
    }
    else{
        alert("Formularübermittlung fehlgeschlagen!");
        return false;
    }
    
    
    
    
}



//[A-Za-z]+[^0-9!"§$%&/()=?"]\s[A-Za-z]+[^0-9!"§$%&/()=?"]