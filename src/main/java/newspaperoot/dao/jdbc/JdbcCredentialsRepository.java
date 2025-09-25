package newspaperoot.dao.jdbc;

import newspaperoot.dao.CredentialRepository;
import newspaperoot.dao.model.CredentialEntity;

import java.util.List;

public class JdbcCredentialsRepository implements CredentialRepository {
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
