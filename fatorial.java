import java.math.BigInteger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

class Backend {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        server.createContext("/fatorial", new FatHandler());
        server.createContext("/", new PageHandler());
        server.setExecutor(null);
        server.start();
    }

    static String getRequestArg(String path, String URI){
        return URI.replaceAll(path,"");
    }

    static class FatHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = getRequestArg("/fatorial/",t.getRequestURI().toString());
            System.out.println("["+getTime()+"] API called for "+response);
            int number = Integer.parseInt(response);
            response = fatorial(number).toString();
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class PageHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String page = "";
            String response = "";
            System.out.println("["+getTime()+"] Page called");
            Path pageFile = Path.of("Frontend.html");
            response = Files.readString(pageFile);
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static String getTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    static BigInteger fatorial(int n){
        BigInteger fat = BigInteger.ONE;
        if(n>1){
            for(int i=2;i<=n;i++){
                fat = fat.multiply(BigInteger.valueOf(i));
            }
        }
        return fat;
    }
}