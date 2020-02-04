const http = require('http');
const fs = require('fs');
const url = require('url')

const server = http.createServer(function (peticion, respuesta) {

    const dir = url.parse(peticion.url, true);
    const archivo = dir.pathname;

    console.log(archivo)

    if (archivo != "/") {
        const data = fs.readFileSync("./archivos" + archivo)
        respuesta.writeHead(200, "content-type: application/json");
        respuesta.write(data);
        respuesta.end();
    } else {
        const data = fs.readFileSync("./index1.html")
        respuesta.writeHead(200, "content-type: text/html");
        respuesta.write(data);
        respuesta.end();
    }


});

server.listen(9999, function () {
    console.log("----Servidor iniciado----");
});

