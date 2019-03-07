package com.curiousca.jsonretro.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayLoad {

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("subtitle")
    private String subtitle;

    @Expose
    @SerializedName("pushAvailable")
    private Boolean pushAvailable;
    @Expose
    @SerializedName("smsAvailable")
    private Boolean smsAvailable;
    @Expose
    @SerializedName("emailAvailable")
    private Boolean emailAvailable;
    @Expose
    @SerializedName("pushEnabled")
    private Boolean pushEnabled;
    @Expose
    @SerializedName("smsEnabled")
    private Boolean smsEnabled;
    @Expose
    @SerializedName("emailEnabled")
    private Boolean emailEnabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Boolean getPushAvailable() {
        return pushAvailable;
    }

    public void setPushAvailable(Boolean pushAvailable) {
        this.pushAvailable = pushAvailable;
    }

    public Boolean getSmsAvailable() {
        return smsAvailable;
    }

    public void setSmsAvailable(Boolean smsAvailable) {
        this.smsAvailable = smsAvailable;
    }

    public Boolean getEmailAvailable() {
        return emailAvailable;
    }

    public void setEmailAvailable(Boolean emailAvailable) {
        this.emailAvailable = emailAvailable;
    }

    public Boolean getPushEnabled() {
        return pushEnabled;
    }

    public void setPushEnabled(Boolean pushEnabled) {
        this.pushEnabled = pushEnabled;
    }

    public Boolean getSmsEnabled() {
        return smsEnabled;
    }

    public void setSmsEnabled(Boolean smsEnabled) {
        this.smsEnabled = smsEnabled;
    }

    public Boolean getEmailEnabled() {
        return emailEnabled;
    }

    public void setEmailEnabled(Boolean emailEnabled) {
        this.emailEnabled = emailEnabled;
    }

    @Override
    public String toString() {
        return "PayLoad{" +
                "name='" + name + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", pushAvailable=" + pushAvailable +
                ", smsAvailable=" + smsAvailable +
                ", emailAvailable=" + emailAvailable +
                ", pushEnabled=" + pushEnabled +
                ", smsEnabled=" + smsEnabled +
                ", emailEnabled=" + emailEnabled +
                '}';
    }
}
