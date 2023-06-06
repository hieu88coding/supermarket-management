/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hieucao.sieuthiBigK.menuController;

/**
 *
 * @author Admin
 */
public class ModelData {
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public ModelData(String month, double amount, double profit) {
        this.month = month;
        this.amount = amount;
        this.profit = profit;
    }

    public ModelData() {
    }

    private String month;
    private double amount;
    private double profit;
}
