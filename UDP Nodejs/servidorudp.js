var udp = require('dgram');
// --------------------creating a udp server --------------------

// creating a udp server
var server = udp.createSocket('udp4');

var nombres = [];

// emits when any error occurs
server.on('error', function (error) {
	console.log('Error: ' + error);
	server.close();
});

function convertir(nom) {
	var total = "";
	nom.forEach(e => {
		total += e+"\n";
	});
	return total;
}

var concatenar = "\n";

// emits on new datagram msg
server.on('message', function (msg, info) {
	console.log('Data received from client : ' + msg.toString());
	console.log('Received %d bytes from %s:%d\n', msg.length, info.address, info.port);

	//sending msg
	//nombres.push(msg.toString());

	//console.log(msg);

	concatenar += msg.toString()+"\n";
	
	mensaje = Buffer.from(concatenar);
	
	//console.log(nombres);
	
	server.send(mensaje, info.port, info.address, function (error) {
		if (error) {
			client.close();
		} else {
			console.log('Data sent !!!');
		}
	});
});

//emits when socket is ready and listening for datagram msgs
server.on('listening', function () {
	var address = server.address();
	var port = address.port;
	var family = address.family;
	var ipaddr = address.address;
	console.log('Server is listening at port' + port);
	console.log('Server ip :' + ipaddr);
	console.log('Server is IP4/IP6 : ' + family);
});

//emits after the socket is closed using socket.close();
server.on('close', function () {
	console.log('Socket is closed !');
});

server.bind(2222);

// setTimeout(function () {
// 	server.close();
// }, 8000);
