const mongoose = require('mongoose')
const url = "mongodb://localhost:27017/mydb"

mongoose.connect(url,{useNewUrlParser:true})

module.exports.Doctors = require('./doctor')
module.exports.Users = require('./user')