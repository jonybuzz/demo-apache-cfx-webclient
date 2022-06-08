package com.example.democfx;

import com.example.democfx.apis.DistanciaApiCalls;
import com.example.democfx.apis.GithubApiCalls;

public class Application {

    public static void main(String[] args) throws Exception {
//        DistanciaApiCalls distanciaRestClient = new DistanciaApiCalls();

//        String token = distanciaRestClient.obtenerToken("myemail5@mail.com");

        GithubApiCalls githubApiCalls = new GithubApiCalls();

        githubApiCalls.loguearUsuariosId();

//        System.out.println(token);
    }
}
