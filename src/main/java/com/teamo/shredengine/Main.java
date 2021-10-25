package com.teamo.shredengine;

import com.teamo.shredengine.application.ApplicationType;
import com.teamo.shredengine.application.builder.ApplicationBuilder;

public class Main {

    public static void main(String[] args) {
        ApplicationBuilder builder = new ApplicationBuilder();
        ApplicationType application = builder.build();
        application.run();
    }
}
