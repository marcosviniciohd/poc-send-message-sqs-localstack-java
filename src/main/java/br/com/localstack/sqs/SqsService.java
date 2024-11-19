package br.com.localstack.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
