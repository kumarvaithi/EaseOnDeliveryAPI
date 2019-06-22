const http = require('http')

http.createServer(function(request,response){
    console.log(response)
}).listen(8080, function(){
    console.log("node is running at port 8080");
})