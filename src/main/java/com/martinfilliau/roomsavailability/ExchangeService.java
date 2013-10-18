package com.martinfilliau.roomsavailability;

import com.yammer.dropwizard.Service;
import com.martinfilliau.roomsavailability.configuration.AppConfiguration;
import com.martinfilliau.roomsavailability.resources.RoomsAvailability;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 *
 * @author martinfilliau
 */
public class ExchangeService extends Service<AppConfiguration>{

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        bootstrap.setName("ExchangeService");
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        environment.addResource(new RoomsAvailability(configuration.getExchange()));
    }
    
    public static void main(String[] args) throws Exception {
        new ExchangeService().run(args);
    }
    
}