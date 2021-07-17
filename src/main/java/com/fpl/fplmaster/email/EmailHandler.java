package com.fpl.fplmaster.email;

import com.fpl.fplmaster.common.KafkaConstants;
import com.fpl.fplmaster.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailHandler {

    private KafkaTemplate<String, Email> kafkaTemplate;
    private EmailSender emailSender;

    @Autowired
    public EmailHandler(KafkaTemplate<String, Email> kafkaTemplate, EmailSender emailSender) {
        this.emailSender = emailSender;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Email email) {
        kafkaTemplate.send(KafkaConstants.emailTopic, email);
    }

    @KafkaListener(topics = {KafkaConstants.emailTopic}, containerFactory = "kafkaListenerContainerFactory")
    public void listenGroup(Email email) {
        emailSender.sendSimpleMessage(email);
    }

    /*@KafkaListener(topics = KafkaConstants.emailTopic)
    public void listenWithHeaders(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(
                "Received Message: " + message"
                        + "from partition: " + partition);
    }*/

    /*@KafkaListener(topicPartitions
            = @TopicPartition(topic = "topicName", partitions = {"0", "1"}))
    public void listenToPartition(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Message: " + message + "from partition: " + partition);
    }
*/
    /*@KafkaListener(
            topicPartitions = @TopicPartition(topic = "topicName",
                    partitionOffsets = {
                            @PartitionOffset(partition = "0", initialOffset = "0"),
                            @PartitionOffset(partition = "3", initialOffset = "0")}),
            containerFactory = "partitionsKafkaListenerContainerFactory")
    public void listenToPartitionFromStart(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Message: " + message + "from partition: " + partition);
    }

    public void sendMessageWithACK(String message) {
        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(KafkaConstants.emailTopic, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
    }*/
}
