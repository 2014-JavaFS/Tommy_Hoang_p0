package com.tommy_hoang_p0.Util.Interfaces;

import io.javalin.Javalin;

public interface Controller {
     void registerPaths(Javalin app);
}
