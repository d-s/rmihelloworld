package client;

import common.IComplexObject;
import common.RMIServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

/**
 * @author <a href="mailto:jesse.sightler@gmail.com">Jesse Sightler</a>
 */
public class MainClient
{
    public static void main(String[] argv) throws Exception
    {
        Registry registry = LocateRegistry.getRegistry(7874);
        String[] items = registry.list();
        for (String item : items)
        {
            System.out.println("Item: " + item);
        }

        RMIServer exported = (RMIServer) registry.lookup("RMIServer");
        List<IComplexObject> results = exported.getResults();
        for (IComplexObject result : results)
        {
            System.out.println("Result: " + result.getID() + " class: " + result.getClass().getCanonicalName());
        }

        System.out.println("-----------------------");
        exported.addListener(new ClientProgressCallback());
        exported.doStuff();
    }
}
