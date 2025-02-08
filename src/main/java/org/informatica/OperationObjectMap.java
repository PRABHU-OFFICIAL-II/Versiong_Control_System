package org.informatica;

import java.util.HashMap;

public class OperationObjectMap {
    Integer id;
    String operation;

    public OperationObjectMap(Integer id, String operation){
        this.operation = operation;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
