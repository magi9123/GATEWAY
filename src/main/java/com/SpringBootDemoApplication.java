package com;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.FixerModel;
import com.services.FixerService;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MessageConverter;

import javax.imageio.IIOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class SpringBootDemoApplication {

    @Value("${spring.rabbitmq.host}")
    String host;

    @Value("${spring.rabbitmq.username}")
    String username;

    @Value("${spring.rabbitmq.password}")
    String password;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Bean
    CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        return cachingConnectionFactory;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return (MessageConverter) new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter((org.springframework.amqp.support.converter.MessageConverter) jsonMessageConverter());
        return rabbitTemplate;
    }


    CommandLineRunner runner(FixerService fixerService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<FixerModel>> typeReference = new TypeReference<List<FixerModel>>() {
            };

            InputStream inputStream = TypeReference.class.getResourceAsStream("http://data.fixer.io/api/latest?access_key=a59542744c84078d88423d1d30b6ba47");

            try {
                List<FixerModel> fixerModels = mapper.readValue(inputStream, typeReference);
                fixerService.save(fixerModels);
            } catch (IIOException ex) {
                System.out.println(ex.getStackTrace());
            }
        };
    }
}
