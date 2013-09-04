package mibbrowser;

import java.util.ArrayList;

/**
 *
 * @author Ana Luiza Cunha
 * @author Juliana Damasio Oliveira
 * @author Rodrigo Oliveira de Freitas
 */
public class SNMPController {
    
    private String comunidade;
    private String ip;

    public Object[] get(String objeto) throws Exception {
        String resultado = SNMPManager.get(ip, comunidade, objeto);
        if(resultado.isEmpty())
            return null;
        return new Object[]{"GET", objeto + " = " + resultado};
    }
    
    public Object[] getNext(String objeto) throws Exception {
        String resultado = SNMPManager.getNext(ip, comunidade, objeto);
        return new Object[]{"GETNEXT", resultado};   
    }
    
    public Object[][] getBulk(String objeto, int nonRepeaters, int maxRepetitions) throws Exception {
        ArrayList<String> resultado = SNMPManager.getBulk(ip, comunidade, objeto, nonRepeaters, maxRepetitions);
        
        Object[][] retorno = new Object[resultado.size()][2];
        retorno[0][0] = "GETBULK";
        for(int i = 0; i < resultado.size(); i++)
            retorno[i][1] = resultado.get(i);
        
        return retorno;
    }
    
    public Object[] set(String objeto, String valor, String tipoObjeto) throws Exception {
        String resultado = SNMPManager.set(ip, comunidade, objeto, valor, tipoObjeto);
        return new Object[]{"SET", resultado};
    }
    
    public Object[][] walk(String objeto) throws Exception {
        ArrayList<String> resultado = SNMPManager.walk(ip, comunidade, objeto);
        
        Object[][] retorno = new Object[resultado.size()][2];
        retorno[0][0] = "WALK";
        for(int i = 0; i < resultado.size(); i++)
            retorno[i][1] = resultado.get(i);
        
        return retorno;
    }
    
    public String[][] getTable(String objeto) throws Exception {
        return SNMPManager.getTable(ip, comunidade, objeto);
    }
    
    public String[] getDelta(String objeto, String valorAnterior) throws Exception {
        return SNMPManager.getDelta(ip, comunidade, objeto, valorAnterior);
    }
    
    public String getComunidade() {
        return comunidade;
    }

    public void setComunidade(String comunidade) {
        this.comunidade = comunidade;
    }
    
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public String getTipoVariavel(String object) throws Exception {
        return SNMPManager.getTipoVariavel(ip, comunidade, object);
    }
}
