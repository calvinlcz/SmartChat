package com.example.kahheng.smartchat;

/**
 * Created by Ryan on 3/1/2016.
 */
public class ContactDataProvider {

    private int contact_image;
    private String contact_name;
    public int getContact_image() {
        return contact_image;
    }

  public void setContact_image(int contact_image) {
        this.contact_image = contact_image;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }
    // constructor
    public ContactDataProvider(int contact_image, String contact_name){
        this.setContact_name(contact_name);
        this.setContact_image(contact_image);
    }

}
