package io.reflectoring.mocking.controllers;

import io.reflectoring.mocking.services.SendMoneyService;
import io.reflectoring.mocking.services.SendMoneyUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class SendMoneyControllerAutoConfigureMvcTest {

    @Mock
    SendMoneyService sendMoneyServMock;

    @InjectMocks
    SendMoneyController sendMoneyController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = standaloneSetup(sendMoneyController).build();
    }

    @Test
    void sendMoney() throws Exception {
        // Given
        SendMoneyUseCase.SendMoneyCommand sendMoneyCmd = new SendMoneyUseCase.SendMoneyCommand(1234L,4321L,250);

        when(sendMoneyServMock.sendMoney(sendMoneyCmd)).thenReturn(true);

        mockMvc.perform(post("/sendMoney/{sourceAccountId}/{targetAccountId}/{amount}",1234L, 4321L, 250))
                .andExpect(status().isOk())
                .andDo(print());
    }
}