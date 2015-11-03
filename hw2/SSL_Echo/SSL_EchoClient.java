import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

public class SSL_EchoClient {
	private static final int PORT_NUM=443;

	public static void main(String[] arstring) {
		try {
			SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
			SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("192.168.0.60", PORT_NUM);
			InputStream inputstream = System.in;
			InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
			BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
			OutputStream outputstream = sslsocket.getOutputStream();
			OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
			BufferedWriter bufferedwriter = new BufferedWriter(outputstreamwriter);
			String string = null;
			System.out.println("first line: ");
			while ((string = bufferedreader.readLine()) != null) {
				bufferedwriter.write(string + '\n');
				System.out.println("Got BACK: " + string);
				System.out.println("Next line: ");
				bufferedwriter.flush();
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}	
	}
}
