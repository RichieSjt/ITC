const calculatorService = require('../service/calculator')

exports.add = (req, res) => {
    const nums = req.body.nums
    const ans = calculatorService.add(nums)

    res.status(200).send({
        operation: 'Addition',
        input: nums,
        output: ans,
    })
}

exports.substract = (req, res) => {
    const nums = req.body.nums
    const ans = calculatorService.substract(nums)

    res.status(200).send({
        operation: 'Substraction',
        input: nums,
        output: ans,
    })
}

exports.multiply = (req, res) => {
    const nums = req.body.nums
    const ans = calculatorService.multiply(nums)

    res.status(200).send({
        operation: 'Multiplication',
        input: nums,
        output: ans,
    })
}

exports.divide = (req, res) => {
    const nums = req.body.nums
    const ans = calculatorService.divide(nums)

    res.status(200).send({
        operation: 'Division',
        input: nums,
        output: ans,
    })
}
