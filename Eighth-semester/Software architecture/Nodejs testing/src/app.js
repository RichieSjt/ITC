const express = require('express')
const calculatorRoutes = require('./routes/calculator')

const app = express()

app.use(express.json())
app.use(express.urlencoded({ extended: true }))

app.use(calculatorRoutes)

module.exports = app
