package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MicroserviceRepository repository) {

        return args -> {
            Microservice paymentService = new Microservice(
                "PaymentProcessor", "1.2", "Hanterar onlinebetalningar och transaktioner", 
                "FinanceTeam", "Active", Arrays.asList("DatabaseService", "SecurityService"),
                LocalDateTime.now(), LocalDateTime.now(), "Fix for transaction bug", 
                "http://git-repo-payment-processor.com");

            Microservice chatBotService = new Microservice(
                "SupportChatBot", "3.5", "Automatiserad chattbot för kundsupport", 
                "SupportTeam", "In Development", Arrays.asList("NLPService", "UserDatabaseService"),
                LocalDateTime.now(), LocalDateTime.now(), "Added multi-language support", 
                "http://git-repo-support-chatbot.com");

            log.info("Preloading " + repository.save(paymentService));
            log.info("Preloading " + repository.save(chatBotService));
        };
    }
}
