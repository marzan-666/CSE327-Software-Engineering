package com.example.blue_11;

public class Posts {

    public String uid;
    public String date;
    public String time;
    public String image;
    public String description;
    public String profileImage;
    public String fullname;

    public Posts(){

    }

    public Posts(String uid, String time,String date,String image, String description, String profileImage, String fullname) {
        this.uid = uid;
        this.time = time;
        this.date = date;
        this.image = image;
        this.description = description;
        this.profileImage = profileImage;
        this.fullname = fullname;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


}
