package com.example.restapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextClosedEvent;
import jakarta.annotation.PreDestroy;


@SpringBootApplication
public class RestApiDemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RestApiDemoApplication.class);

        // Add a listener for when the application is ready
        app.addListeners((ApplicationListener<ApplicationReadyEvent>) event -> {
            System.out.println("✅ Application is ready!");
        });

        // Add a listener for when the application context is closed
        app.addListeners((ApplicationListener<ContextClosedEvent>) event -> {
            System.out.println("🔄 Application is shutting down...");
        });

        app.run(args);
    }

    // Gracefully handle termination signals (e.g., SIGTERM)
    @PreDestroy
    public void onShutdown() {
        System.out.println("⚠️ Cleaning up resources before shutdown...");
        // Add any resource cleanup logic here (e.g., closing database connections, stopping threads)
    }
}