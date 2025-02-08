package org.informatica;

import java.util.ArrayList;
import java.util.HashMap;

public class Constants {

    private final ArrayList<OperationObjectMap> operationObjectMaps = new ArrayList<>();

    public void buildMap(){
        operationObjectMaps.add(new OperationObjectMap(1, "Get the Remote Repository Details"));
        operationObjectMaps.add(new OperationObjectMap(2, "Get the Platform Offerings"));
        operationObjectMaps.add(new OperationObjectMap(3, "Get the Lookup Connection Type"));
        operationObjectMaps.add(new OperationObjectMap(4, "Get the Repository Connection"));
        operationObjectMaps.add(new OperationObjectMap(5, "Create a Repo Connection"));
        operationObjectMaps.add(new OperationObjectMap(6, "Update a Repo Connection"));
        operationObjectMaps.add(new OperationObjectMap(7, "Delete a Repo Connection"));
        operationObjectMaps.add(new OperationObjectMap(8, "Get User Credentials for Git Repo"));
        operationObjectMaps.add(new OperationObjectMap(9, "Create 3rd party VCS User Credential"));
        operationObjectMaps.add(new OperationObjectMap(10, "Check Out an Asset"));
        operationObjectMaps.add(new OperationObjectMap(11, "Undo Asset Check Out"));
        operationObjectMaps.add(new OperationObjectMap(12, "Asset Bulk Check Out"));
        operationObjectMaps.add(new OperationObjectMap(13, "Bulk Undo Asset Check Out"));
        operationObjectMaps.add(new OperationObjectMap(14, "Check In Assets"));
        operationObjectMaps.add(new OperationObjectMap(15, "Bulk Check In Assets"));
        operationObjectMaps.add(new OperationObjectMap(16, "Unlink an Asset"));
        operationObjectMaps.add(new OperationObjectMap(17, "Bulk Unlinking of Assets"));
        operationObjectMaps.add(new OperationObjectMap(18, "Pull Assets into IDMC Org"));
        operationObjectMaps.add(new OperationObjectMap(19, "Pull By Commit Hash"));
        operationObjectMaps.add(new OperationObjectMap(20, "Get Commit History for a Specific Asset")); // Get commit history by internal ID
        operationObjectMaps.add(new OperationObjectMap(21, "Retrieve Commit History for an Org"));
        operationObjectMaps.add(new OperationObjectMap(22, "Track Commit Changes for a Specific Commit Hash"));
        operationObjectMaps.add(new OperationObjectMap(23, "Get Remote Projects List"));
        operationObjectMaps.add(new OperationObjectMap(24, "Get the Count of Linked Assets connected to VCS for a Customer Org"));
        operationObjectMaps.add(new OperationObjectMap(25, "List All Repo Connections in an ORG"));
        operationObjectMaps.add(new OperationObjectMap(26, "List Projects Associated with a Repo Connection"));
    }

    public ArrayList<OperationObjectMap> getOperationObjectsMap() {
        buildMap();
        return operationObjectMaps;
    }
}
