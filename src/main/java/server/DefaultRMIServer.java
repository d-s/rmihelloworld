package server;

import common.ComplexObject;
import common.IComplexObject;
import common.ProgressListener;
import common.RMIServer;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:jesse.sightler@gmail.com">Jesse Sightler</a>
 */
public class DefaultRMIServer implements RMIServer
{
    private ProgressListener listener;

    public List<IComplexObject> getResults()
    {
        System.out.println("DefaultRMIServer called");
        ArrayList<IComplexObject> complexObjects = new ArrayList<IComplexObject>();
        complexObjects.add(new ComplexObject());
        complexObjects.add(new ComplexObject());
        complexObjects.add(new ComplexObject());
        complexObjects.add(new ComplexObject());
        complexObjects.add(new ComplexObject());
        complexObjects.add(new ComplexObject());
        complexObjects.add(new ComplexObject());
        return complexObjects;
    }

    public void addListener(ProgressListener listener) throws RemoteException
    {
        this.listener = listener;
    }

    public void doStuff() throws RemoteException
    {
        new Thread(() -> {
            for (int i = 0; i <= 100; i++)
            {
                try
                {
                    this.listener.statusUpdated("Current: " + i, i, i);
                }
                catch (RemoteException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
