package com.example.caiyun.model.entity;

import java.util.List;


public class PlaceEntity {
    public String status;
    public String query;
    public List<PlacesBean> places;


    public static class PlacesBean {
        public String id;
        public String name;
        public String formatted_address;
        public LocationBean location;
        public String place_id;


        public static class LocationBean {
            public Double lat;
            public Double lng;
        }
    }
}
