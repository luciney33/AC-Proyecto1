package newspaperoot.dao;

import newspaperoot.dao.model.CredentialEntity;

import java.util.List;

public interface CredentialRepository {
    List<CredentialEntity> getAll();
    CredentialEntity get(String username);
    int save(CredentialEntity credential);
    void delete(CredentialEntity credential);
    void update(CredentialEntity credential);
}
