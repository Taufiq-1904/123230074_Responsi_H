/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lab Informatika
 */
public class Shop {
    private String orang, kucing;
    private int number;
    private double day, price;
    
    public Shop(String orang, String kucing, int number, double day){
        this.orang = orang;
        this.kucing = kucing;
        this.number = number;
        this.day = day;
        this.price = price;
    }
    
    public double getPrice(){
        if (day <= 2) {
            return (day * 40000);
        } else {
        return (day * 30000) + 80000;
        }
    }
    
    public String getOrang() {return orang;}
    public String getKucing() {return kucing;}
    public int getNumber() {return number;}
    public double getDay() {return day;}
    
    public void setOrang(String orang) {this.orang = orang;}
    public void setKucing(String kucing) {this.kucing = kucing;}
    public void setNumeber(int number) {this.number = number;}
    public void setDay(double day) {this.day = day;}
    
}
