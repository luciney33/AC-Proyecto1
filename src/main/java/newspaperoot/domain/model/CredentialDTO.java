package newspaperoot.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //porque asi llamamos desde otras clases el constructor
public class CredentialDTO {
    private String username;
    private String password;

}
