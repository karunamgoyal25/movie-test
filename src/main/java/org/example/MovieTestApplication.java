package org.example;

import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.resources.ContactResources;
import org.jdbi.v3.core.Jdbi;


public class MovieTestApplication extends Application<MovieTestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MovieTestApplication().run(args);
    }

    @Override
    public String getName() {
        return "MovieTest";
    }

    @Override
    public void initialize(final Bootstrap<MovieTestConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final MovieTestConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataStoreFactory(),"postgresql");
        environment.jersey().register(new ContactResources(jdbi));

    }

}
