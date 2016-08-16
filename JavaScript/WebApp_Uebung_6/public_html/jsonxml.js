/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function displayArray(myArray)
{
    var output = '<table><tr class="bg2"><th>Name</th><th>Vorname</th><th>Email</th><th>Gruppe</th></tr>';
    var index;
    for (index = 0; index < myArray.length; index++) {

        if (index % 2 === 0) {
            output += '<tr class="bg1" id="mgl">';
        }
        else {
            output += '<tr class="bg2" id="mgl">';
        }

        output += "<td>" +
                myArray[index].Name +
                "</td><td>" +
                myArray[index].Vorname +
                "</td><td>" +
                myArray[index].Email +
                "</td><td>" +
                '<button type="button" onclick="addGroup(' +
                index +
                ')">add</button>' +
                '<button type="button" onclick="removeGroup(' +
                index +
                ')">remove</button>' +
                "</td></tr>";
    }

    output += "</table>";

    document.getElementById("memlist").innerHTML = output;
}



function myRequest()
{
    var xmlhttp = new XMLHttpRequest();
    var url = "mitglieder.json";


    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 1){
            console.warn("Actual Status One: " + xmlhttp.status);
        } else if (xmlhttp.readyState === 2){
            console.warn("Actual Status Two: " + xmlhttp.status);
        } else if (xmlhttp.readyState === 3){
            console.warn("Actual Status Three: " + xmlhttp.status);
        } else if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            console.warn("Actual Status Four: " + xmlhttp.status);
            jsonArray = JSON.parse(xmlhttp.responseText);
            displayArray(jsonArray);
        } else{
            console.warn(xmlhttp.statusText);
        }
    };

    xmlhttp.open("GET", url, true);
    xmlhttp.send();


}


function addGroup(arrayIndex)
{
    var listName = jsonArray[arrayIndex].Name;
    var listVorname = jsonArray[arrayIndex].Vorname;

    var output = '<li id="mgl_Liste' +
            arrayIndex +
            '">' +
            listName +
            ', ' +
            listVorname +
            '</li>';
    if (!document.getElementById("mgl_Liste" + arrayIndex)) {
        document.getElementById("mgl_Liste").innerHTML += output;
    }

}


function removeGroup(arrayIndex) {
    
    if(document.getElementById("mgl_Liste" + arrayIndex)){
        var elem = document.getElementById("mgl_Liste" + arrayIndex);
        elem.parentNode.removeChild(elem);
    }

}




/*****************************************************************************/

//function myRequest()
//{
//    var xmlhttp = new XMLHttpRequest();
//    var url = "mitglieder.json";
//
//
//    xmlhttp.onreadystatechange = function () {
//        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
//            jsonArray = JSON.parse(xmlhttp.responseText);
//            displayArray(jsonArray);
//        }
//        else{
//            console.warn(xmlhttp.statusText);
//        }
//    };
//
//    xmlhttp.open("GET", url, true);
//    xmlhttp.send();
//
//
//}