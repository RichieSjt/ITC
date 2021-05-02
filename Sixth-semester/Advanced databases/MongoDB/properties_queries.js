// Total number of properties
db.reviews.count()

// Number of properties whose property type is House
db.reviews.find({"property_type": "House"})

// Properties in portugal
db.reviews.count({"addres.country": "Portugal"})

// Number of properties with at least 10 reviews
db.reviews.count({"number_of_reviews": {$gte: 10}})

// Names of the properties with more than 300 reviews
db.reviews.find({"number_of_reviews": {$gt: 300}}, {"_id": 0, "name": 1})

// Determine the different countries available
db.reviews.distinct("address.country")


// We create an aggregation pipeline to
db.reviews.aggregate([
    {$match: {"property_type": "House"}}
])

db.reviews.aggregate([
    {$match: {"number_of_reviews": {$gt: 300}}},
    {$project: {"_id": 0, "name": 1}}
])

// Number of properties per country
db.reviews.aggregate([
    {$group: {"_id": "$address.country", "total": {$sum: 1}}}
])

db.reviews.aggregate([
    {$group: {
        "_id": "$address.country", 
        "min_price": {$min: {$toDouble: "$price"}},
        "max_price": {$max: {$toDouble: "$price"}}
    }}
])

db.reviews.aggregate([
    {$match: {"address.country": "Spain"}},
    {$bucket: {
        groupBy: "$price",
        boundaries: [0, 100, 300, 500],
        default: "500+",
        output: {"total": {$sum: 1}}
    }}
])

db.order.insertMany([
	{id:1, item:"Almonds", price:12, quantity:2},
	{id:2, item:"Pecans", price:20, quantity:1}
])

db.inventory.insertMany([
	{id:1, sku:"Almonds", description:"Product 1", inStock:120},
	{id:2, sku:"Bread", description:"Product 2", inStock:80},
	{id:3, sku:"Cashews", description:"Product 3", inStock:60},
	{id:4, sku:"Pecans", description:"Product 4", inStock:70},
	{id:5, description:"Incomplete"},
])

// Obtain the inventory details of every product in an order
db.order.aggregate([
    {
        $lookup: {
            from: "inventory",
            localField: "item",
            foreignField: "sku",
            as: "inventory_docs"
        }
    }
])

// Obtain the number of properties having each of the amenities

db.reviews.aggregate([
    {$unwind: "$amenities"},
    {$group: {
        _id: "$amenities",
        "total": {$sum: 1}
    }},
    {$sort: {"total": -1}}
])