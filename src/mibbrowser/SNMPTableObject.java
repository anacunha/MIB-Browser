package mibbrowser;

/**
 *
 * @author Ana Luiza Cunha
 * @author Juliana Damasio Oliveira
 * @author Rodrigo Oliveira de Freitas
 */
public class SNMPTableObject {
    
    private String tableName;
    private String tableOID;
    private SNMPObject[] tableColumns;
    
    public SNMPTableObject(String tableName, String tableOID, SNMPObject[] tableColumns) {
        this.tableName = tableName;
        this.tableOID = tableOID;
        this.tableColumns = tableColumns;
    }
    
    public String getTableName() {
        return tableName;
    }
    
    public String getTableOID() {
        return tableOID;
    }
    
    public SNMPObject[] getTableColumns() {
        return tableColumns;
    }
}
