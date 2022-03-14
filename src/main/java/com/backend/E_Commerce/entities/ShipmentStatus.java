package com.backend.E_Commerce.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShipmentStatus {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer stausId;

    private String statusName;
    private String trackingUrl;

    ShipmentStatus(){}

    ShipmentStatus(String statusName, String trackingUrl){
        this.statusName = statusName;
        this.trackingUrl = trackingUrl;
    }

    public Integer getStausId() {
        return stausId;
    }
    public String getStatusName() {
        return statusName;
    }
    public String getTrackingUrl() {
        return trackingUrl;
    }

    public void setStausId(Integer stausId) {
        this.stausId = stausId;
    }
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }
}
