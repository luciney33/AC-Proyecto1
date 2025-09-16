package newspaperoot.dao;

import newspaperoot.dao.model.CredentialEntity;

//pregunta las credenciales al usuario
//y las compara con las credenciales almacenadas en la base de datos
//si son correctas, permite el acceso al sistema
//si no, muestra un mensaje de error
//y vuelve a pedir las credenciales
public class CredentialRepository {
    public CredentialEntity get(String username) {
        //Connect to the BD
        //Send the query QL ang get the answer
        //Return the answer
        return new CredentialEntity("root","root",0);
    }


}
