var PORT = 33333;
var HOST = '127.0.0.1';

var dgram = require('dgram');
var server = dgram.createSocket('udp4');

//PREFIJO MAS LARGO

let puertos=[
	{
		cadena: '1000',
		puerto: 1,
		coincidencias:0
	},
	{
		cadena: '1010',
		puerto: 2,
		coincidencias:0
	},
	{
		cadena: '1110',
		puerto: 3,
		coincidencias:0
	}

];

server.on('listening', function () {
    var address = server.address();
    console.log('UDP Server listening on ' + address.address + ":" + address.port);
});

server.on('message', function (message, remote) {
    console.log(remote.address + ':' + remote.port +' - ' + message);
    let mensaje=String(message);

    for (let i = 0; i<mensaje.length; i++) {
    	//console.log(mensaje.charAt(i));
    	for (let j = 0; j <puertos.length; j++) {
    		//console.log(puertos[j]);
    		if(puertos[j].cadena.charAt(i) == mensaje.charAt(i)){
    			puertos[j].coincidencias++;
    		}
    	}
    }
    console.log(puertos);

});

server.bind(PORT, HOST);

