const router = require('express').Router()
const calculatorController = require('../controllers/calculator')

router.post('/add', calculatorController.add)
router.post('/substract', calculatorController.substract)
router.post('/multiply', calculatorController.multiply)
router.post('/divide', calculatorController.divide)

module.exports = router
