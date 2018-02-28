package net.eric.domain;

import java.util.Date;

/**
 * @author Eric Zhao
 * @date 2018/2/14
 */
public class Location {
    private int id;
    private float longitude;
    private float latitude;
    private float value;
    private String name;
    private Date createAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
