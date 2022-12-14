# Distributed event streaming app

Springboot backend application which is using Apache Kafka
for event streaming. It contains Producer with rest api which is pushing
message to Consumer.

## Technologies used
- Java 17
- Springboot
- Kafka
- Zookeeper
- Docker

## How to run app locally?
- git clone
- go to the root directory
- execute command (it will run 2 containers Kafka and Zookeeper): docker-compose -f docker-compose.yml up -d
- run Consumer as springboot app: it will run on port 8082
- run Producer as springboot app: it will run on port 8083

## How to test app?
- send a POST request on: http://localhost:8083/produce/message
-  {
  "messageId": 1,
  "body": "test body",
  "header": "test header",
  "metaData": "test metadata"
  }
- check logs on Producer and Consumer

### Docker usage
- stop all docker containers: docker container stop $(docker ps -a -q)
- remove all docker containers: sudo docker rm $(sudo docker ps -a -q)
- remove all docker images: sudo docker rmi $(sudo docker images -q)

### Docker&Kafka setting source
- https://www.baeldung.com/kafka-docker-connection

