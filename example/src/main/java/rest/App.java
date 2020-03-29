package rest;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class App {

    public static final String BASE_URI = "http://0.0.0.0:8080/myapp/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("rest");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(final String[] args) throws IOException {
        final HttpServer server = startServer();
//        System.out.println(String
//                .format("Jersey app started. Available at " + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
//        System.in.read();
//        server.shutdownNow();
    }
}