package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author <a href="mailto:jesse.sightler@gmail.com">Jesse Sightler</a>
 */
public interface ProgressListener extends Remote
{
    void statusUpdated(String message, int current, int total) throws RemoteException;
}
