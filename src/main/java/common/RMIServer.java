package common;

import common.IComplexObject;
import common.ProgressListener;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author <a href="mailto:jesse.sightler@gmail.com">Jesse Sightler</a>
 */
public interface RMIServer extends Remote
{
    List<IComplexObject> getResults() throws RemoteException;

    void addListener(ProgressListener listener) throws RemoteException;

    void doStuff() throws RemoteException;
}
