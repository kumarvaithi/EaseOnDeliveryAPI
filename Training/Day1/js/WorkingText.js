function dateRunner(){
    const d = new Date();
    var date = d.getDate() + ":"+ d.getMinutes()+ ":" + d.getSeconds();
    document.getElementById("dateDisplay").innerHTML = date;
}

setInterval(dateRunner,1000);
var b = "";
for(var i =1;i<=10;i++){
    var node = document.createElement("td");
    var textNode = document.createTextNode(i);
    node.appendChild(textNode);
    document.getElementById("numberRow").appendChild(node);
    // var a = "<td>" + i +"</td>";
    // b += a;
    // a="";
}
console.log(b);
;