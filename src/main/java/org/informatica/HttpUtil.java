package org.informatica;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONPropertyName;

public class HttpUtil {
    private static final HttpClient client = HttpClient.newHttpClient();

    public static JSONObject sendNativeLoginRequest(String url, JSONObject payload) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(payload.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new JSONObject(response.body());
        } catch (Exception e) {
            return new JSONObject().put("error", e.getMessage());
        }
    }

    public static JSONObject sendPostRequest(String serverUrl, String icSessionId, JSONObject payload){
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serverUrl))
                    .header("Content-Type", "application/json")
                    .header("IDS-SESSION-ID", icSessionId)
                    .POST(HttpRequest.BodyPublishers.ofString(payload.toString()))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new JSONObject(response.body());
        } catch (Exception e) {
            return new JSONObject().put("error", e.getMessage());
        }
    }

    public static JSONObject sendGetRequest(String serverUrl, String icSessionId){
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serverUrl))
                    .header("Content-Type", "application/json")
                    .header("IDS-SESSION-ID", icSessionId)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new JSONObject(response.body());
        } catch (Exception e) {
            return new JSONObject().put("error", e.getMessage());
        }
    }

}
