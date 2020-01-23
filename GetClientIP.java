package Application;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.net.*; 
import java.util.*; 
import static java.lang.System. out;

/**
 *
 * @author Albertino Augusto*/

public class GetClientIP 
{

    public static void main(String[] args) 
    {
        try 
        {
            InetAddress Ip = InetAddress.getLocalHost();
            System.out.println("IP: " + Ip.getHostAddress());
            System.out.println("HostName: " + Ip.getCanonicalHostName());
            System.out.println( "-------------------------------------");
            System.out.println( "Lists all the network interfaces and thgetInfos()");
            
            
            getInfos();
            getAvailableMemory();
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

    static void getInfos() 
    {
        try
        {
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        
            for(NetworkInterface netint : Collections.list(nets)) 
            {
                displayInterfaceInformation(netint);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }  
    }

    static void displayInterfaceInformation(NetworkInterface netint) 
    {
        try
        {
            out.printf("Display name: %s\n", netint.getDisplayName());
            out.printf("Name: %s\n", netint.getName());
            byte[] mac = netint.getHardwareAddress(); // a byte array
            Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();

            for(InetAddress inetAddress : Collections.list(inetAddresses)) 
            {
                out.printf("InetAddress: %s\n", inetAddress);
            }
            out.printf("\n");
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
        
    }
    
    //    Exemplo : Méga Octets na carta grafica
        static void getAvailableMemory()
        {
            //    Exemplo : nbr de Processors
            int nbProc = Runtime.getRuntime().availableProcessors();
            System.out.println("Processors: " + nbProc); 
            
            //  graphique env
            GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            System.out.println(environment + "");
            
            // carta grafica
            GraphicsDevice device = environment.getDefaultScreenDevice();
            System.out.println(device + "");


            //  Méga Octets na carta grafica
            int bytes = device.getAvailableAcceleratedMemory();
            int mbytes = bytes / 1048576;
//            return mbytes; 
            System.out.println(mbytes + "");
        }

    //    2- Utiliza commands :  Runtime.getRuntime().exec(....)
    //        Ver exemplo de Daniel.F
    //    3- Utiliza  para as autras Informações :  JNI
}



