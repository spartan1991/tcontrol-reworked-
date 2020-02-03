package com.vcprojects.tcontrol.model;

import javax.persistence.*;

@Entity
@Table(name = "data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "device")
    private String device;
    @Column(name = "sensor1")
    private String sensor1;
    @Column(name = "sensor2")
    private String sensor2;
    @Column(name = "sensor3")
    private String sensor3;
    @Column(name = "dateTime")
    private String dateTime;

    public Data(){
    }

    public Data(int id, String device, String sensor1, String sensor2, String sensor3, String dateTime){
        this.id = id;
        this.device = device;
        this.sensor1 = sensor1;
        this.sensor2 = sensor2;
        this.sensor3 = sensor3;
        this.dateTime = dateTime;
    }

    public Data(String device, String sensor1, String sensor2, String sensor3, String dateTime){
        this.device = device;
        this.sensor1 = sensor1;
        this.sensor2 = sensor2;
        this.sensor3 = sensor3;
        this.dateTime = dateTime;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDevice(){
        return device;
    }

    public void setDevice(String device){
        this.device = device;
    }

    public String getSensor1(){
        return sensor1;
    }

    public void setSensor1(String sensor1){
        this.sensor1 = sensor1;
    }

    public String getSensor2(){
        return sensor2;
    }

    public void setSensor2(String sensor2){
        this.sensor2 = sensor2;
    }

    public String getSensor3(){
        return sensor3;
    }

    public void setSensor3(String sensor3){
        this.sensor3 = sensor3;
    }

    public String getDateTime(){
        return dateTime;
    }

    public void setDateTime(String dateTime){
        this.dateTime = dateTime;
    }

    @Override
    public String toString(){
        return "Product{" +
                "id = " + id +
                "device = " + device +
                "sensor1 = " + sensor1 +
                "sensor2 = " + sensor2 +
                "sensor3 = " + sensor3 +
                "dateTime = " + dateTime +
                '}';
    }
}
