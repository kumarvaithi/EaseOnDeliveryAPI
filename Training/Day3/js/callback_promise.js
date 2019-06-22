var button = document.getElementById("button");

button.onclick = function(){
    alert("Button clicked");
}


var promise1 = new Promise(function (resolve,reject){
    setTimeout(function (){
        resolve('foo');
        // reject();
    }, 300);
});


var promise = document.getElementById("promise")//ES 6
promise.onclick = function(){
    promise1.then(function(value){
        alert("From Promize" + value);
    })

    promise1.catch(function(err){
        alert("From Promise Error " + err)
    })
}

var async = document.getElementById("async"); //ES 7

async function f(){
    let promise = new Promise((resolve,reject) =>{
        setTimeout(() => resolve("From Async Await !"),1000)
    });

    let result = await promise; //
    alert(result);
}

async.onclick = function(){
    f()
};