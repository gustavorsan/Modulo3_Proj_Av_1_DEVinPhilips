package com.example.labsky;

import com.example.labsky.model.Passageiro;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

@SpringBootTest
public class HttpRequestTest {
    List<Passageiro> passageiros = new ArrayList<>();

    Mockito


    public void shouldListPassageiros() throws Exception{
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                Passageiro.class)).contains(List< Passageiro >);)
    }
}
