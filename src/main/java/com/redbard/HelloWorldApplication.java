package com.redbard;

import com.redbard.health.TemplateHealthCheck;
import com.redbard.resources.HelloWorldResource;
import com.redbard.resources.SayingResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        final SayingResource sayingResource = new SayingResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        final HelloWorldResource helloWorldResource = new HelloWorldResource(configuration.getHelloWorld());
        
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(sayingResource);
        environment.jersey().register(helloWorldResource);
    }

}
