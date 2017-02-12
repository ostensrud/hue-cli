package net.oivind.java.HueCLI.Net;

import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class HttpHandlerTest {

    private HttpHandler httph = new HttpHandler();

    @Test(expected = MalformedURLException.class)
    public void should_throw_exception_on_invalid_url() throws IOException {
        httph.createURL("htt://www.oivind.net");
    }

    @Test
    public void should_not_throw_exception_on_valid_url() throws Exception {
        httph.createURL("http://www.oivind.net");
    }
}