package io.reflectoring.mocking.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SendMoneyService implements SendMoneyUseCase{
    public SendMoneyService() {
        log.info(">>> constructing SendMoneyService! <<<");
    }

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        log.info("sending money!");
        return true;
    }

}
