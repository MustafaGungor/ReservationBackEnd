package com.mustafa.samples.reservation.web;

import com.mebitech.robe.web.WebApplication;
import com.mustafa.samples.reservation.web.cli.InitialCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by kamilbukum on 03/03/2017.
 */

@ComponentScan({"com.mustafa.samples.reservation", "com.mebitech.robe"})
@EnableJpaRepositories(basePackages = {"com.mustafa.samples.reservation.repository", "com.mebitech.robe.security.db.repository"})
@EntityScan(basePackages = {"com.mustafa.samples.reservation.domain", "com.mebitech.robe.security.db.domain", "com.mebitech.robe.log.entity"})
public class Application extends WebApplication {

    @Autowired
    InitialCommand initialCommand;

    public static void main(String[] args) {
        run(Application.class, args);
    }

    @Override
    public void init(ApplicationArguments applicationArguments) {
        initialCommand.run();
    }
}
