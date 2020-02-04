const http = require('http');
const url = require('url');
const moment = require('moment');

const server = http.createServer(function (req, res) {
    console.log("Cliente conectado");
    
    const dir = url.parse(req.url, true);
    
    var fecha = dir.query.fechanac;
    var nom = dir.query.nom;
    var ans = moment().diff(fecha, "days");
    
    res.writeHead(200, { "Content-Type": "text/plain" });
    res.write("Hola "+nom+" tienes "+ans+" dias de edad");
    res.end();
});

server.listen(9999, function () {
    console.log("Servidor corriendo");
});