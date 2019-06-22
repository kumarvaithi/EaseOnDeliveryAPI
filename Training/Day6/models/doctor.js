const mongoose = require('mongoose')

const doctorSchema = new mongoose.Schema({
    name : "String"
})

const Doctors = new mongoose.model("Doctors",doctorSchema)


module.exports = Doctors