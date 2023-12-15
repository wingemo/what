package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MicroserviceMetadataTest {

    private MicroserviceMetadata microserviceMetadata;

    @BeforeEach
    public void setUp() {
        // Create a MicroserviceMetadata object to test
        microserviceMetadata = new MicroserviceMetadata(
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
        assertEquals("MyService", microserviceMetadata.getServiceName());
    }

    @Test
    public void testGetVersion() {
        assertEquals("1.0", microserviceMetadata.getVersion());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Description of the service", microserviceMetadata.getDescription());
    }

    @Test
    public void testGetOwner() {
        assertEquals("Owner", microserviceMetadata.getOwner());
    }

    @Test
    public void testGetStatus() {
        assertEquals("Active", microserviceMetadata.getStatus());
    }

    @Test
    public void testGetDependencies() {
        List<String> dependencies = microserviceMetadata.getDependencies();
        assertEquals(0, dependencies.size());
    }

    @Test
    public void testGetLatestCommit() {
        assertEquals("Latest commit hash", microserviceMetadata.getLatestCommit());
    }

    @Test
    public void testGetGitRepoLink() {
        assertEquals("https://github.com/your-username/your-git-repo", microserviceMetadata.getGitRepoLink());
    }
}
