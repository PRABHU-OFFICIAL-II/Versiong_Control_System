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

        System.out.println("Choose your respective Operation Id from the available options");
        int choice = in.nextInt();

        if (choice == 1) {
            JSONObject response = APIRequestHandler.getRemoteRepositoryDetails(serverUrl, icSessionId);
            System.out.println("Remote Repo Response: " + response.toString(4));
        } else{
            System.out.println("Bye Bye");
        }

    }
}

