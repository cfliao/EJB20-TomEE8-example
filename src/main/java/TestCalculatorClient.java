
import nccu.CalculatorHome;
import nccu.CalculatorRemote;

import java.rmi.RemoteException;
import java.util.Properties;
import javax.ejb.CreateException;
import javax.rmi.PortableRemoteObject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestCalculatorClient
{

//    @EJB
//    private static CalculatorRemote calculator;

    public static void main(String[] args) throws RemoteException, CreateException {
        Properties properties = new Properties();

        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.openejb.client.RemoteInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "http://localhost:8080/tomee/ejb");
        InitialContext ic;
        CalculatorRemote calculator = null;
        try
        {
            ic = new InitialContext(properties);
            Object ref = ic.lookup("CalculatorEJB");
            CalculatorHome calculatorHome = (CalculatorHome) PortableRemoteObject
                    .narrow(ref, CalculatorHome.class);

            calculator = calculatorHome.create();

        }
        catch (NamingException e)
        {
            e.printStackTrace();
        }

        int result = calculator.add(2, 4);
        System.out.println(result);
    }

}
