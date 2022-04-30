package nccu;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface CalculatorHome extends EJBHome {

    public CalculatorRemote create() throws RemoteException, CreateException;
}


