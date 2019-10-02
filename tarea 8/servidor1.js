var net = require('net');

const puerto = process.argv[2];

var server = net.createServer();

server.on("connection",function(connection) {
	console.log('Cliente Conectado');
	var d = new Date();
	var mes = parseInt(d.getMonth());
    mes = completar(mes+1);
    var dia = parseInt(d.getDate());
    dia = completar(dia);
    var hora = parseInt(d.getHours());
    hora = completar(hora);
    var minutos = parseInt(d.getMinutes());
    minutos = completar(minutos);

 	connection.on('close', function() {
 		console.log('Cliente Desconectado');
 	});
     connection.write(d.getFullYear()+'-'+mes+'-'+dia+' '+hora+':'+minutos+'\n');
     connection.end();     
}).listen(puerto, function() {
	 console.log('---Servidor listo/Esperando conexiones---');
});

function completar(m){
    if (m < 10) { 
    	m = "0"+ String(m); 
    };
    return m;
}