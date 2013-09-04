package mibbrowser;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.commons.lang3.StringUtils;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.Counter64;
import org.snmp4j.smi.Gauge32;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.TimeTicks;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

/**
 *
 * @author Ana Luiza Cunha
 * @author Juliana Damasio Oliveira
 * @author Rodrigo Oliveira de Freitas
 */
public class SNMPManager {
    
    // Protocolo SNMP usa a porta 161 ou 162 (trap)
    private static String porta = "161";
    
    public static String get(String ip, String comunidade, String objeto) throws Exception {
        System.out.println("\nSNMP Get");
        System.out.println("Objeto: " + objeto);
        System.out.println("Comunidade: " + comunidade);

        // Inicia sessaso SNMP
        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();
        
        // Configura o endereco
        Address endereco = new UdpAddress(ip + "/" + porta);
        
        // Configura target
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(comunidade));
        target.setAddress(endereco);
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
        
        // Cria PDU (SNMP Protocol Data Unit)
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(objeto)));
        pdu.setType(PDU.GET);
        
        // Envia PDU
        ResponseEvent responseEvent = snmp.send(pdu, target);
        
        String resultado = "";
        if(responseEvent != null) {
            // Extrai a resposta PDU (pode ser null se ocorreu timeout)
            PDU responsePDU = responseEvent.getResponse();
            
            if(responsePDU != null) {
                int errorStatus = responsePDU.getErrorStatus();
	        int errorIndex = responsePDU.getErrorIndex();
	        String errorStatusText = responsePDU.getErrorStatusText();

	        if (errorStatus == PDU.noError) {
                    Vector <VariableBinding> tmpv = (Vector <VariableBinding>) responsePDU.getVariableBindings();
                    if(tmpv != null) {
                        for(int k=0; k <tmpv.size();k++) {
                            VariableBinding vb = (VariableBinding) tmpv.get(k);
                            if (vb.isException()) {
                                String errorString = vb.getVariable().getSyntaxString();
                                System.out.println("Error:"+errorString);
                                if(errorString.equals("NoSuchObject"))
                                    throw new NoSuchObjectException("No Such Object: " + objeto);
                                if(errorString.equals("NoSuchInstance"))
                                    throw new NoSuchInstanceException("No Such Instance: " + objeto);
                            }
                            else {
                                Variable var = vb.getVariable();
                                OctetString oct = new OctetString(var.toString());
                                String sVar =  oct.toString();

                                resultado = sVar;
                                System.out.println(resultado);
                            }
                        }
                    }
	        }
                else {
                    System.out.println("Erro: GET Request Falhou");
	            System.out.println("Status do Erro = " + errorStatus);
	            System.out.println("Index do Erro = " + errorIndex);
	            System.out.println(errorStatusText);
                }
            }
            else {
                System.out.println("Resultado vazio");
                throw new NullPointerException("Null Response");
            }
        }
        else {
            throw new RuntimeException("GET Request Timed Out");
        }

        snmp.close();
        return resultado;
    }
    
    public static String getNext(String ip, String comunidade, String objeto) throws IOException {
        System.out.println("\nSNMP Get-Next");
        System.out.println("Objeto: " + objeto);
        System.out.println("Comunidade: " + comunidade);

        // Inicia sessaso SNMP
        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();
        
        // Configura o endereco
        Address endereco = new UdpAddress(ip + "/" + porta);
        
        // Configura target
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(comunidade));
        target.setAddress(endereco);
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
        
        // Cria PDU (SNMP Protocol Data Unit)
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(objeto)));
        pdu.setType(PDU.GETNEXT);
        
        // Envia PDU
        ResponseEvent responseEvent = snmp.send(pdu, target);
        
        String resultado = "";
        if(responseEvent != null) {
            // Extrai a resposta PDU (pode ser null se ocorreu timeout)
            PDU responsePDU = responseEvent.getResponse();
            
            if(responsePDU != null) {
                int errorStatus = responsePDU.getErrorStatus();
	        int errorIndex = responsePDU.getErrorIndex();
	        String errorStatusText = responsePDU.getErrorStatusText();

	        if (errorStatus == PDU.noError) {
	          resultado = responsePDU.getVariableBindings().toString();
                  System.out.println(resultado);
	        }
                else {
                    System.out.println("Erro: GET-NEXT Request Falhou");
	            System.out.println("Status do Erro = " + errorStatus);
	            System.out.println("Index do Erro = " + errorIndex);
	            System.out.println(errorStatusText);
                }
            }
            else {
                System.out.println("Resultado vazio");
                throw new NullPointerException("Null Response");
            }
        }
        else {
            throw new RuntimeException("GET-NEXT Request Timed Out");
        }

        snmp.close();
        return resultado.substring(1, resultado.length() - 1);
    }
    
    public static ArrayList<String> getBulk(String ip, String comunidade, String objeto, int nonRepeaters, int maxRepetitions) throws IOException {
        System.out.println("\nSNMP Get-Bulk");
        System.out.println("Objeto: " + objeto);
        System.out.println("Comunidade: " + comunidade);

        // Inicia sessaso SNMP
        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();
        
        // Configura o endereco
        Address endereco = new UdpAddress(ip + "/" + porta);
        
        // Configura target
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(comunidade));
        target.setAddress(endereco);
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
        
        // Cria PDU (SNMP Protocol Data Unit)
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(objeto)));
        pdu.setType(PDU.GETBULK);
        pdu.setNonRepeaters(nonRepeaters);
        pdu.setMaxRepetitions(maxRepetitions);
        
        // Envia PDU
        ResponseEvent responseEvent = snmp.send(pdu, target);
        
        String resultado = "";
        if(responseEvent != null) {
            // Extrai a resposta PDU (pode ser null se ocorreu timeout)
            PDU responsePDU = responseEvent.getResponse();
            
            if(responsePDU != null) {
                int errorStatus = responsePDU.getErrorStatus();
	        int errorIndex = responsePDU.getErrorIndex();
	        String errorStatusText = responsePDU.getErrorStatusText();

	        if (errorStatus == PDU.noError) {
                    resultado = responsePDU.getVariableBindings().toString();
                    System.out.println(resultado);
                }
                else {
                    System.out.println("Erro: GET-BULK Request Falhou");
	            System.out.println("Status do Erro = " + errorStatus);
	            System.out.println("Index do Erro = " + errorIndex);
	            System.out.println(errorStatusText);
                }
            }
            else {
                System.out.println("Resultado vazio");
                throw new NullPointerException("Null Response");
            }
        }
        else {
            throw new RuntimeException("GET-BULK Request Timed Out");
        }

        snmp.close();
        ArrayList<String> retorno = new ArrayList<String>();
        
        resultado = resultado.substring(1, resultado.length() - 1);
        StringTokenizer st1 = new StringTokenizer(resultado, ",");
        while(st1.hasMoreElements()) {
            String elemento = st1.nextElement().toString();
            if(elemento.charAt(0) == ' ')
                elemento = elemento.substring(1);
            System.out.println(elemento);
            retorno.add(elemento);
        }
        return retorno;
    }
    
    public static String set(String ip, String comunidade, String objeto, String valor, String tipoObjeto) throws IOException, SetRequestException, NoSuchObjectException, NoSuchInstanceException, WrongObjectTypeException {
        System.out.println("\nSNMP Set");
        System.out.println("Objeto: " + objeto);
        System.out.println("Comunidade: " + comunidade);

        // Inicia sessaso SNMP
        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();
        
        // Configura o endereco
        Address endereco = new UdpAddress(ip + "/" + porta);
        
        // Configura target
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(comunidade));
        target.setAddress(endereco);
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
        
        // Cria PDU (SNMP Protocol Data Unit)
        PDU pdu = new PDU();
        pdu.setType(PDU.SET);
        String tipoVariavel = getTipoVariavel(ip, comunidade, objeto);
        if(!tipoVariavel.equalsIgnoreCase(tipoObjeto))
            throw new WrongObjectTypeException("Objeto do tipo " + tipoVariavel + " (Incompatível com " + tipoObjeto + ")");
        switch(tipoObjeto) {
            case "Counter":
                try {
                    long v = Long.parseLong(valor);
                    pdu.add(new VariableBinding(new OID(objeto), new Counter64(v)));
                } catch (NumberFormatException e) {
                    //TODO: Lancar e tratar excecao na GUI
                }
                break;
            case "Gauge32":
                try {
                    long v = Long.parseLong(valor);
                    pdu.add(new VariableBinding(new OID(objeto), new Gauge32(v)));
                } catch (NumberFormatException e) {
                    //TODO: Lancar e tratar excecao na GUI
                }
                break;
            case "Integer32":
                try {
                    int v = Integer.parseInt(valor);
                    pdu.add(new VariableBinding(new OID(objeto), new Integer32(v)));
                } catch (NumberFormatException e) {
                    //TODO: Lancar e tratar excecao na GUI
                }
                break;
            case "IpAddress":
                pdu.add(new VariableBinding(new OID(objeto), new IpAddress(valor)));
                break;
            case "Octet String":
                pdu.add(new VariableBinding(new OID(objeto), new OctetString(valor)));
                break;
            case "TimeTicks":
                try {
                    long v = Long.parseLong(valor);
                    pdu.add(new VariableBinding(new OID(objeto), new TimeTicks(v)));
                } catch (NumberFormatException e) {
                    //TODO: Lancar e tratar excecao na GUI
                }
                break;
        }
        
        // Envia PDU
        ResponseEvent responseEvent = snmp.send(pdu, target);
        
        String resultado = "";
        if(responseEvent != null) {
            // Extrai a resposta PDU (pode ser null se ocorreu timeout)
            PDU responsePDU = responseEvent.getResponse();
            
            if(responsePDU != null) {
                int errorStatus = responsePDU.getErrorStatus();
	        int errorIndex = responsePDU.getErrorIndex();
	        String errorStatusText = responsePDU.getErrorStatusText();

	        if (errorStatus == PDU.noError) {
	          resultado = responsePDU.getVariableBindings().toString();
                  System.out.println(resultado);
	        }
                else {
                    System.out.println("Erro: SET Request Falhou");
	            System.out.println("Status do Erro = " + errorStatus);
	            System.out.println("Index do Erro = " + errorIndex);
	            System.out.println(errorStatusText);
                    throw new SetRequestException("SET Request Failed: " + errorStatusText);
                }
            }
        }
        else {
            throw new RuntimeException("SET Request Timed Out");
        }

        snmp.close();
        return resultado.substring(1, resultado.length() - 1);
    }
    
    /**
     * Implementa o funcionamento do comando snmpwalk, realizando,
     * a partir de um objeto selecionado, diversas requisições GETNEXT 
     * até que retorne um objeto que "saia" da sub-árvore indicada;
     */
    public static ArrayList<String> walk(String ip, String comunidade, String objeto) throws IOException {
        System.out.println("\nSNMP Walk");
        System.out.println("Objeto: " + objeto);
        System.out.println("Comunidade: " + comunidade);

        // Inicia sessaso SNMP
        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();
        
        // Configura o endereco
        Address endereco = new UdpAddress(ip + "/" + porta);
        
        // Configura target
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(comunidade));
        target.setAddress(endereco);
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
        
        // Armazena OID atual para saber quando finalizar comando WALK
        String oidAtual = objeto;
        
        ArrayList<String> retorno = new ArrayList<String>();
        
        // Termina as requisicoes quando o proximo objeto 
        // nao pertencer a sub-arvore do objeto inicial
        while(oidAtual.contains(objeto)) {
            // Cria PDU (SNMP Protocol Data Unit)
            PDU pdu = new PDU();
            pdu.add(new VariableBinding(new OID(oidAtual)));
            pdu.setType(PDU.GETNEXT);

            // Envia PDU
            ResponseEvent responseEvent = snmp.send(pdu, target);
            
            if(responseEvent != null) {
                // Extrai a resposta PDU (pode ser null se ocorreu timeout)
                PDU responsePDU = responseEvent.getResponse();

                if(responsePDU != null) {
                    int errorStatus = responsePDU.getErrorStatus();
                    int errorIndex = responsePDU.getErrorIndex();
                    String errorStatusText = responsePDU.getErrorStatusText();

                    if (errorStatus == PDU.noError) {          
                        Vector <VariableBinding> tmpv = (Vector <VariableBinding>) responsePDU.getVariableBindings();
                        if(tmpv != null) {
                            for(int k=0; k <tmpv.size();k++) {
                                VariableBinding vb = (VariableBinding) tmpv.get(k);
                                if (vb.isException()) {
                                    String errorstring = vb.getVariable().getSyntaxString();
                                    System.out.println("Error:"+errorstring);
                                    return retorno;
                                }
                                else {
                                    //System.out.println("Tipo do Objeto: " + vb.getVariable().getSyntaxString());
                                    oidAtual = vb.getOid().toString();
                                    
                                    // Termina as requisicoes quando saimos da sub-arvore do objeto inicial
                                    if(!oidAtual.contains(objeto))
                                        break;
                                    
                                    Variable var = vb.getVariable();
                                    OctetString oct = new OctetString(var.toString());
                                    String sVar =  oct.toString();
                                    //System.out.println(oidAtual + " = " + sVar);
                                    retorno.add(oidAtual + " = " + sVar);
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("Erro: WALK Request Falhou");
                        System.out.println("Status do Erro = " + errorStatus);
                        System.out.println("Index do Erro = " + errorIndex);
                        System.out.println(errorStatusText);
                    }
                }
                else {
                    System.out.println("Resultado vazio");
                    throw new NullPointerException("Null Response");
                }
            }
            else {
                throw new RuntimeException("WALK Request Timed Out");
            }
        }

        snmp.close();
        for(String s : retorno)
            System.out.println(s);
        return retorno;
    }
    
    public static String[] getDelta(String ip, String comunidade, String objeto, String valorAnterior) throws IOException {
        System.out.println("\nSNMP Get Delta");
        System.out.println("Objeto: " + objeto);
        System.out.println("Comunidade: " + comunidade);

        // Inicia sessaso SNMP
        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();
        
        // Configura o endereco
        Address endereco = new UdpAddress(ip + "/" + porta);
        
        // Configura target
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(comunidade));
        target.setAddress(endereco);
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
        
        // Cria PDU (SNMP Protocol Data Unit)
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(objeto)));
        pdu.setType(PDU.GET);
        
        // Envia PDU
        ResponseEvent responseEvent = snmp.send(pdu, target);
        
        String resultado = "";
        if(responseEvent != null) {
            // Extrai a resposta PDU (pode ser null se ocorreu timeout)
            PDU responsePDU = responseEvent.getResponse();
            
            if(responsePDU != null) {
                int errorStatus = responsePDU.getErrorStatus();
	        int errorIndex = responsePDU.getErrorIndex();
	        String errorStatusText = responsePDU.getErrorStatusText();

	        if (errorStatus == PDU.noError) {
                    Vector <VariableBinding> tmpv = (Vector <VariableBinding>) responsePDU.getVariableBindings();
                    if(tmpv != null) {
                        for(int k=0; k <tmpv.size();k++) {
                            VariableBinding vb = (VariableBinding) tmpv.get(k);
                            if (vb.isException()) {
                                String errorstring = vb.getVariable().getSyntaxString();
                                System.out.println("Error:"+errorstring);
                            }
                            else {
                                Variable var = vb.getVariable();
                                OctetString oct = new OctetString(var.toString());
                                String sVar =  oct.toString();

                                resultado = sVar;
                            }
                        }
                    }
	        }
                else {
                    System.out.println("Erro: GET Request Falhou");
	            System.out.println("Status do Erro = " + errorStatus);
	            System.out.println("Index do Erro = " + errorIndex);
	            System.out.println(errorStatusText);
                }
            }
            else {
                System.out.println("Resultado vazio");
                throw new NullPointerException("Null Response");
            }
        }
        else {
            throw new RuntimeException("GET Request Timed Out");
        }

        snmp.close();
        int anterior = Integer.parseInt(valorAnterior);
        int atual = Integer.parseInt(resultado);
        int delta = atual - anterior;
        
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        return new String[]{"" + df.format(new GregorianCalendar().getTime()), valorAnterior, resultado, String.valueOf(delta)};
    }
    
    public static String getTipoVariavel (String ip, String comunidade, String objeto) throws IOException, NoSuchObjectException, NoSuchInstanceException {
        // Inicia sessaso SNMP
        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();
        
        // Configura o endereco
        Address endereco = new UdpAddress(ip + "/" + porta);
        
        // Configura target
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(comunidade));
        target.setAddress(endereco);
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
        
        // Cria PDU (SNMP Protocol Data Unit)
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(objeto)));
        pdu.setType(PDU.GET);
        
        // Envia PDU
        ResponseEvent responseEvent = snmp.send(pdu, target);
        
        if(responseEvent != null) {
            // Extrai a resposta PDU (pode ser null se ocorreu timeout)
            PDU responsePDU = responseEvent.getResponse();
            
            if(responsePDU != null) {
                int errorStatus = responsePDU.getErrorStatus();
	        int errorIndex = responsePDU.getErrorIndex();
	        String errorStatusText = responsePDU.getErrorStatusText();

	        if (errorStatus == PDU.noError) {
                    Vector <VariableBinding> tmpv = (Vector <VariableBinding>) responsePDU.getVariableBindings();
                    if(tmpv != null) {
                        for(int k=0; k <tmpv.size();k++) {
                            VariableBinding vb = (VariableBinding) tmpv.get(k);
                            if (vb.isException()) {
                                String errorString = vb.getVariable().getSyntaxString();
                                System.out.println("Error:"+errorString);
                                if(errorString.equals("NoSuchObject"))
                                    throw new NoSuchObjectException("No Such Object: " + objeto);
                                if(errorString.equals("NoSuchInstance"))
                                    throw new NoSuchInstanceException("No Such Instance: " + objeto);
                            }
                            else {
                                Variable var = vb.getVariable();
                                OctetString oct = new OctetString(var.toString());
                                String sVar =  oct.toString();
                                
                                snmp.close();
                                return vb.getVariable().getSyntaxString();
                            }
                        }
                    }
	        }
                else {
                    System.out.println("Erro: GET Request Falhou");
	            System.out.println("Status do Erro = " + errorStatus);
	            System.out.println("Index do Erro = " + errorIndex);
	            System.out.println(errorStatusText);
                }
            }
            else {
                System.out.println("Resultado vazio");
                throw new NullPointerException("Null Response");
            }
        }
        else {
            throw new RuntimeException("GET Request Timed Out");
        }
        
        return "";
    }
    
    public static String[][] getTable(String ip, String comunidade, String objeto) throws IOException, NotTableObjectException {
        System.out.println("\nSNMP Get-Table");
        System.out.println("Objeto: " + objeto);
        System.out.println("Comunidade: " + comunidade);

        // Verifica se objeto é tabela
        if(!SNMPTableObjects.isTable(objeto))
            throw new NotTableObjectException("Object " + objeto + " is not a table object");
        
        // Inicia sessaso SNMP
        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();
        
        // Configura o endereco
        Address endereco = new UdpAddress(ip + "/" + porta);
        
        // Configura target
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(comunidade));
        target.setAddress(endereco);
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
        
        // Armazena OID atual para saber quando finalizar comando WALK
        String oidAtual = objeto;
        
        // Armazena o OID anterior
        String oidAnterior = "";
        
        // Armazena a coluna atual
        String coluna = "";
        
        int sizeColuna = objeto.length() + 4;
        int pontos = StringUtils.countMatches(objeto, ".") + 2;
        
        ArrayList<String> resultado = new ArrayList<String>();
        ArrayList<String> colunas = new ArrayList<String>();
        
        // Termina as requisicoes quando o proximo objeto 
        // nao pertencer a sub-arvore do objeto inicial
        while(oidAtual.contains(objeto)) {
            
            // Cria PDU (SNMP Protocol Data Unit)
            PDU pdu = new PDU();
            pdu.add(new VariableBinding(new OID(oidAtual)));
            pdu.setType(PDU.GETNEXT);

            // Envia PDU
            ResponseEvent responseEvent = snmp.send(pdu, target);
            
            if(responseEvent != null) {
                // Extrai a resposta PDU (pode ser null se ocorreu timeout)
                PDU responsePDU = responseEvent.getResponse();

                if(responsePDU != null) {
                    int errorStatus = responsePDU.getErrorStatus();
                    int errorIndex = responsePDU.getErrorIndex();
                    String errorStatusText = responsePDU.getErrorStatusText();

                    if (errorStatus == PDU.noError) {          
                        Vector <VariableBinding> tmpv = (Vector <VariableBinding>) responsePDU.getVariableBindings();
                        if(tmpv != null) {
                            for(int k=0; k <tmpv.size();k++) {
                                VariableBinding vb = (VariableBinding) tmpv.get(k);
                                if (vb.isException()) {
                                    String errorstring = vb.getVariable().getSyntaxString();
                                    System.out.println("Error:"+errorstring);
                                }
                                else {
                                    if(!oidAtual.equals(objeto)) {
                                        String colunaAnterior = coluna;
                                        coluna = StringUtils.getCommonPrefix(oidAnterior, oidAtual);
                                        coluna = StringUtils.substringBeforeLast(coluna, ".");
                                        if(coluna.length() > sizeColuna + 1)
                                            coluna = coluna.substring(0, sizeColuna);
                                        if((colunaAnterior.contains(coluna) && !colunaAnterior.equals(coluna)) || (coluna.length() != sizeColuna && StringUtils.countMatches(coluna, ".") != pontos)) {
                                        }
                                        else {
                                            if(!coluna.isEmpty() && !colunas.contains(coluna))
                                                colunas.add(coluna);
                                        }
                                        oidAnterior = oidAtual;
                                    }
                                    
                                    //System.out.println("\nOID Anterior: " + oidAnterior);
                                    oidAtual = vb.getOid().toString();
                                    //System.out.println("OID Atual: " + oidAtual);
                                    
                                    // Termina as requisicoes quando saimos da sub-arvore do objeto inicial
                                    if(!oidAtual.contains(objeto))
                                        break;
                                    
                                    Variable var = vb.getVariable();
                                    OctetString oct = new OctetString(var.toString());
                                    String sVar =  oct.toString();
                                    resultado.add(sVar);
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("Erro: GET-TABLE Request Falhou");
                        System.out.println("Status do Erro = " + errorStatus);
                        System.out.println("Index do Erro = " + errorIndex);
                        System.out.println(errorStatusText);
                    }
                }
                else {
                    System.out.println("Resultado vazio");
                    throw new NullPointerException("Null Response");
                }
            }
            else {
                throw new RuntimeException("GET-TABLE Request Timed Out");
            }
        }

        snmp.close();
        
        int count = 0;
        int numColunas = colunas.size();
        int numLinhas = (resultado.size() / numColunas) + 1;
        String[][] retorno = new String[numLinhas][numColunas];
        
        for(int i = 0; i < numColunas; i++) {
            retorno[0][i] = SNMPTableObjects.getColumnNameFromOID(colunas.get(i), objeto);
            if(retorno[0][i] == null)
                retorno[0][i] = colunas.get(i);
            
            for(int j = 0; j < numLinhas - 1; j++) {
                retorno[j+1][i] = resultado.get(count);
                count++;
            }
        }
        for(int k = 0; k < retorno.length; k++)
            System.out.println(Arrays.toString(retorno[k]));
        
        return retorno;
    }
}
