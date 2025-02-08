package org.informatica;

import org.json.JSONObject;

public class APIRequestHandler {

    public static JSONObject login(String username, String password, String masterURL) {
        String callUrl = "https://" + masterURL + "/ma/api/v2/user/login";

        JSONObject jsonPayload = new JSONObject();
        jsonPayload.put("username", username);
        jsonPayload.put("password", password);

        JSONObject response = HttpUtil.sendNativeLoginRequest(callUrl, jsonPayload);

        if (response.has("icSessionId") && response.has("serverUrl")) {
            String sessionId = response.getString("icSessionId");
            String serverUrl = response.getString("serverUrl");
            SessionManager.setSessionId(sessionId);
            SessionManager.setServerUrl(serverUrl);
        } else {
            System.out.println("Login failed: " + response.toString(4));
        }

        return response;
    }

    public static JSONObject getRemoteRepositoryDetails(String serverUrl, String icSessionId){
        String callUrl = "https://" + serverUrl + "/vcs/api/v1/remoteRepo/details";

        JSONObject response = HttpUtil.getRemoteRepoDetails(callUrl, icSessionId);

        if (response == null){
            System.out.println("Failed to retrieve the Remote Repository details");
            return new JSONObject();
        }
        return response;
    }
}
