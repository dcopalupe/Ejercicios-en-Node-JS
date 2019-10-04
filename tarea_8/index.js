var net = require('net');

const puerto = process.argv[2];

var server = net.createServer();

server.on("connection", function (socket) {
    console.log("Cliente conectado");

    socket.on("close", () => {
        console.log("Cliente desconectado");
    });

    socket.write("Escribe tu nombre: ");
    socket.on("data", (data) => {
        socket.write("Hola "+data+" te saluda el servidor");
        socket.end();
        console.log("Nombre : " + data);
    })
});

server.listen(puerto, function () {
    console.log("----Servidor conectado----");
    console.log("--Esperando clientes--");
});