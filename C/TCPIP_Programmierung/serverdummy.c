#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/time.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <arpa/inet.h>
#include <fcntl.h>
#include <sys/signal.h>
#include <sys/resource.h>
#include <sys/wait.h>
#include <sys/errno.h>

int main(int argc, char *argv[])
{
  struct sockaddr_in clientinfo, serverinfo;
  int serversocket, clientsocket, writeval;
  socklen_t slength, clength;
  char received[1000];
  char sendmessage[] = "RECEIVED, write this in file.\n";

  printf("Creating socket...\n");
  serversocket = socket(AF_INET, SOCK_STREAM, 0);

  serverinfo.sin_family = AF_INET;
  serverinfo.sin_addr.s_addr = htonl(INADDR_ANY);
  serverinfo.sin_port = htons(5000);
  slength = sizeof(serverinfo);
  clength = sizeof(clientinfo);

  printf("Binding socket...\n");
  bind(serversocket, (struct sockaddr *)&serverinfo, slength);
  listen(serversocket, 5);


    printf("Server waiting on port %d\n", ntohs(serverinfo.sin_port));
    fflush(stdout);

    printf("Accept...\n");
    clientsocket = accept(serversocket,(struct sockaddr *)&clientinfo, &clength);
    read(clientsocket, received, sizeof(received));

    printf("%s", received);

    printf("sending message: %s\n", sendmessage);
    writeval = write(clientsocket, sendmessage, sizeof(sendmessage));

    printf("closing sockets...\n");
    close(clientsocket);
    close(serversocket);

  return 0;
}
