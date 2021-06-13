package advisor;

import com.sun.net.httpserver.HttpServer;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final String REDIRECT_URI = "http://localhost:8080";
    private static final String CLIENT_ID = "a3e4f74865d14a73a404ae290820edd2";
    private static final String CLIENT_SECRET = "3c54297c79924f3e8a2b4442b689cb6c";
    private static final String NOT_VERIFIED = "Please, provide access for application.";
    private static final String ACCESS_POINT = "https://accounts.spotify.com";
    private static final String API_PATH = "https://api.spotify.com";

    private static final HttpClient CLIENT = HttpClient.newBuilder().build();

    private static final String NEW_RELEASES = "https://api.spotify.com/v1/browse/new-releases";
    private static final String FEATURED = "https://api.spotify.com/v1/browse/featured-playlists";
    private static final String CATEGORIES = "https://api.spotify.com/v1/browse/categories";
    private static final String CAT_PLAYLISTS = "https://api.spotify.com/v1/browse/categories/%s/playlists";
    private static final String EXIT = "---GOODBYE!---";


    private static boolean verified = false;
    private static String ACCESS = "";
    private static String CODE = "";
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        ACCESS = args[1];
        while (true) {
            switch (scanner.next()) {
                case "auth":
                    createHttpServerInstance();
                    HttpClient client = HttpClient.newBuilder().build();
                    System.out.println("use this link to request the access code: \n");
                    System.out.printf("%s/authorize?" + "client_id=%s" + "&redirect_uri=%s" +
                            "&response_type=code %n", ACCESS, CLIENT_ID, REDIRECT_URI);
                    System.out.println("\nwaiting for code...\nmaking http request for access_token...\nresponse:");
                    HttpRequest tokenRequest = createTokenRequest();
                    HttpResponse<String> response = client.send(tokenRequest, HttpResponse.BodyHandlers.ofString());
                    System.out.println(response.body() + "\n---SUCCESS---");
                    verified = true;
                    break;

                case "new":
                    System.out.println(verified ? NEW_RELEASES : NOT_VERIFIED);
                    break;
                case "featured":
                    System.out.println(verified ? FEATURED : NOT_VERIFIED);
                    break;
                case "categories":
                    System.out.println(verified ? CATEGORIES : NOT_VERIFIED);
                    break;
                case "playlists":
                    System.out.println(verified ? CAT_PLAYLISTS : NOT_VERIFIED);
                    break;
                case "exit":
                    System.out.println(EXIT);
                    return;
            }
        }
    }

    static void createHttpServerInstance() throws IOException {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8080), 0);
        server.start();
        server.createContext("/", exchange -> {
                    String query = exchange.getRequestURI().getQuery();
                    exchange.sendResponseHeaders(200, query.length());
                    exchange.getResponseBody().write(query.getBytes());
                    exchange.getResponseBody().close();
                    while (CODE.isBlank()) if (!CODE.equals("")) break;
                    server.stop(10);
                    if (query.contains("code")) System.out.println("Got the code. Return back to your program.");
                    else System.out.println("Authorization code not found. Try again.");
                    CODE = query.substring(5);
                }
        );
    }

    static HttpRequest createTokenRequest() {
        return HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create(String.format("%s/api/token", ACCESS)))
                .POST(HttpRequest.BodyPublishers.ofString(String.format("grant_type=authorization_code&" + "&client_id=%s" +
                        "&client_secret=%s" + "&redirect_uri=%s" + "code=%s", CODE, REDIRECT_URI, CLIENT_ID, CLIENT_SECRET)))
                .build();
    }
}