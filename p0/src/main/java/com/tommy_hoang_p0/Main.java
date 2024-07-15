package com.tommy_hoang_p0;

import com.tommy_hoang_p0.Members.MemberRepository;
import com.tommy_hoang_p0.Members.MemberService;
import com.tommy_hoang_p0.Util.Auth.AuthController;
import com.tommy_hoang_p0.Util.Auth.AuthService;

import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dealership Point of Sale is up and running.....");

        Javalin app = Javalin.create(config -> {
            config.jsonMapper(new JavalinJackson());
        });
        
        //Member memberLoggedIn = null; // Storing the Users Session
        //MemberController memberController = new MemberController(memberService);
        MemberRepository memberRepository = new MemberRepository();
        MemberService memberService = new MemberService(memberRepository);

        AuthService authService = new AuthService(memberService);
        AuthController authController = new AuthController(authService);
        authController.registerPaths(app);

        app.start(8080);
    }
}