package com.newrelic.sample.controllers;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
    Logger logger;

    @Autowired
    public LoggingController(final Logger logger) {
        this.logger = logger;
        logger.info("Logging Controller initialized");
    }

	@GetMapping("/")
	public String root() {
        logger.info("Calling root endpoint");

		return "Root of the project, available endpoints:\nhello\nerror";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        logger.info(String.format("Calling name endpoint, with name %s", name));

		return String.format("Hello %s!", name);
	}

    @GetMapping("/err")
    public String err() {
        logger.error("An Error!");

        return "I just logged some error stuff";
    }
}
