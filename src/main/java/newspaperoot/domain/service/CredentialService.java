package newspaperoot.domain.service;

import jakarta.inject.Inject;
import newspaperoot.dao.Basic.BasicCredentialRepository;
import newspaperoot.dao.model.CredentialEntity;
import newspaperoot.domain.model.CredentialDTO;
// llamar al repository pero tambien crea credentiadto a credential normal
public class CredentialService {
    private final BasicCredentialRepository credentialRepository;

    @Inject
    public CredentialService(BasicCredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    public boolean checkLogin(CredentialDTO credentialDTO) {
        CredentialEntity credentialEntity = credentialRepository.get(credentialDTO.getUsername());
        return credentialEntity.getPassword().equals(credentialDTO.getPassword());
    }
}
