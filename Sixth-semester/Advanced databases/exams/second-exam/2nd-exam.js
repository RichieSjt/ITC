// Name and number of employees of the top 10 companies with more than 100 employees in ascending order
db.crunchbase_database.aggregate([
    {$match:{"number_of_employees": {$gt: 100}}},
    {$sort: {"number_of_employees": 1}},
    {$project: {
        _id: 0,
        name: 1,
        number_of_employees: 1
    }},
    {$limit:10}
]);

// Number of companies grouped according to the year of foundation
db.crunchbase_database.aggregate([
    {$bucket: {
        groupBy: "$founded_year",
        boundaries: [1870, 1900, 1930, 1960, 1990, 2010],
        default: "other",
        output: {"total": {$sum:1}}
    }},
    {$project: {
        _id: 0,
        year: "$_id",
        total: 1
    }}
]);

// Name and quantity of products of the 10 companies with the highest number of products available sorted in descending order
db.crunchbase_database.aggregate([
    {$project: {
        _id: 0,
        name: 1,
        number_of_products: {$size: "$products"}
    }},
    {$sort: {"number_of_products": -1}},
    {$limit:10}
]);