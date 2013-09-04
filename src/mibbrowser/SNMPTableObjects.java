package mibbrowser;

/**
 *
 * @author Ana Luiza Cunha
 * @author Juliana Damasio Oliveira
 * @author Rodrigo Oliveira de Freitas
 */
public class SNMPTableObjects {
    
    // sysORTable
    private static final SNMPObject sysORID = new SNMPObject("sysORId", "1.3.6.1.2.1.1.9.1.2");
    private static final SNMPObject sysORDescr = new SNMPObject("sysORDescr", "1.3.6.1.2.1.1.9.1.3");
    private static final SNMPObject sysORUpTime = new SNMPObject("sysORUpTime", "1.3.6.1.2.1.1.9.1.4");
    private static final SNMPTableObject sysORTable = new SNMPTableObject("sysORTable", "1.3.6.1.2.1.1.9", 
            new SNMPObject[]{sysORID, sysORDescr, sysORUpTime});
    
    // ifTable
    private static final SNMPObject ifDescr = new SNMPObject("ifDescr", "1.3.6.1.2.1.2.2.1.2");
    private static final SNMPObject ifType = new SNMPObject("ifType", "1.3.6.1.2.1.2.2.1.3");
    private static final SNMPObject ifMtu = new SNMPObject("ifMtu", "1.3.6.1.2.1.2.2.1.4");
    private static final SNMPObject ifSpeed = new SNMPObject("ifSpeed", "1.3.6.1.2.1.2.2.1.5");
    private static final SNMPObject ifPhysAddress = new SNMPObject("ifPhysAddress", "1.3.6.1.2.1.2.2.1.6");
    private static final SNMPObject ifAdminStatus = new SNMPObject("ifAdminStatus", "1.3.6.1.2.1.2.2.1.7");
    private static final SNMPObject ifOperStatus = new SNMPObject("ifOperStatus", "1.3.6.1.2.1.2.2.1.8");
    private static final SNMPObject ifLastChange = new SNMPObject("ifLastChange", "1.3.6.1.2.1.2.2.1.9");
    private static final SNMPObject ifInOctets = new SNMPObject("ifInOctets", "1.3.6.1.2.1.2.2.1.10");
    private static final SNMPObject ifInUcastPkts = new SNMPObject("ifInUcastPkts", "1.3.6.1.2.1.2.2.1.11");
    private static final SNMPObject ifInNUcastPkts = new SNMPObject("ifInNUcastPkts", "1.3.6.1.2.1.2.2.1.12");
    private static final SNMPObject ifInDiscard = new SNMPObject("ifInDiscards", "1.3.6.1.2.1.2.2.1.13");
    private static final SNMPObject ifInErrors = new SNMPObject("ifInErrors", "1.3.6.1.2.1.2.2.1.14");
    private static final SNMPObject ifInUnknownProtos = new SNMPObject("ifInUnknownProtos", "1.3.6.1.2.1.2.2.1.15");
    private static final SNMPObject ifOutOctets = new SNMPObject("ifOutOctets", "1.3.6.1.2.1.2.2.1.16");
    private static final SNMPObject ifOutUcastPkts = new SNMPObject("ifOutUcastPkts", "1.3.6.1.2.1.2.2.1.17");
    private static final SNMPObject ifOutNUcastPkts = new SNMPObject("ifOutNUcastPkts", "1.3.6.1.2.1.2.2.1.18");
    private static final SNMPObject ifOutDiscard = new SNMPObject("ifOutDiscards", "1.3.6.1.2.1.2.2.1.19");
    private static final SNMPObject ifOutErrors = new SNMPObject("ifOutErrors", "1.3.6.1.2.1.2.2.1.20");
    private static final SNMPObject ifOutQLen = new SNMPObject("ifOutQLen", "1.3.6.1.2.1.2.2.1.21");
    private static final SNMPObject ifSpecific = new SNMPObject("ifSpecific", "1.3.6.1.2.1.2.2.1.22");
    private static final SNMPTableObject ifTable = new SNMPTableObject("ifTable", "1.3.6.1.2.1.2.2", 
            new SNMPObject[]{ifDescr, ifType, ifMtu, ifSpeed, ifPhysAddress, ifAdminStatus, ifOperStatus,
            ifLastChange, ifInOctets, ifInUcastPkts, ifInNUcastPkts, ifInDiscard, ifInErrors, ifInUnknownProtos,
            ifOutOctets, ifOutUcastPkts, ifOutNUcastPkts, ifOutDiscard, ifOutErrors, ifOutQLen, ifSpecific});
    
