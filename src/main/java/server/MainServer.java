package server;

import common.RMIServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author <a href="mailto:jesse.sightler@gmail.com">Jesse Sightler</a>
 */
public class MainServer
{
    public static void main(String[] argv) throws Exception
    {
        try
        {
            RMIServer obj = new DefaultRMIServer();

            RMIServer exported = (RMIServer) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(7874);
            registry.rebind("RMIServer", exported);
            System.out.println("Registered 'RMIServer' at: " + registry);
        }
        catch (Exception e)
        {
            System.out.println("DefaultRMIServer err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
