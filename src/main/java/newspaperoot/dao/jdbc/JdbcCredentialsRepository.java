package newspaperoot.dao.jdbc;

import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.common.Configuration;
import newspaperoot.dao.CredentialRepository;
import newspaperoot.dao.model.CredentialEntity;

import java.util.List;
@Data
public class JdbcCredentialsRepository  implements  CredentialRepository {
    private Configuration conf;



    @Inject
    public JdbcCredentialsRepository(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    @Override
    public List<CredentialEntity> getAll() {
        return List.of();
    }

    @Override
    public CredentialEntity get(String username) {
        return null;
    }

    @Override
    public int save(CredentialEntity credential) {
        return 0;
    }

    @Override
    public void delete(CredentialEntity credential) {

    }

    @Override
    public void update(CredentialEntity credential) {

    }
}
