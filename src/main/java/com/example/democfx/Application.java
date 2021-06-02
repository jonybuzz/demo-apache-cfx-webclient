package com.example.democfx;

import com.example.democfx.apis.HogaresApiCalls;

public class Application {

    public static void main(String[] args) throws Exception {
        HogaresApiCalls hogaresRestClient = new HogaresApiCalls();

        String token = hogaresRestClient.obtenerToken("myemail2@mail.com");

        System.out.println(token);
    }
}
