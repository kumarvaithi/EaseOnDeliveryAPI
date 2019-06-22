var fs = require("fs")

fs.readFile('input.txt',function(err,data){
    if(err){
        console.log("Error" , err)
    }
    console.log("Asynchronous", data.toString())
});

fs.readFileSync('input.txt',function(err,data){
    if(err){
        console.log("Error" , err)
    }
    console.log("Synchronous", data.toString())
});