    // atTable
    private static final SNMPObject atPhysAddress = new SNMPObject("atPhysAddress", "1.3.6.1.2.1.3.1.1.2");
    private static final SNMPObject atNetAddress = new SNMPObject("atNetAddress", "1.3.6.1.2.1.3.1.1.3");
    private static final SNMPTableObject atTable = new SNMPTableObject("atTable", "1.3.6.1.2.1.3.1",
            new SNMPObject[]{atPhysAddress, atNetAddress});
    
    // ipAddrTable
    private static final SNMPObject ipAdEntAddr = new SNMPObject("ipAdEntAddr", "1.3.6.1.2.1.4.20.1.1");
    private static final SNMPObject ipAdEntIfIndex = new SNMPObject("ipAdEntIfIndex ", "1.3.6.1.2.1.4.20.1.2");
    private static final SNMPObject ipAdEntNetMask = new SNMPObject("ipAdEntNetMask", "1.3.6.1.2.1.4.20.1.3");
    private static final SNMPObject ipAdEntBcastAddr = new SNMPObject("ipAdEntBcastAddr", "1.3.6.1.2.1.4.20.1.4");
    private static final SNMPObject ipAdEntReasmMaxSize = new SNMPObject("ipAdEntReasmMaxSize", "1.3.6.1.2.1.4.20.1.5");
    private static final SNMPTableObject ipAddrTable = new SNMPTableObject("ipAddrTable", "1.3.6.1.2.1.4.20",
            new SNMPObject[]{ipAdEntAddr, ipAdEntIfIndex, ipAdEntNetMask, ipAdEntBcastAddr, ipAdEntReasmMaxSize});
    
    // ipRouteTable
    private static final SNMPObject ipRouteDest = new SNMPObject("ipRouteDest", "1.3.6.1.2.1.4.21.1.1");
    private static final SNMPObject ipRouteIfIndex = new SNMPObject("ipRouteIfIndex", "1.3.6.1.2.1.4.21.1.2");
    private static final SNMPObject ipRouteMetric1 = new SNMPObject("ipRouteMetric1", "1.3.6.1.2.1.4.21.1.3");
    private static final SNMPObject ipRouteMetric2 = new SNMPObject("ipRouteMetric2", "1.3.6.1.2.1.4.21.1.4");
    private static final SNMPObject ipRouteMetric3 = new SNMPObject("ipRouteMetric3", "1.3.6.1.2.1.4.21.1.5");
    private static final SNMPObject ipRouteMetric4 = new SNMPObject("ipRouteMetric4", "1.3.6.1.2.1.4.21.1.6");
    private static final SNMPObject ipRouteNextHop = new SNMPObject("ipRouteNextHop", "1.3.6.1.2.1.4.21.1.7");
    private static final SNMPObject ipRouteType = new SNMPObject("ipRouteType", "1.3.6.1.2.1.4.21.1.8");
    private static final SNMPObject ipRouteProto = new SNMPObject("ipRouteProto", "1.3.6.1.2.1.4.21.1.9");
    private static final SNMPObject ipRouteAge = new SNMPObject("ipRouteAge", "1.3.6.1.2.1.4.21.1.10");
    private static final SNMPObject ipRouteMask = new SNMPObject("ipRouteMask", "1.3.6.1.2.1.4.21.1.11");
    private static final SNMPObject ipRouteMetric5 = new SNMPObject("ipRouteMetric5", "1.3.6.1.2.1.4.21.1.12");
    private static final SNMPObject ipRouteInfo = new SNMPObject("ipRouteInfo", "1.3.6.1.2.1.4.21.1.13");
    private static final SNMPTableObject ipRouteTable = new SNMPTableObject("ipRouteTable", "1.3.6.1.2.1.4.21",
            new SNMPObject[]{ipRouteDest, ipRouteIfIndex, ipRouteMetric1, ipRouteMetric2, ipRouteMetric3, ipRouteMetric4,
            ipRouteNextHop, ipRouteType, ipRouteProto, ipRouteAge, ipRouteMask, ipRouteMetric5, ipRouteInfo});
    
