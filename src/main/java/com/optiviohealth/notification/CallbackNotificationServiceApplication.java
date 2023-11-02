// Copyright 2023 OptivioHealth. All Rights Reserved.
package com.optiviohealth.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.optiviohealth")
public class CallbackNotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallbackNotificationServiceApplication.class, args);
    }
}