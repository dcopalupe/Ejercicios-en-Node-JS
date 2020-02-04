var https = require('https');

var options = {
    host: '127.0.0.1',
    port: 7777,
    path: '/',
    method: 'GET'
}

var rest = https.request(options, function (res){
    console.log("Cabecera"+ JSON.stringify(res.headers));
    console.log("Status type "+String(res.statusCode)+"");
    
    res.on('data', function(e){
        process.stdout.write(e);
    })
});

rest.end();