import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Microservice{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceName;
    private String version;
    private String description;
    private String owner;
    private String status;
    private List<String> dependencies;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String latestCommit;
    private String gitRepoLink; 

    public Microservice() {
    }

    public Microservice(String serviceName, String version, String description, String owner,
                                String status, List<String> dependencies, LocalDateTime createdAt,
                                LocalDateTime updatedAt, String latestCommit, String gitRepoLink) {
        this.serviceName = serviceName;
        this.version = version;
        this.description = description;
        this.owner = owner;
        this.status = status;
        this.dependencies = dependencies;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.latestCommit = latestCommit;
        this.gitRepoLink = gitRepoLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getLatestCommit() {
        return latestCommit;
    }

    public void setLatestCommit(String latestCommit) {
        this.latestCommit = latestCommit;
    }

    public String getGitRepoLink() {
        return gitRepoLink;
    }

    public void setGitRepoLink(String gitRepoLink) {
        this.gitRepoLink = gitRepoLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MicroserviceMetadata that = (MicroserviceMetadata) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MicroserviceMetadata{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", version='" + version + '\'' +
                ", description='" + description + '\'' +
                ", owner='" + owner + '\'' +
                ", status='" + status + '\'' +
                ", dependencies=" + dependencies +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", latestCommit='" + latestCommit + '\'' +
                ", gitRepoLink='" + gitRepoLink + '\'' + // Länk till Git-repo inkluderad i toString
                '}';
    }
}
