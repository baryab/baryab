package baryab.motesadi.models;

import com.google.gson.annotations.SerializedName;

public class SDLog {
    @SerializedName("Id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
