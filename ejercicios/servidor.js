///////////////TAREA 8 version 1////////////////////////
/*
var net = require('net');

const puerto = process.argv[2];

var server = net.createServer(function(connection) {
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
});

server.listen(puerto, function() {
	 console.log('---Servidor listo/Esperando conexiones---');
});

function completar(m){
    if (m < 10) { 
    	m = "0"+ String(m); 
    };
    return m;
}
*/
/////////////////////////////////////////////////////////

/////////////////TAREA 8 version 2//////////////////////
/*
var net = require('net');
var moment = require('moment');

const puerto = process.argv[2];

var server = net.createServer();

server.on("connection",function(socket){
    socket.write(moment().format('YYYY-MM-DD hh:mm'));
    socket.end();
});

server.listen(puerto,function(){
    console.log("----Servidor conectado----");
    console.log("--Esperando clientes--");
});
*/
////////////////////////////////////////////////////////

///////////////////VARIANTES ////////////////////////

/*
var net = require('net');
var moment = require('moment');

const puerto = process.argv[2];

var server = net.createServer();

server.on("connection",function(socket){
    socket.write(moment().format('YYYY-MM-DD hh:mm'));
    socket.end();
}).listen(puerto,function(){
    console.log("----Servidor conectado----");
    console.log("--Esperando clientes--");
});
*/


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
