package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue; 
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MicroserviceTest {

    private Microservice microservice;

    @BeforeEach
    public void setUp() {
        microservice = new Microservice(
            "MyService",
            "1.0",
            "Description of the service",
            "Owner",
            "Active",
            new ArrayList<>(),
            LocalDateTime.now(),
            LocalDateTime.now(),
            "Latest commit hash",
            "https://github.com/your-username/your-git-repo"
        );
    }

    @Test
    public void testGetServiceName() {
        assertEquals("MyService", microservice.getServiceName());
    }

    @Test
    public void testGetVersion() {
        assertEquals("1.0", microservice.getVersion());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Description of the service", microservice.getDescription());
    }

    @Test
    public void testGetOwner() {
        assertEquals("Owner", microservice.getOwner());
    }

    @Test
    public void testGetStatus() {
        assertEquals("Active", microservice.getStatus());
    }

    @Test
    public void testGetDependencies() {
        List<String> dependencies = microservice.getDependencies();
        dependencies.add("DatabaseService");
        dependencies.add("AuthService");
        dependencies.add("LoggingService");
        assertEquals(3, dependencies.size());
        assertTrue(dependencies.contains("DatabaseService"));
        assertTrue(dependencies.contains("AuthService"));
        assertTrue(dependencies.contains("LoggingService"));
    }

    @Test
    public void testGetLatestCommit() {
        assertEquals("Latest commit hash", microservice.getLatestCommit());
    }

    @Test
    public void testGetGitRepoLink() {
        assertEquals("https://github.com/your-username/your-git-repo", microservice.getGitRepoLink());
    }
}
