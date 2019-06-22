const mongoose = require('mongoose')

const userSchema = new mongoose.Schema({
    name : String
})

const Users = new mongoose.model("Users",userSchema)


module.exports = Users