    // ipNetToMediaTable
    private static final SNMPObject ipNetToMediaIfIndex = new SNMPObject("ipNetToMediaIfIndex", "1.3.6.1.2.1.4.22.1.1");
    private static final SNMPObject ipNetToMediaPhysAddress = new SNMPObject("ipNetToMediaPhysAddress", "1.3.6.1.2.1.4.22.1.2");
    private static final SNMPObject ipNetToMediaNetAddress = new SNMPObject("ipNetToMediaNetAddress", "1.3.6.1.2.1.4.22.1.3");
    private static final SNMPObject ipNetToMediaType = new SNMPObject("ipNetToMediaType", "1.3.6.1.2.1.4.22.1.4");
    private static final SNMPTableObject ipNetToMediaTable = new SNMPTableObject("ipNetToMediaTable", "1.3.6.1.2.1.4.22",
            new SNMPObject[]{ipNetToMediaIfIndex, ipNetToMediaPhysAddress, ipNetToMediaNetAddress, ipNetToMediaType});
    
    // tpcConnTable
    private static final SNMPObject tcpConnState = new SNMPObject("tcpConnState", "1.3.6.1.2.1.6.13.1.1");
    private static final SNMPObject tcpConnLocalAddress = new SNMPObject("tcpConnLocalAddress", "1.3.6.1.2.1.6.13.1.2");
    private static final SNMPObject tcpConnLocalPort = new SNMPObject("tcpConnLocalPort", "1.3.6.1.2.1.6.13.1.3");
    private static final SNMPObject tcpConnRemAddress = new SNMPObject("tcpConnRemAddress", "1.3.6.1.2.1.6.13.1.4");
    private static final SNMPObject tcpConnRemPort = new SNMPObject("tcpConnRemPort", "1.3.6.1.2.1.6.13.1.5");
    private static final SNMPTableObject tpcConnTable = new SNMPTableObject("tpcConnTable", "1.3.6.1.2.1.6.13",
            new SNMPObject[]{tcpConnState, tcpConnLocalAddress, tcpConnLocalPort, tcpConnRemAddress, tcpConnRemPort});
    
    // udpTable
    private static final SNMPObject udpLocalAddress = new SNMPObject("udpLocalAddress", "1.3.6.1.2.1.7.5.1.1");
    private static final SNMPObject udpLocalPort = new SNMPObject("udpLocalPort", "1.3.6.1.2.1.7.5.1.2");
    private static final SNMPTableObject udpTable = new SNMPTableObject("udpTable", "1.3.6.1.2.1.7.5",
            new SNMPObject[]{udpLocalAddress, udpLocalPort});
    
    public static final SNMPTableObject[] tableObjects = 
           new SNMPTableObject[]{sysORTable,ifTable,atTable,ipAddrTable,ipRouteTable,ipNetToMediaTable,tpcConnTable,udpTable};
    
    public static boolean isTable(String OID) {
        switch(OID) {
            case "1.3.6.1.2.1.1.9":
                return true;
            case "1.3.6.1.2.1.2.2":
                return true;
            case "1.3.6.1.2.1.3.1":
                return true;
            case "1.3.6.1.2.1.4.20":
                return true;
            case "1.3.6.1.2.1.4.21":
                return true;
            case "1.3.6.1.2.1.4.22":
                return true;
            case "1.3.6.1.2.1.6.13":
                return true;
            case "1.3.6.1.2.1.7.5":
                return true;
            default:
                return false;
        }
    }
    
    public static String getColumnNameFromOID(String columnOID, String tableOID) {
        for(SNMPTableObject t : tableObjects) {
            if(t.getTableOID().equals(tableOID))
                for(SNMPObject c : t.getTableColumns())
                    if(c.getOID().equals(columnOID))
                        return c.getName();
        }
        
        return null;
    }
}
