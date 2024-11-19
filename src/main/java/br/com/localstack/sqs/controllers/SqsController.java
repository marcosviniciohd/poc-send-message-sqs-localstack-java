package br.com.localstack.sqs.controllers;

import br.com.localstack.sqs.SqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqsController {

    @Autowired
    private SqsService sqsService;

    @GetMapping("/send-message")
    public String sendMessage(@RequestParam String messageBody, @RequestParam String messageGroupId) {
        sqsService.sendMenssage(messageBody, messageGroupId);
        return "Mensagem enviada com sucesso!";
    }

}
