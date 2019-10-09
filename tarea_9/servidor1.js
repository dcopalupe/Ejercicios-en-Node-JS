const http = require('http');
const fs = require('fs');

const server = http.createServer(function (peticion, respuesta){

    const data = fs.readFileSync('./archivos/Instrucciones.pdf')
    respuesta.writeHead(200, "content-type: application/pdf");
    respuesta.write(data);
    respuesta.end();
});

server.listen(7777, function (){
    console.log("----Servidor iniciado----");
});

