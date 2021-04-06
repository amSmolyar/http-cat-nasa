package ru.netology;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static final String SERVICE_URL = "https://cat-fact.herokuapp.com/facts";
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setUserAgent("Test service")
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        // создание объекта запроса:
        HttpGet request = new HttpGet(SERVICE_URL);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        try {
            // отправка запроса:
            CloseableHttpResponse response = httpClient.execute(request);
            // вывод полученных заголовков:
            Arrays.stream(response.getAllHeaders()).forEach(System.out::println);
            // Преобразование json:
            List<Cat> cats = mapper.readValue(response.getEntity().getContent(), new TypeReference<List<Cat>>() {});
            // Вывод в консоль:
            System.out.println("\n\nПолный список:\n");
            cats.forEach(System.out::println);

            System.out.println("\n\nОтфильтрованный список:\n");
            cats.stream()
                    .filter(value -> value.getText().startsWith("W") == true)
                    .forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
