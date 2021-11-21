package io.reflectoring.mocking.controllers;

import io.reflectoring.mocking.services.SendMoneyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMoneyController {
    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping(path = "/sendMoney/{sourceAccountId}/{targetAccountId}/{amount}")
    public ResponseEntity<Void> sendMoney(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") Integer amount) {

        SendMoneyUseCase.SendMoneyCommand command = new SendMoneyUseCase.SendMoneyCommand(
                sourceAccountId,
                targetAccountId,
                amount);

        boolean success = sendMoneyUseCase.sendMoney(command);

        if(success) {
            return ResponseEntity
                    .ok()
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

}
