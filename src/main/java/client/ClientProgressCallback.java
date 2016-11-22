package client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

import common.ProgressListener;

/**
 * @author <a href="mailto:jesse.sightler@gmail.com">Jesse Sightler</a>
 */
public class ClientProgressCallback extends UnicastRemoteObject implements ProgressListener, Remote
{
    public ClientProgressCallback() throws RemoteException
    {
    }

    public ClientProgressCallback(int port) throws RemoteException
    {
        super(port);
    }

    public ClientProgressCallback(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException
    {
        super(port, csf, ssf);
    }

    @Override
    public void statusUpdated(String message, int current, int total)
    {
        System.out.println("Status: " + message + " " + current + "/" + total);
    }
}
