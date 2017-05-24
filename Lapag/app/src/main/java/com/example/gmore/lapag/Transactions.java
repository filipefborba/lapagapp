package com.example.gmore.lapag;

import java.util.Hashtable;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

/**
 * Created by gmore on 21/05/17.
 */

public class Transactions {
    private String amount;
    private String data;
    private boolean type;
    private boolean status;
    private String transfer_day;
    private String name;

    public String getAmount() {
        return amount;
    }

    public String getData(){
        return data;
    }

    public boolean getType(){
        return type;
    }

    public boolean getStatus(){
        return status;
    }

    public String getTransfer_day(){
        return transfer_day;
    }

    public String getName(){
        return name;
    }


    public void setName(String name) {
        String[] name_list = name.split(" ");
        String name_real = name_list[0] + " " + name_list[name_list.length-1];
        this.name = name_real;
    }

    public void setAmount(String amount){
        if (amount.length() == 4){
            String amount_real = "R$" + amount.charAt(0) + amount.charAt(1)  + "," + amount.charAt(2) + amount.charAt(3);
            this.amount = amount_real;
        }
        else if (amount.length() == 5){
            String amount_real = "R$" + amount.charAt(0) + amount.charAt(1) + amount.charAt(2) + "," + amount.charAt(3) + amount.charAt(4);
            this.amount = amount_real;
        }
        else if (amount.length() == 6){
            String amount_real = "R$" + amount.charAt(0) + amount.charAt(1) + amount.charAt(2) + amount.charAt(3) + "," + amount.charAt(4) + amount.charAt(5);
            this.amount = amount_real;
        }



    }

    public void setData(String data){

        this.data = data;
    }

    public void setType(String type){
        if (type.equals("Crédito")){
            this.type = true;
        }
        else{
            this.type = false;
        }
    }

    public void setStatus(String status){
        if (status.equals("Paga")){
            this.status = true;
        }
        else{
            this.status = false;
        }
    }

    public void setTransfer_day(String transfer_day){
        String[] month = {"JAN", "FEV","MAR", "ABR","MAI","JUN","JUL","AGO","SET","OUT","NOV","DEZ"};
        int iterator = 0;
        if (transfer_day.charAt(5) == 1){
            iterator = 9;
        }
        iterator+= Character.getNumericValue(transfer_day.charAt(6))-2;


        String transfer_real = "" + transfer_day.charAt(8) + transfer_day.charAt(9) + "/" + month[iterator];

        this.transfer_day = transfer_real;
    }


}
