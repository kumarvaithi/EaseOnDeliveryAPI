const express = require('express')
const app = express()
const port = 8080
const path = require('path')
const bodyParser = require('body-parser')
const methodOverride = require('method-override')

//router const
const homeRouter = require('./routes/home')
const addfreindsRouter = require('./routes/addfreinds')
const userRouter = require('./routes/user.js')

app.set('views',path.join(__dirname,'views'))
app.set('view engine', 'ejs')
app.use(express.static(path.join(__dirname,'public')))

app.use(bodyParser.urlencoded({ extended: false }))
 
// override with POST having ?_method=DELETE
app.use(methodOverride('_method'))

// parse application/json
app.use(bodyParser.json())
app.use('/',homeRouter)
app.use('/',addfreindsRouter)
app.use('/user',userRouter)

// app.get('/login',(req,res) =>{
//     res.render('login',{friends:friends})
// })


app.listen(port,() => console.log(`app is listening at ${port}`))