package org.informatica;

public class SessionManager {
    private static String sessionId;
    private static String serverUrl;

    public static void setSessionId(String id) {
        sessionId = id;
    }

    public static String getSessionId() {
        return sessionId;
    }

    public static void setServerUrl(String url){
        serverUrl = url.substring(8).split("/")[0];
    }

    public static String getServerUrl(){
        return serverUrl;
    }
}
