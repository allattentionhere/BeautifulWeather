package com.allattentionhere.beautifulweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by krupenghetiya on 01/02/17.
 */

public class WeatherResult {
    @SerializedName("id")
    long id;

    @SerializedName("dt")
    long dt;

    @SerializedName("clouds")
    WeatherClouds clouds;

    @SerializedName("coord")
    WeatherCoord coord;

    @SerializedName("wind")
    WeatherWind wind;

    @SerializedName("sys")
    WeatherSys sys;

    @SerializedName("name")
    String name;

    @SerializedName("weather")
    List<WeatherInfo> weather;

    @SerializedName("rain")
    WeatherRain rain;
    @SerializedName("snow")
    WeatherSnow snow;

    @SerializedName("main")
    WeatherMain main;

    class WeatherClouds {
        @SerializedName("all")
        String all;

        public String getCloudinessPercent() {
            return all;
        }
    }

    class WeatherCoord {
        @SerializedName("lon")
        float lon;

        @SerializedName("lat")
        float lat;

        public float getLon() {
            return lon;
        }

        public float getLat() {
            return lat;
        }
    }

    class WeatherWind {
        @SerializedName("speed")
        float speed;

        @SerializedName("deg")
        float deg;

        public float getSpeed() {
            return speed;
        }

        public float getDeg() {
            return deg;
        }
    }

    class WeatherSys {
        @SerializedName("sunset")
        long sunset;
        @SerializedName("sunrise")
        long sunrise;
        @SerializedName("country")
        String country;

        public long getSunset() {
            return sunset;
        }

        public long getSunrise() {
            return sunrise;
        }

        public String getCountry() {
            return country;
        }
    }

    class WeatherInfo {
        @SerializedName("id")
        int id;

        @SerializedName("icon")
        String icon;

        @SerializedName("description")
        String description;

        @SerializedName("main")
        String main;

        public int getId() {
            return id;
        }

        public String getIcon() {
            return icon;
        }

        public String getDescription() {
            return description;
        }

        public String getMain() {
            return main;
        }
    }

    class WeatherRain {
        @SerializedName("_3h")
        String _3h;

        public String get_3h() {
            return _3h;
        }
    }

    class WeatherMain {
        @SerializedName("humidity")
        float humidity;
        @SerializedName("pressure")
        float pressure;
        @SerializedName("temp_max")
        float temp_max;
        @SerializedName("temp_min")
        float temp_min;
        @SerializedName("temp")
        float temp;
        @SerializedName("sea_level")
        float sea_level;
        @SerializedName("grnd_level")
        float grnd_level;

        public float getHumidityPercent() {
            return humidity;
        }

        public float getPressure() {
            return pressure;
        }

        public float getTemp_max() {
            return temp_max;
        }

        public float getTemp_min() {
            return temp_min;
        }

        public float getTemp() {
            return temp;
        }

        public float getSea_level() {
            return sea_level;
        }

        public float getGrnd_level() {
            return grnd_level;
        }
    }

    class WeatherSnow {
        @SerializedName("_3h")
        String _3h;

        public String get_3h() {
            return _3h;
        }
    }
}
