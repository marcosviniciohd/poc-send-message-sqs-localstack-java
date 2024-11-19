package br.com.localstack.sqs.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SqsService {

    @Autowired
    private AmazonSQS amazonSQS;

    private final String queueUrl = "http://localhost:4566/000000000000/confirmation-payment-sqs.fifo";

    public void sendMenssage(String messageBody, String messageGroupId) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(messageBody)
                .withMessageGroupId(messageGroupId);
        amazonSQS.sendMessage(sendMessageRequest);
    }

    public List<Message> receiveMessages() {
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl)
                .withWaitTimeSeconds(5)
                .withMaxNumberOfMessages(10);
        return amazonSQS.receiveMessage(receiveMessageRequest).getMessages();
    }
}
