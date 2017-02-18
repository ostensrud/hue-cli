package net.oivind.java.HueCLI.Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class HttpHandler {

    public String doGet(String url) throws IOException {
        HttpURLConnection con = openConnection("GET", url);

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

        return br.lines().collect(Collectors.joining("\n"));
    }

    public String doPut(String url, String json) throws IOException {
        HttpURLConnection con = openConnection("PUT", url);


        // Send put request
        OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
        osw.write(json);
        osw.flush();
        osw.close();

        System.out.println(con.getResponseCode());

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

        return br.lines().collect(Collectors.joining("\n"));
    }

    protected HttpURLConnection openConnection(String method, String urlAsString) throws IOException {
        URL url = createURL(urlAsString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        return connection;
    }

    protected URL createURL(String urlAsString) throws MalformedURLException {
        return new URL(urlAsString);
    }
}
