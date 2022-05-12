const request = require('supertest')
const app = require('../src/app')
const assert = require('assert')

describe('Calculator API', () => {
    describe('Addition', () => {
        it('Should return the sum of the given numbers', async () => {
            const res = await request(app).post('/add').send({
                nums: [1, 2, 3, 4]
            })

            const { output } = res.body

            assert.equal(res.status, 200)
            assert.equal(output, 10)
        })
        
        it('Should return the substraction of the given numbers', async () => {
            const res = await request(app).post('/substract').send({
                nums: [20, 10, 2]
            })

            const { output } = res.body

            assert.equal(res.status, 200)
            assert.equal(output, 8)
        })

        it('Should return the multiplication of the given numbers', async () => {
            const res = await request(app).post('/multiply').send({
                nums: [5, 4, 2, 3]
            })

            const { output } = res.body

            assert.equal(res.status, 200)
            assert.equal(output, 120)
        })

        it('Should return the division of the given numbers', async () => {
            const res = await request(app).post('/divide').send({
                nums: [10, 2]
            })

            const { output } = res.body

            assert.equal(res.status, 200)
            assert.equal(output, 5)
        })
    })
})
