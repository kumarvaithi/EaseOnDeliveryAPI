const express = require('express')
const router = express.Router()

let friends = ['Vicky','Prakash','Lithesh']
router.get('/home',(req,res)=>{
    res.render('home',{friends:friends})
})

router.post('/addfreinds',(req,res) =>{
    console.log('from submit friend')
    console.log(req.body);
    friends.push(req.body.freinds)
    res.redirect('/home')
})
module.exports = router