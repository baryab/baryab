package baryab.motesadi.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProvinceType {
    @SerializedName("data")
    private List<data> dataList;
    @SerializedName("result")
    private boolean result;
    @SerializedName("message")
    private String message;
    @SerializedName("StatusCode")
    private int statuscode;


    public List<data> getDataList() {
        return dataList;
    }

    public void setDataList(List<data> dataList) {
        this.dataList = dataList;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public class data {
        @SerializedName("moneyType")
        private List<moneyType> moneyTypeList;
        @SerializedName("truckType")
        private List<truckType> truckTypeList;
        @SerializedName("province")
        private List<province> provinceList;


        public List<moneyType> getMoneyTypeList() {
            return moneyTypeList;
        }

        public void setMoneyTypeList(List<moneyType> moneyTypeList) {
            this.moneyTypeList = moneyTypeList;
        }

        public List<truckType> getTruckTypeList() {
            return truckTypeList;
        }

        public void setTruckTypeList(List<truckType> truckTypeList) {
            this.truckTypeList = truckTypeList;
        }

        public List<province> getProvinceList() {
            return provinceList;
        }

        public void setProvinceList(List<province> provinceList) {
            this.provinceList = provinceList;
        }
    }

    public class moneyType {
        @SerializedName("Id")
        private int id;
        @SerializedName("name")
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class truckType {
        @SerializedName("Id")
        private int id;
        @SerializedName("Name")
        private String name;
        @SerializedName("Pid")
        private int pid;
        @SerializedName("FullName")
        private String fullname;
        @SerializedName("MinLength")
        private double minlenght;
        @SerializedName("MaxLength")
        private double maxlenght;
        @SerializedName("MinWidth")
        private double minwidth;
        @SerializedName("MaxWidth")
        private double maxwidth;
        @SerializedName("MinHeight")
        private double minheight;
        @SerializedName("MaxHeight")
        private double maxheight;
        @SerializedName("IsRoof")
        private boolean isroof;
        @SerializedName("HasChild")
        private boolean haschild;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public double getMinlenght() {
            return minlenght;
        }

        public void setMinlenght(double minlenght) {
            this.minlenght = minlenght;
        }

        public double getMaxlenght() {
            return maxlenght;
        }

        public void setMaxlenght(double maxlenght) {
            this.maxlenght = maxlenght;
        }

        public double getMinwidth() {
            return minwidth;
        }

        public void setMinwidth(double minwidth) {
            this.minwidth = minwidth;
        }

        public double getMaxwidth() {
            return maxwidth;
        }

        public void setMaxwidth(double maxwidth) {
            this.maxwidth = maxwidth;
        }

        public double getMinheight() {
            return minheight;
        }

        public void setMinheight(double minheight) {
            this.minheight = minheight;
        }

        public double getMaxheight() {
            return maxheight;
        }

        public void setMaxheight(double maxheight) {
            this.maxheight = maxheight;
        }

        public boolean isIsroof() {
            return isroof;
        }

        public void setIsroof(boolean isroof) {
            this.isroof = isroof;
        }

        public boolean isHaschild() {
            return haschild;
        }

        public void setHaschild(boolean haschild) {
            this.haschild = haschild;
        }
    }

    public class province {
        @SerializedName("Id")
        private int id;
        @SerializedName("cityName")
        private String cityname;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCityname() {
            return cityname;
        }

        public void setCityname(String cityname) {
            this.cityname = cityname;
        }
    }

}
