package com.fimi.soul.entity;

import com.fimi.soul.drone.C2657a;
import java.util.Observable;
/* loaded from: classes.dex */
public class DroneModelBean extends Observable {
    private int ctrlType;
    private int currentFlightModel;
    private C2657a drone;
    private int flightModel;

    public DroneModelBean(C2657a c2657a) {
        this.drone = c2657a;
    }

    public int getCurrentFlightModel() {
        return this.currentFlightModel;
    }

    public int getFlightModel() {
        return this.flightModel;
    }

    public void setFlightModel(int i, int i2) {
        this.currentFlightModel = this.flightModel;
        this.ctrlType = i2;
        if ((this.flightModel == 7 || this.flightModel == 3) && ((i2 == 2 || i2 == 1) && i == 1 && !this.drone.m11320al())) {
            setChanged();
            notifyObservers();
        }
        if (this.flightModel == 2 && this.drone.m11320al() && i == 1) {
            setChanged();
            notifyObservers();
        }
        this.flightModel = i;
    }
}
