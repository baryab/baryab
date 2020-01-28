package baryab.motesadi.activities.models;

import baryab.motesadi.info.PlacesInfo;

import java.util.ArrayList;
import java.util.List;

public class MapModel {
    private List<PlacesInfo> listPlacesInfo;

    public MapModel() {
        this.listPlacesInfo = new ArrayList<>();
    }

    public void addNewPlace(PlacesInfo placesInfo) {
        listPlacesInfo.add(placesInfo);
    }

    public List<PlacesInfo> getPlaces() {
        return listPlacesInfo;
    }
}
