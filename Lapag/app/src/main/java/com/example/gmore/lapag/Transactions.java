package com.example.gmore.lapag;

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
        this.name = name;
    }

    public void setAmount(String amount){
        int anInt = Integer.parseInt(amount);
        int anInt_right = anInt/100;
        this.amount = String.valueOf(anInt_right);
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
        this.transfer_day = transfer_day;
    }


}
