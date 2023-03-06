# SpringBootKafkaUseCase
Project for Spring boot produce an consume events from a event broker


# Before Running the producer or Consumer Run Zookeper and Kafka server

 bin\windows\zookeeper-server-start.bat config\zookeeper.properties

 bin\windows\kafka-server-start.bat config\server.properties

# Command to publish a message to topic

Create topic with below command

.\bin\windows\kafka-topics.bat --create --topic topic-name --bootstrap-server localhost:9092

Add events or messages to topic
.\bin\windows\kafka-console-producer.bat --topic topic-name --bootstrap-server localhost:9092

And enter message or event to add

# command to consume a message from topic

.\bin\windows\kafka-console-consumer.bat --topic topic-name --from-beginning --bootstrap-server localhost:9092
