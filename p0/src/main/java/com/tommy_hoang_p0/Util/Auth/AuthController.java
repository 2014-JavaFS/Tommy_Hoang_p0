package com.tommy_hoang_p0.Util.Auth;

import javax.security.sasl.AuthenticationException;

import com.tommy_hoang_p0.Users.User;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public void registerPaths(Javalin app) {
        app.post("/login", this::handleLogin);
        app.get("/user-info", this::handleUserInfo);
    }

    private void handleLogin(Context ctx) {
        String email = ctx.queryParam("email");
        String password = ctx.queryParam("password");

        try {
            User user = authService.login(email, password);
            ctx.header("userId", String.valueOf(user.getUserId()));
            ctx.header("type", user.getType().name());
            ctx.status(200);
        } catch (AuthenticationException e) {
            ctx.status(HttpStatus.UNAUTHORIZED);
        }
    }

    private void handleUserInfo(Context ctx) {
        ctx.redirect("https://miro.medium.com/v2/resize:fit:4800/format:webp/1*GI-td9gs8D5OKZd19mAOqA.png");
    }

}
