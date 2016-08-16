/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function halloFulda()
{
    var message = "Hallo Fulda";
    return message;
}

function strings(string1, string2)
{
    return (string1+string2);
}

function iterativ(x, y)
{
    var sum=0,i=0;
    while(i<x)
    {
        sum=sum+y;
        i++;
    }
    return sum;
    
}

function rekursiv(x, y)
{
    if(x>1)
    {
        return y+rekursiv(x-1,y);
    }
    return y;
    
}

function factorial(zahl)
{
    if(zahl>1)
    {
        return zahl*factorial(zahl-1);
    }
    else if(zahl===0)
    {
        return 1;
    }
    else if(zahl%1!==0 || zahl<0)
    {
        console.log("Der an die Fakultäts-Funktion übergebene Wert ist keine natürliche Zahl");
        return 0;
    }
    return zahl;
}


function pattern(zeilen)
{
    var string="";
    for(i=0;i<zeilen;i++)
    {
        for(j=(i*2)+1;j>0;j--)
        {
            string+="+";
        }   
        string+="<br>";
    }
    return string;
}

