package models;

import models.enums.GateStatus;
import models.enums.GateType;

public class Gate extends BaseClass{

    private int gateNumber;
    private String Operator;

    private GateType gateType;
    private GateStatus gateStatus;

    public Gate(int gateNumber, String operator, GateType gateType, GateStatus gateStatus) {
        this.gateNumber = gateNumber;
        Operator = operator;
        this.gateType = gateType;
        this.gateStatus = gateStatus;
    }

    public Gate() {
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public String getOperator() {
        return Operator;
    }

    public void setOperator(String operator) {
        Operator = operator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
