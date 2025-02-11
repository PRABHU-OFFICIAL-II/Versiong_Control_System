package org.informatica;

import org.json.JSONObject;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Username : ");
        String username = in.next(); // ppp
        System.out.print("Enter Password : ");
        String password = in.next(); // Infa@123
        System.out.print("Enter MasterUrl : ");
        String masterURL = in.next(); // dm-us.informaticacloud.com

        JSONObject loginResponse = APIRequestHandler.login(username, password, masterURL);
        if (!loginResponse.has("icSessionId")){
            System.out.println("Login Failed :(");
            return ;
        }

        String icSessionId = SessionManager.getSessionId();
        String serverUrl = SessionManager.getServerUrl();

        Constants constants = new Constants();
        for (OperationObjectMap operationObjectMap : constants.getOperationObjectsMap()){
            System.out.println(operationObjectMap.getId() + " : " + operationObjectMap.getOperation());
        }

        System.out.print("Choose your respective Operation Id from the available options: ");
        int choice = in.nextInt();

        JSONObject response = new JSONObject();

        if (choice == 1) {
            response = APIRequestHandler.remoteRepoDetails(serverUrl, icSessionId);
            System.out.println("Remote Repo Response: " + response.toString(4));
        } else if (choice == 2){
            response = APIRequestHandler.platformOfferings(serverUrl, icSessionId);
            System.out.println("VCS Platform Offerings: " + response.toString(4));
        } else if (choice == 3){
            System.out.print("Enter your Github Repo URL: ");
            String gitUrl = in.next();
            response = APIRequestHandler.lookUpConnectionType(serverUrl, icSessionId, gitUrl);
            System.out.print("Look Up Connection Type: " + response.getString("type"));
        }
        else{
            System.out.println("Bye Bye");
        }

    }
}

