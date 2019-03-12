package com.model;

public class HeWeather6 {

    private Basic basic;
    private Now now;
    private String status;
    private Update update;
    public void setBasic(Basic basic) {
         this.basic = basic;
     }
     public Basic getBasic() {
         return basic;
     }

    public void setNow(Now now) {
         this.now = now;
     }
     public Now getNow() {
         return now;
     }

    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setUpdate(Update update) {
         this.update = update;
     }
     public Update getUpdate() {
         return update;
     }

}