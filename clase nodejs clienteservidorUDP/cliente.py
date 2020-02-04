import socket

name = input("Introdusca la url : ")
print(name+" -",socket.gethostbyname(name))