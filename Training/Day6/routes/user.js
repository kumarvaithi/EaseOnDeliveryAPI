const express = require('express')
const router = express.Router()
const db = require('../models')

router.get('/',(req,res) => {
    db.Users.find()
    .then((users) =>{
        if(users.length === 0){
            res.json({msg: "No Data Found!"})
        }else{
            // res.json(users)
            res.render("addNewUser",{data:users})
        } 
    })
    .catch((err) => res.send(err))
})

router.post('/',(req,res) =>{
    db.Users.create(req.body)
    .then((users) =>{
        // res.json(users)  
        res.redirect("/user")
    })
    .catch((err) => res.send(err))
})

//find by id
router.get('/:id',(req,res) => {
    db.Users.findById(req.params.id)
    .then((data) =>{
        // res.json(data)
        res.render('showUser',{data:data})
    })
    .catch((err) => res.send(err))
})

//find by id
router.get('/edit/:id',(req,res) => {
    db.Users.findById(req.params.id)
    .then((data) =>{
        // res.json(data)
        res.render('editUser',{data:data})
    })
    .catch((err) => res.send(err))
})

//update
router.put('/edit/:id',(req,res) =>{
    db.Users.findByIdAndUpdate({_id:req.params.id},req.body)
    .then((data) => res.redirect('/user'))
    .catch((err)=>res.send(err))
})

//delete
router.delete('/delete/:id',(req,res)=>{
    db.Users.remove({_id: req.params.id})
    // .then(res.send("user deleted"))
    .then(res.redirect("/user"))
    .catch((err)=>res.send(err))
})

module.exports = router