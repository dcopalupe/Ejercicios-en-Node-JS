console.log("hola mundo");







/*var http = require('http');
var url = require('url');

var server = http.createServer(function(peticion, respuesta){
    
    var dir = url.parse(peticion.url,true);
    var ru = dir.pathname;

    console.log(dir.path);
    console.log("ruta"+ru);
    console.log(dir.query.iso);

    respuesta.writeHead(200, {"Content-Type": "text/plain"});
    respuesta.write("soy un texto plano");
    respuesta.end();
});

server.listen(9999, function(){
    console.log("Servidor corriendo");
});
*/

/*const http = require('http');
const yargs = require('yargs');

const argv = yargs
	.options({
		p: {
			demand: true,
			alias: 'puerto',
			describe: 'Ingrese el puerto donde se desea ejecutar la app',
			string: true
		}
	})
	.help()
	.alias('help','h')
	.argv;

const host='localhost';
//const puerto=9000;
const puerto =argv.puerto;

const estudiante={nombre: 'Juan', apellido: 'Perez'}

const server=http.createServer((req,res)=>{
	res.statusCode = 200;
	res.setHeader=('Content-Type','application/json');
	res.end(JSON.stringify(estudiante));
})

server.listen(puerto,host, ()=>{
	console.log(`Servidor ejecutando en http://${host}:${puerto}/`);
})*/







