package net.oivind.java.HueCLI.Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class HttpHandler {

    public String doGet() throws IOException {
        HttpURLConnection con = createURL("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

        return br.lines().collect(Collectors.joining("\n"));
    }

    public String doPut(String json) throws IOException {
        HttpURLConnection con = createURL("PUT");

        // Send put request
        OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
        osw.write(json);
        osw.flush();
        osw.close();

        System.out.println(con.getResponseCode());

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

        return br.lines().collect(Collectors.joining("\n"));
    }

    private HttpURLConnection createURL(String method) throws IOException {
        URL url = new URL("http://someurl");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        return connection;
    }
}
