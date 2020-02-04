//////////////SERVIDOR TCP BASICO///////////////
/*
var net = require('net'); //importamos el modulo para crear el servidor TCP

var server = net.createServer(); //creamos el servidor 

server.on("connection", function(){     
    console.log("Un cliente se conecto");  // Aca va todo el codigo cuando un cliente se conecta
});

server.listen('9999',function(){
    console.log("-----Servidor Corriendo----");   //Activamos el puerto donde escuchara peticiones
    console.log("  --Esperando clientes--");
});
*/
///////////////////////////////////////////////////

//////////////SERVIDOR TCP///////////////
/////////NUMERO PAR O IMPAR/////////////////////
/*
var net = require('net');

var server = net.createServer();

server.on("connection", function(socket){
    
    socket.write("ESCRIBE UN NUMERO: ");

    var numero = "";
    socket.on("data", function(datos){
        if(datos.toString().charCodeAt(0) == 13 ){
            console.log("El cliente escribio el numero: "+numero);
            if (parseInt(numero) % 2 == 0) {
                socket.write("El numero es par");
            }else{
                socket.write("El numero es impar");
            }
            socket.end();
        }else{
            numero = numero + datos;
        }
    });

    socket.once("close", function(){
        console.log("Cliente desconectado");
    });
});

server.listen('9999',function(){
    console.log("-----Servidor Corriendo----");
    console.log("  --Esperando clientes--");
});
*/
///////////////////////////////////////////////////

///////////////SERVIDOR TCP CON TELNET//////////////////
//////////SERIE FIBONACCI///////////////////

var net = require('net');

var server = net.createServer();

function fibo(a){
    if (a < 3) {
        return 1;
    }else{
        return fibo(a-1)+fibo(a-2);
    }
}

server.on("connection", function(socket){

    //console.log("Cliente conectado ".socket.remoteAddress+" "+socket.remotePort+"");

    var   numero = "";
    socket.write("Cantidad serie fibonacci : ");
    
    socket.on("data", function(datos){
        if(datos.toString().charCodeAt(0) == 13 ){
            console.log("Un cliente pidio los "+numero+" primeros terminos fibonacci");
            var ans = "";
            var i = 1;
            ans = ans + "Respuesta Servidor: ";
            while(i < parseInt(numero)+1){
                ans = ans+fibo(i)+", ";
                i = i+1;
            }
            
            socket.write(ans);
            socket.end();
        }else{
            numero = numero + datos;
        }
    });

    socket.once("close", function(){
        console.log("Cliente desconectado");
    });

    socket.on("error", function(){
        console.log("UPSS!!! OCURRIO UN ERROR".red);
    });
});

server.listen('9999',function(){
    console.log("-----Servidor Corriendo puerto 9999----");
    console.log("  --Esperando clientes--");
});
/////////////////////////////////////////////////


