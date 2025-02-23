package net.mdsgene.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Set;

@Controller
public class ProxyController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/map")
    public void proxy(HttpServletRequest request, HttpServletResponse response) {
        __proxy(request, response);
    }

    @GetMapping("/d/0/gu/0")
    public void proxy2(HttpServletRequest request, HttpServletResponse response) {
        __proxy(request, response);
    }

    private void __proxy(HttpServletRequest request, HttpServletResponse response) {
        String targetUrl = "http://141.83.24.202:8887/d/0/gu/0";

        // Создаем URI с учетом параметров запроса
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(targetUrl);
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);

            for (String paramValue : paramValues) {
            try {
                // Экранируем значения параметров запроса, чтобы избежать проблем с символом '+'
                String encodedParamValue = URLEncoder.encode(paramValue, StandardCharsets.UTF_8.toString())
                        .replace("+", "%20"); // Заменяем '+' на '%20' (или на '%2B', если нужно плюс)

                    // Добавляем экранированные параметры в URI
            uriBuilder.queryParam(paramName, encodedParamValue);
            } catch (Exception e) {
                e.printStackTrace();
        }
        }
        }
        URI uri = uriBuilder.build(true).toUri();

        // Выполняем запрос
        ResponseEntity<byte[]> result = restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, byte[].class);

        // Настраиваем ответ
        response.setStatus(result.getStatusCodeValue());
        HttpHeaders headers = result.getHeaders();
        Set<String> headerNames = headers.keySet();
        for (String header : headerNames) {
            if (!header.equalsIgnoreCase("Transfer-Encoding")) { // Исключаем Chunked Encoding
                response.setHeader(header, headers.getFirst(header));
            }
        }

        // Пишем тело ответа
        try {
            response.getOutputStream().write(result.getBody());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
