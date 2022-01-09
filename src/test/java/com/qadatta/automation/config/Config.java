package com.qadatta.automation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource("application.properties")
@ComponentScan("com.qadatta.automation")
public class Config {
}