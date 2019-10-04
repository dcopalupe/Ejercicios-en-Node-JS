const http = require("http");
const url = require("url");

const server = http.createServer(function (req, res) {

    const dir = url.parse(req.url, true);
    
    console.log(dir.path);
    console.log(dir.pathname);
    console.log(dir.query);

    const { nom, ci} = dir.query;

    if (dir.pathname == "/api/parseTime") {
        res.writeHead(200, { "Content-Type": "text/plain" });
        res.write(`Hola ${nom} tienes carnet nro ${ci}`);
        res.end();
    }else{
        res.writeHead(200, { "Content-Type": "text/plain" });
        res.write(`La ruta no es correcta`);
        res.end();
    }
});

server.listen(9999, function () {
    console.log("Servidor esta corriendo!!!!!!!");
});

/*
Instalar paquetes

github.com/dcopalupe

npm install <nombre_paquete>
npm i <nombre_paquete>

IP 192.168.17.19

http://192.168.17.19:8000/login/auth?nom=dan&ci=7086114
*/