import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SSL_EchoServer {
	private static final int PORT_NUM=443;
	public static void main(String[] arstring) {
		try {
			SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
			SSLServerSocket sslserversocket = (SSLServerSocket) sslserversocketfactory.createServerSocket(PORT_NUM);
				
			System.out.println("wait connected");
				
			SSLSocket sslsocket = (SSLSocket) sslserversocket.accept();
					
			System.out.println("client IP address : " + sslsocket.getInetAddress().getHostAddress());
			InputStream inputstream = sslsocket.getInputStream();
			InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
			BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
			String string = null;
			while ((string = bufferedreader.readLine()) != null) {
				System.out.println(string);
				System.out.flush();
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
