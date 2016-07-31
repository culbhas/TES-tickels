package com.tes.tickles.client.data;

import java.util.ArrayList;
import java.util.List;


public class Data {
    private String value;
    private List<String> keyParts;

    public String getValue() {
        return value;
    }

    public void addKeyPart(String keyPart){
        if(keyParts == null){
            keyParts = new ArrayList<String>();
        }
        keyParts.add(keyPart);
    }
    public void setValue(String value) {
        this.value = value;
    }
    public List<String> getKeyParts() {
        return keyParts;
    }
    public void setKeyParts(List<String> keyParts) {
        this.keyParts = keyParts;
    }

    public String getKey(){
     StringBuffer key = new StringBuffer("");
         for (String keyPart : keyParts){
             if(!key.toString().equals("")){
                 key.append("#");
             }
             key.append(keyPart);
         }
     return key.toString();
    }

    @Override
    public String toString() {
        return "{\"key\" : \"" + getKey() + ", \"value\":\"" + getValue() + "\"}";
    }
}
