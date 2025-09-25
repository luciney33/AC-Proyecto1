package newspaperoot.dao.Basic;

import newspaperoot.dao.CredentialRepository;
import newspaperoot.dao.model.CredentialEntity;

import java.util.ArrayList;
import java.util.List;

//pregunta las credenciales al usuario
//y las compara con las credenciales almacenadas en la base de datos
//si son correctas, permite el acceso al sistema
//si no, muestra un mensaje de error
//y vuelve a pedir las credenciales

public class BasicCredentialRepository implements CredentialRepository {
    @Override
    public List<CredentialEntity> getAll() {
        List<CredentialEntity> credentialEntities = new ArrayList<>();
        credentialEntities.add(new CredentialEntity("luci","luci",2));
        credentialEntities.add(new CredentialEntity("root","root",1));
        return credentialEntities;
    }

    public CredentialEntity get(String username) {
        return getAll().stream().filter(credentialEntity -> credentialEntity.getUsername().equals(username)).findFirst().orElse(null);
        //Connect to the BD
        //Send the query QL ang get the answer
        //Return the answer
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
