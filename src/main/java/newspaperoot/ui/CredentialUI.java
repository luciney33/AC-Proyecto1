package newspaperoot.ui;

import jakarta.inject.Inject;
import newspaperoot.domain.model.CredentialDTO;
import newspaperoot.domain.service.CredentialService;

public class CredentialUI {
    private final CredentialService credentialService;

    @Inject //es mas eficiente va en la clase que va unido a lo quese inicializa en el main
    public CredentialUI(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    public boolean checkLogin(CredentialDTO credentialDTO) {
        return credentialService.checkLogin(credentialDTO);
    }
}
