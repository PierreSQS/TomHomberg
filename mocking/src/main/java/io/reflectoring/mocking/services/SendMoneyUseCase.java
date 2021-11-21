package io.reflectoring.mocking.services;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

public interface SendMoneyUseCase {
    boolean sendMoney(SendMoneyCommand command);

    @Value
    @Getter
    @EqualsAndHashCode(callSuper = false)class SendMoneyCommand {
        Long sourceAccountId;
        Long targetAccountId;
        Integer money;

        public SendMoneyCommand(
                Long sourceAccountId,
                Long targetAccountId,
                Integer money) {
            this.sourceAccountId = sourceAccountId;
            this.targetAccountId = targetAccountId;
            this.money = money;
        }
    }
}
