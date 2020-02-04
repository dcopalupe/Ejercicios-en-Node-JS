var udp = require('dgram');
var leer = require('./prueba');

// creating a client socket
var client = udp.createSocket('udp4');

client.on('message', function (msg, info) {
  console.log('Data received from server : ' + msg.toString());
  //console.log('Received %d bytes from %s:%d\n', msg.length, info.address, info.port);
});



leer.question('Ingresa tu nombre ', (name) => {

  //buffer msg
  var data = Buffer.from(name);

  //sending msg
  client.send(data, 2222, 'localhost', function (error) {
    if (error) {
      client.close();
    } else {
      console.log('Data sent !!!');
      
    }
  });

});



/*var data1 = Buffer.from('hello');
var data2 = Buffer.from('world');

//sending multiple msg
client.send([data1,data2],2222,'localhost',function(error){
  if(error){
    client.close();
  }else{
    console.log('Data sent !!!');
  }
});
*/