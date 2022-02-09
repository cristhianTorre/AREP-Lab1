package edu.escuelaing.arem;

import spark.Request;
import spark.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.annotation.Target;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws IOException {
        port(getPort());
        init();
        get("/calculate", "application/json", (req, res) -> temperatureConverter(req,res));
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    static double temperatureConverter(Request request, Response response){
        String identifier = request.queryParams("degrees");
        System.out.println("identifier"+identifier);
        double ans = ((Double.parseDouble(identifier))*1.8)+32;
        return ans;
    }


}
