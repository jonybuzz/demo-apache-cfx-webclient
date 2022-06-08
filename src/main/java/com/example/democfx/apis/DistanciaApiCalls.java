package com.example.democfx.apis;

import com.example.democfx.apis.dto.AutenticacionRequest;
import com.example.democfx.apis.dto.AutenticacionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;

public class DistanciaApiCalls {

    public String obtenerToken(String mail) throws Exception {
        WebClient clientUsers = WebClient.create("https://ddstpa.com.ar/api/user");

        AutenticacionRequest autenticacionRequest = new AutenticacionRequest(mail);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(autenticacionRequest);
        System.out.println("Autent request = " + requestBody);


        Response response = clientUsers
                .header("Content-Type", "application/json")
                .post(requestBody);

        int status = response.getStatus();
        System.out.println("Status: " + status);
        String responseBody = response.readEntity(String.class);
        if (status == 201) {
            System.out.println("Autent response = " + responseBody);
            AutenticacionResponse autenticacionResponse = objectMapper.readValue(responseBody, AutenticacionResponse.class);
            return autenticacionResponse.getToken();
        } else {
            System.out.println("Error response = " + responseBody);
            throw new Exception("Error en la llamada a /api/user");
        }
    }
}
