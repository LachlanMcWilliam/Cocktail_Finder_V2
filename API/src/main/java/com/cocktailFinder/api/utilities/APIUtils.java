package com.cocktailFinder.api.utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtils {

    public static String APIKey = "";

    public static String getDrinksByIngredientURL(String ingredient){
        return formatAPIURL("https://www.thecocktaildb.com/api/json/v2/%s/filter.php?i=%s", ingredient.replace(" ", "%20"));
    }

    //synchronized as will have several threads using this processed resource at a time
    public static synchronized String getDrinkByIdURL(int cocktailId){
        return formatAPIURL("https://www.thecocktaildb.com/api/json/v2/%s/lookup.php?i=%s", Integer.toString(cocktailId));
    }

    public static String getIngredientsURL(){
        return formatAPIURL("https://www.thecocktaildb.com/api/json/v2/%s/list.php?i=list");
    }

    private static String formatAPIURL(String urlTemplate){
        return String.format(urlTemplate, APIKey);
    }

    private static String formatAPIURL(String urlTemplate, String value){
        return String.format(urlTemplate, APIKey, value);
    }

    public static void getAPIKey(){
        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://key-service:5001/cocktail_key"))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            JSONObject res = (JSONObject) new JSONParser().parse(response.body());
            APIKey = (String) res.get("key");

        } catch (ParseException e) {
            e.printStackTrace();
            APIKey = "1";
        } catch (InterruptedException e) {
            e.printStackTrace();
            APIKey = "1";
        } catch (IOException e) {
            e.printStackTrace();
            APIKey = "1";
        }
    }
}
