package newspaperoot.domain.service;

import jakarta.inject.Inject;
import newspaperoot.dao.CredentialRepository;
import newspaperoot.dao.model.CredentialEntity;
import newspaperoot.domain.model.CredentialDTO;
// llamar al repository pero tambien crea credentiadto a credential normal
public class CredentialService {
    private final CredentialRepository credentialRepository;

    @Inject
    public CredentialService(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    public boolean checkLogin(CredentialDTO credentialDTO) {
        CredentialEntity credentialEntity = credentialRepository.get(credentialDTO.getUsername());
        return credentialEntity.getPassword().equals(credentialDTO.getPassword());
    }
}
