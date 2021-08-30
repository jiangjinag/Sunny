package com.example.caiyun.model.entity;

import java.util.List;


public class RealtimeWeather {
    public String status;
    public String api_version;
    public String api_status;
    public String lang;
    public String unit;
    public Double tzshift;
    public String timezone;
    public Double server_time;
    public List<Double> location;
    public ResultBean result;


    public static class ResultBean {
        public RealtimeBean realtime;
        public Double primary;


        public static class RealtimeBean {
            public String status;
            public Double temperature;
            public Double humidity;
            public Double cloudrate;
            public String skycon;
            public Double visibility;
            public Double dswrf;
            public WindBean wind;
            public Double pressure;
            public Double apparent_temperature;
            public PrecipitationBean precipitation;
            public AirQualityBean air_quality;
            public LifeIndexBean life_index;


            public static class WindBean {
                public Double speed;
                public Double direction;
            }


            public static class PrecipitationBean {
                public LocalBean local;
                public NearestBean nearest;


                public static class LocalBean {
                    public String status;
                    public String datasource;
                    public Double intensity;
                }


                public static class NearestBean {
                    public String status;
                    public Double distance;
                    public Double intensity;
                }
            }


            public static class AirQualityBean {
                public Double pm25;
                public Double pm10;
                public Double o3;
                public Double so2;
                public Double no2;
                public Double co;
                public AqiBean aqi;
                public DescriptionBean description;


                public static class AqiBean {
                    public Double chn;
                    public Double usa;
                }


                public static class DescriptionBean {
                    public String chn;
                    public String usa;
                }
            }


            public static class LifeIndexBean {
                public UltravioletBean ultraviolet;
                public ComfortBean comfort;


                public static class UltravioletBean {
                    public Double index;
                    public String desc;
                }


                public static class ComfortBean {
                    public Double index;
                    public String desc;
                }
            }
        }
    }
}
