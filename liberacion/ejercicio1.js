const net = require('net');

const server = net.createServer();

var count = 0;

server.on("connection",function(socket){
    count = count +1;
    console.log("Clientes conectados: "+count);
    socket.write("Escribe tu nombre: ");
    
    socket.on('data', function(data){
        socket.write('\n');
        socket.write("Hola cliente "+data+", usted es el cliente numero "+count+" conectado");
        socket.end();
    });
});

server.listen(7777, function(){
    console.log("Servidor corriendo");
});