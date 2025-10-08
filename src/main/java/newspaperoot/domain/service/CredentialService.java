package newspaperoot.domain.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.dao.CredentialRepository;
import newspaperoot.dao.model.CredentialEntity;
import newspaperoot.domain.model.CredentialDTO;
import org.jboss.weld.exceptions.IllegalArgumentException;

// llamar al repository pero tambien crea credentiadto a credential normal
@Data
public class CredentialService {
    private final CredentialRepository credentialRepository;

    @Inject
    public CredentialService(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    public boolean checkLogin(CredentialDTO credentialDTO) {
        CredentialEntity credentialEntity = credentialRepository.get(credentialDTO.getUsername());
        if (credentialEntity == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        return credentialEntity.getPassword().equals(credentialDTO.getPassword());
    }
}
