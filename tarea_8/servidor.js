var net = require('net');
var moment = require('moment');

const puerto = process.argv[2];

var server = net.createServer();

server.on("connection",function(socket){
    console.log("Cliente conectado");
    socket.write(moment().format('YYYY-MM-DD hh:mm'));
    socket.write("\n");
    socket.end();
});

server.listen(puerto,function(){
    console.log("----Servidor conectado----");
    console.log("--Esperando clientes--");
});