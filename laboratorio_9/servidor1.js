const http = require("http");
const url = require("url")
const moment = require("moment")

const server = http.createServer(function (req, res){

    var dir = url.parse(req.url,true).query.iso;

    console.log(dir);
    console.log(moment.utc(dir));
    

    res.writeHead(200, {"Content-Type": "text/html"});
    res.write(`<h1>${dir}</h1>`);
    res.end();
});

server.listen(7777, function (){
    console.log("Servidor iniciado");
});
