const express = require('express')
const router = express.Router()

router.get('/addfreinds',(req,res) =>{
    res.render('addfreinds')
})

module.exports = router