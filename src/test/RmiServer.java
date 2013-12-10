package test;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import mx4j.tools.naming.NamingService;


public class RmiServer
{
    private MBeanServer mBeanServer;
    private JMXConnectorServer connectorServer;
    private JMXServiceURL jmxUrl;
   
    public RmiServer() throws Exception{
          mBeanServer = MBeanServerFactory.createMBeanServer();
          createRmiregistry();
          CreateJMXConnector();
    }
   public static void main(String[] args) throws Exception
   {
     
       RmiServer rmiServer = new RmiServer();
       // ��һ������MBean Hello����
       rmiServer.addMbean(new Hello(), "mbean", "name", "hello");
       rmiServer.startJMXConnector();
      
       System.out.println("Server up and running");
   }
  
   public ObjectName addMbean(Object o,String domain,String key,String value) throws Exception{
          ObjectName oName = new ObjectName(domain, key, value);
          mBeanServer.registerMBean(o, oName);
          return oName;
}
  
  
   public void createRmiregistry() throws Exception{
         
          // 1.ע��NamingService MBean
          ObjectName namingName = ObjectName
                      .getInstance("naming:type=rmiregistry");
          // �������MC4J��mx4j.tools.naming.NamingService
          NamingService ns = new NamingService();
         
          mBeanServer.registerMBean(ns, namingName);
          // 2.����NamingService MBean
          mBeanServer.invoke(namingName, "start", null, null);
   }
  
  
   public void CreateJMXConnector() throws Exception{

          // 1.nammingPort,��NamingService���Port,ȱʡ��1099
          ObjectName namingName = ObjectName.getInstance("naming:type=rmiregistry");
     int namingPort = ((Integer)mBeanServer.getAttribute(namingName, "Port")).intValue();
        
          // 2. jndiPath
          String jndiPath = "/jmxconnector";
          // 3. JMXServiceURL ,Ϊ:
          // service:jmx:rmi://localhost/jndi/rmi://localhost:1099/jmxconnector
          jmxUrl = new JMXServiceURL("service:jmx:rmi://localhost/jndi/rmi://localhost:"
                                              + namingPort + jndiPath);
         
          // 4.Create and start the RMIConnectorServer
          // �м���Ϊnull�Ĳ���,�������֤��,��������û��,��Ϊnull
             connectorServer = JMXConnectorServerFactory
                                  .newJMXConnectorServer(jmxUrl, null, mBeanServer);
   }
  
   public void startJMXConnector() throws Exception{
       connectorServer.start();
   }
  
   public void stopJMXConnector() throws Exception{
       connectorServer.stop();
   }
  
}