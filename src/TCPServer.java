import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServer {
	
	static String androidIp = "192.168.64.192";
	static int port = 7801;
	
	public static void main(String argv[]) throws Exception {
		
		Socket s = new Socket(androidIp, port);
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		pw.write("HELLO FROM PC");
		pw.write("HELLO FROM PC");
		pw.write("HELLO FROM PC");
		pw.write("HELLO FROM PC");
		pw.write("HELLO FROM PC");
		pw.write("HELLO FROM PC");
		pw.flush();
		pw.close();
		s.close();
		
	}
//	static Socket socket;
//	static ServerSocket ss;
//	static InputStreamReader isr;
//	static BufferedReader br;
//	static String message;
//	public static void main(String argv[]) throws Exception {
//		
//		ss = new ServerSocket(6789);
//		socket = ss.accept();
//		isr = new InputStreamReader(socket.getInputStream());
//		br = new BufferedReader(isr);
//		
//		message = br.readLine();
//		
//		System.out.println(message);
//		
//	}

}

// public static void main(String argv[]) throws Exception {
// String clientSentence;
// String capitalizedSentence;
// ServerSocket welcomeSocket = new ServerSocket(6789);
//
// while (true) {
// Socket connectionSocket = welcomeSocket.accept();
// BufferedReader inFromClient = new BufferedReader(new
// InputStreamReader(connectionSocket.getInputStream()));
// DataOutputStream outToClient = new
// DataOutputStream(connectionSocket.getOutputStream());
// clientSentence = inFromClient.readLine();
// System.out.println("Received: " + clientSentence);
// capitalizedSentence = clientSentence.toUpperCase() + 'n';
// outToClient.writeBytes(capitalizedSentence);
// }
// }