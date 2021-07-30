package com;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.FixerModel;
import com.services.FixerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.IIOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class SpringBootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
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
