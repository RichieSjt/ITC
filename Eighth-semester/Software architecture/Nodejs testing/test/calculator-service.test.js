const calculatorService = require('../src/service/calculator')
const assert = require('assert')

describe('Calculator service', () => {
    describe('Addition', () => {
        it('Returns the sum of the given numbers', () => {
            const nums = [5, 10, 4]
            const ans = calculatorService.add(nums)
            assert.equal(ans, 19)
        })

        it('Returns the substraction of the given numbers', () => {
            const nums = [4, 2]
            const ans = calculatorService.substract(nums)
            assert.equal(ans, 2)
        })

        it('Returns the multiplication of the given numbers', () => {
            const nums = [5, 10]
            const ans = calculatorService.multiply(nums)
            assert.equal(ans, 50)
        })

        it('Returns the division of the given numbers', () => {
            const nums = [40, 4, 2]
            const ans = calculatorService.divide(nums)
            assert.equal(ans, 5)
        })

        it('Returns null if the divisor is 0', () => {
            const nums = [5, 0]
            const ans = calculatorService.divide(nums)
            assert.equal(ans, null)
        })
    })
})
