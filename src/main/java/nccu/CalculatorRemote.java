package nccu;
import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface CalculatorRemote extends EJBObject {

    public int add(int i,int j) throws RemoteException;

}

