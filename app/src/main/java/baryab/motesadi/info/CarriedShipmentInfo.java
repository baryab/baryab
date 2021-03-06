package baryab.motesadi.info;

public class CarriedShipmentInfo {
    private String shipmentId;
    private String driverId;
    private long date;
    private String truckType;
    private String shipmentType;
    private float weight;
    private String originsName;
    private String destinationName;
    private String driverPhoto;
    private String driverName;
    private float driverRating;
    private String plateLicenseNumber;

    public CarriedShipmentInfo(String shipmentId, String driverId, long date, String truckType, String shipmentType, float weight, String originsName, String destinationName, String driverPhoto, String driverName, float driverRating, String plateLicenseNumber) {
        this.shipmentId = shipmentId;
        this.driverId = driverId;
        this.date = date;
        this.truckType = truckType;
        this.shipmentType = shipmentType;
        this.weight = weight;
        this.originsName = originsName;
        this.destinationName = destinationName;
        this.driverPhoto = driverPhoto;
        this.driverName = driverName;
        this.driverRating = driverRating;
        this.plateLicenseNumber = plateLicenseNumber;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public String getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(String shipmentType) {
        this.shipmentType = shipmentType;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getOriginsName() {
        return originsName;
    }

    public void setOriginsName(String originsName) {
        this.originsName = originsName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDriverPhoto() {
        return driverPhoto;
    }

    public void setDriverPhoto(String driverPhoto) {
        this.driverPhoto = driverPhoto;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public float getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(float driverRating) {
        this.driverRating = driverRating;
    }

    public String getPlateLicenseNumber() {
        return plateLicenseNumber;
    }

    public void setPlateLicenseNumber(String plateLicenseNumber) {
        this.plateLicenseNumber = plateLicenseNumber;
    }
}