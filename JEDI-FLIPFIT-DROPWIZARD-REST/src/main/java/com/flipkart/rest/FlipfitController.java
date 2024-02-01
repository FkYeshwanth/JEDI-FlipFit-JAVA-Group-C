package com.flipkart.rest;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class FlipfitController extends Application<FlipfitControllerConfiguration> {
    public static void main(String[] args) throws Exception {
        new FlipfitController().run(args);
    }
    @Override
    public void run(FlipfitControllerConfiguration flipfitControllerConfiguration, Environment environment) throws Exception {
        environment.jersey().register(GymUserFlipfitCustomer.class);
        environment.jersey().register(GymAdminFlipfitController.class);
        environment.jersey().register(GymCustomerFlipfitController.class);
        environment.jersey().register(GymOwnerFlipfitController.class);
    }


}
