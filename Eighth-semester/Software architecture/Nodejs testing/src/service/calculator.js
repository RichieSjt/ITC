exports.add = (nums) => {
    return nums.reduce((prev, curr) => prev + curr)
}
exports.substract = (nums) => {
    return nums.reduce((prev, curr) => prev - curr)
}
exports.multiply = (nums) => {
    return nums.reduce((prev, curr) => prev * curr)
}
exports.divide = (nums) => {
    const ans = nums.reduce((prev, curr) => prev / curr)
    
    return ans == Infinity ? null : ans
}