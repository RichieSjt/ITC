// 1. Total number of movies
db.movies.count()

// 2. List of countries where the movies where projected
db.movies.distinct("countries")

// 3. Total number of movies projected on every country
db.movies.aggregate([
    {$unwind:"$countries"},
    {
        $group:{
            _id:"$countries",
            "total":{$sum:1}
        }
    }
]);
// 4. Titles of the movies with more comments (and the correspondent number of comments)

db.comments.aggregate([
    {$group: {
        _id: "$movie_id",
        "total": {$sum: 1}
    }},
    {$sort: {"total": -1}},
    {$lookup:{
        from: "movies",
        localField: "_id",
        foreignField: "_id",
        as: "movie_comments"
    }},
    {$project: {
        _id: 0,
        title: "$movie_comments.title",
        total_comments: "$total"
    }}
]);

// 5. Total number of movies per every 10-year period

db.movies.aggregate([
    {$bucket: {
        groupBy: "$year",
        boundaries: [1890,1900,1910,1920,1930,1940,1950,1960,1970,1980,1990,2000,2010,2020],
        default: "2010+",
        output: {"total": {$sum:1}}
    }},
    {$project: {
        _id: 0,
        year: "$_id",
        total: "$total"
    }}
]);


// 6. Total number of theatres per city
db.theaters.aggregate([
    {$unwind:"$location.address.city"},
    {
        $group:{
            _id:"$location.address.city",
            "total":{$sum:1}
        }
    },
    {$project: {
        _id: 0,
        city: "$_id",
        number_of_theaters: "$total"
    }}
]);

// 7. List the different genres available
db.movies.aggregate([
    {$unwind:"$genres"},
    {
        $group:{
            _id:"$genres"
        }
    }
]);

// 8. Total number of movies per actor (Display only the top 10 actors)
db.movies.aggregate([
    {$unwind:"$cast"},
    {
        $group:{
            _id:"$cast",
            "number_of_movies": {$sum:1}
        }},
    {$sort:{number_of_movies:-1}},
    {$limit:10}
]);


// 9. Total number of movies per director (Display only the top 10 directors)
db.movies.aggregate([
    {$unwind:"$directors"},
    {
        $group:{
            _id:"$directors",
            "number_of_movies": {$sum:1}
        }},
    {$sort:{number_of_movies:-1}},
    {$limit:10}
]);

// 10. Total number of comments per movie (Display only the top 10 movies)
db.comments.aggregate([
    {$group: {
        _id: "$movie_id",
        "total": {$sum: 1}
    }},
    {$sort: {"total": -1}},
    {$lookup:{
        from: "movies",
        localField: "_id",
        foreignField: "_id",
        as: "movie_comments"
    }},
    {$project: {
        _id: 0,
        title: "$movie_comments.title",
        total_comments: "$total"
    }},
    {$limit:10}
]);