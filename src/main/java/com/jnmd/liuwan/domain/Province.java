package com.jnmd.liuwan.domain;

public class Province { //目的地城市
    private int cityId; // ID
    private String cityName;    //城市名称
    public Province() {
        super();
    }
    public Province(String cityName) {
        super();
        this.cityName = cityName;
    }
    public Province(int cityId, String cityName) {
        super();
        this.cityId = cityId;
        this.cityName = cityName;
    }
    public int getCityId() {
        return cityId;
    }
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    @Override
    public String toString() {
        return "Province [cityId=" + cityId + ", cityName=" + cityName + "]";
    }
}
