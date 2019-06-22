const express = require('express')
const app = express()
const port = 8080
const path = require('path')
const bodyParser = require('body-parser')

let friends = ['Vicky','Prakash','Lithesh']

app.set('views',path.join(__dirname,'views'))
app.set('view engine', 'ejs')
app.use(express.static(path.join(__dirname,'public')))

app.use(bodyParser.urlencoded({ extended: false }))
 
// parse application/json
app.use(bodyParser.json())

app.get('/home',(req,res) =>{
    res.render('home',{friends:friends})
})

app.get('/addfreinds',(req,res) =>{
    res.render('addfreinds')
})

app.get('/login',(req,res) =>{
    res.render('login',{friends:friends})
})

app.post('/addfreinds',(req,res) =>{
    console.log('from submit friend')
    console.log(req.body);
    friends.push(req.body.freinds)
    res.redirect('/home')
})

app.listen(port,() => console.log(`app is listening at ${port}`))