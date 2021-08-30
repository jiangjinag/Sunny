package com.example.caiyun.model.entity;

import java.util.List;


public class ForecastWeather {
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
        public DailyBean daily;
        public Double primary;


        public static class DailyBean {
            public String status;
            public List<AstroBean> astro;
            public List<PrecipitationBean> precipitation;
            public List<TemperatureBean> temperature;
            public List<WindBean> wind;
            public List<HumidityBean> humidity;
            public List<CloudrateBean> cloudrate;
            public List<PressureBean> pressure;
            public List<VisibilityBean> visibility;
            public List<DswrfBean> dswrf;
            public AirQualityBean air_quality;
            public List<SkyconBean> skycon;
            public List<Skycon08h20hBean> skycon_08h_20h;
            public List<Skycon20h32hBean> skycon_20h_32h;
            public LifeIndexBean life_index;


            public static class AirQualityBean {
                public List<AqiBean> aqi;
                public List<Pm25Bean> pm25;


                public static class AqiBean {
                    public String date;
                    public MaxBean max;
                    public AvgBean avg;
                    public MinBean min;


                    public static class MaxBean {
                        public Double chn;
                        public Double usa;
                    }


                    public static class AvgBean {
                        public Double chn;
                        public Double usa;
                    }

                    public static class MinBean {
                        public Double chn;
                        public Double usa;
                    }
                }


                public static class Pm25Bean {
                    public String date;
                    public Double max;
                    public Double avg;
                    public Double min;
                }
            }


            public static class LifeIndexBean {
                public List<UltravioletBean> ultraviolet;
                public List<CarWashingBean> carWashing;
                public List<DressingBean> dressing;
                public List<ComfortBean> comfort;
                public List<ColdRiskBean> coldRisk;


                public static class UltravioletBean {
                    public String date;
                    public String index;
                    public String desc;
                }


                public static class CarWashingBean {
                    public String date;
                    public String index;
                    public String desc;
                }


                public static class DressingBean {
                    public String date;
                    public String index;
                    public String desc;
                }


                public static class ComfortBean {
                    public String date;
                    public String index;
                    public String desc;
                }


                public static class ColdRiskBean {
                    public String date;
                    public String index;
                    public String desc;
                }
            }


            public static class AstroBean {
                public String date;
                public SunriseBean sunrise;
                public SunsetBean sunset;


                public static class SunriseBean {
                    public String time;
                }


                public static class SunsetBean {
                    public String time;
                }
            }


            public static class PrecipitationBean {
                public String date;
                public Double max;
                public Double min;
                public Double avg;
            }


            public static class TemperatureBean {
                public String date;
                public Double max;
                public Double min;
                public Double avg;
            }


            public static class WindBean {
                public String date;
                public MaxBean max;
                public MinBean min;
                public AvgBean avg;


                public static class MaxBean {
                    public Double speed;
                    public Double direction;
                }


                public static class MinBean {
                    public Double speed;
                    public Double direction;
                }


                public static class AvgBean {
                    public Double speed;
                    public Double direction;
                }
            }


            public static class HumidityBean {
                public String date;
                public Double max;
                public Double min;
                public Double avg;
            }

            public static class CloudrateBean {
                public String date;
                public Double max;
                public Double min;
                public Double avg;
            }


            public static class PressureBean {
                public String date;
                public Double max;
                public Double min;
                public Double avg;
            }


            public static class VisibilityBean {
                public String date;
                public Double max;
                public Double min;
                public Double avg;
            }


            public static class DswrfBean {
                public String date;
                public Double max;
                public Double min;
                public Double avg;
            }


            public static class SkyconBean {
                public String date;
                public String value;
            }


            public static class Skycon08h20hBean {
                public String date;
                public String value;
            }


            public static class Skycon20h32hBean {
                public String date;
                public String value;
            }
        }
    }
}
