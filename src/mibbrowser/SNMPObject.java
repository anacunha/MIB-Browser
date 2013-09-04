package mibbrowser;

/**
 *
 * @author Ana Luiza Cunha
 * @author Juliana Damasio Oliveira
 * @author Rodrigo Oliveira de Freitas
 */
public class SNMPObject {
    
    private String name;
    private String OID;
    
    public SNMPObject(String name, String OID) {
        this.name = name;
        this.OID = OID;
    }
    
    public String getName() {
        return name;
    }
    
    public String getOID() {
        return OID;
    }
}
