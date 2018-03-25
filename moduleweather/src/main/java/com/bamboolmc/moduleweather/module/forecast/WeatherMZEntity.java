package com.bamboolmc.moduleweather.module.forecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by BambooLmc on 18/3/13 下午10:37.
 */

public class WeatherMZEntity {

    @SerializedName("city")
    String city;
    @SerializedName("cityid")
    int cityid;
    @SerializedName("pm25")
    Pm25Bean pm25;
    @SerializedName("provinceName")
    String provinceName;
    @SerializedName("realtime")
    RealtimeBean realtime;
    @SerializedName("weatherDetailsInfo")
    WeatherDetailsInfoBean weatherDetailsInfo;
    @SerializedName("alarms")
    List<?> alarms;
    @SerializedName("indexes")
    List<IndexesBean> indexes;
    @SerializedName("weathers")
    List<WeathersBean> weathers;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public Pm25Bean getPm25() {
        return pm25;
    }

    public void setPm25(Pm25Bean pm25) {
        this.pm25 = pm25;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public RealtimeBean getRealtime() {
        return realtime;
    }

    public void setRealtime(RealtimeBean realtime) {
        this.realtime = realtime;
    }

    public WeatherDetailsInfoBean getWeatherDetailsInfo() {
        return weatherDetailsInfo;
    }

    public void setWeatherDetailsInfo(WeatherDetailsInfoBean weatherDetailsInfo) {
        this.weatherDetailsInfo = weatherDetailsInfo;
    }

    public List<?> getAlarms() {
        return alarms;
    }

    public void setAlarms(List<?> alarms) {
        this.alarms = alarms;
    }

    public List<IndexesBean> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<IndexesBean> indexes) {
        this.indexes = indexes;
    }

    public List<WeathersBean> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<WeathersBean> weathers) {
        this.weathers = weathers;
    }

    public static class Pm25Bean {
        @SerializedName("advice")
        String advice;
        @SerializedName("aqi")
        String aqi;
        @SerializedName("citycount")
        int citycount;
        @SerializedName("cityrank")
        int cityrank;
        @SerializedName("co")
        String co;
        @SerializedName("color")
        String color;
        @SerializedName("level")
        String level;
        @SerializedName("no2")
        String no2;
        @SerializedName("o3")
        String o3;
        @SerializedName("pm10")
        String pm10;
        @SerializedName("pm25")
        String pm25;
        @SerializedName("quality")
        String quality;
        @SerializedName("so2")
        String so2;
        @SerializedName("timestamp")
        String timestamp;
        @SerializedName("upDateTime")
        String upDateTime;

        public String getAdvice() {
            return advice;
        }

        public void setAdvice(String advice) {
            this.advice = advice;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public int getCitycount() {
            return citycount;
        }

        public void setCitycount(int citycount) {
            this.citycount = citycount;
        }

        public int getCityrank() {
            return cityrank;
        }

        public void setCityrank(int cityrank) {
            this.cityrank = cityrank;
        }

        public String getCo() {
            return co;
        }

        public void setCo(String co) {
            this.co = co;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getNo2() {
            return no2;
        }

        public void setNo2(String no2) {
            this.no2 = no2;
        }

        public String getO3() {
            return o3;
        }

        public void setO3(String o3) {
            this.o3 = o3;
        }

        public String getPm10() {
            return pm10;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getSo2() {
            return so2;
        }

        public void setSo2(String so2) {
            this.so2 = so2;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getUpDateTime() {
            return upDateTime;
        }

        public void setUpDateTime(String upDateTime) {
            this.upDateTime = upDateTime;
        }
    }

    public static class RealtimeBean {
        @SerializedName("img")
        String img;
        @SerializedName("sD")
        String sD;
        @SerializedName("sendibleTemp")
        String sendibleTemp;
        @SerializedName("temp")
        String temp;
        @SerializedName("time")
        String time;
        @SerializedName("wD")
        String wD;
        @SerializedName("wS")
        String wS;
        @SerializedName("weather")
        String weather;
        @SerializedName("ziwaixian")
        String ziwaixian;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getsD() {
            return sD;
        }

        public void setsD(String sD) {
            this.sD = sD;
        }

        public String getSendibleTemp() {
            return sendibleTemp;
        }

        public void setSendibleTemp(String sendibleTemp) {
            this.sendibleTemp = sendibleTemp;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getwD() {
            return wD;
        }

        public void setwD(String wD) {
            this.wD = wD;
        }

        public String getwS() {
            return wS;
        }

        public void setwS(String wS) {
            this.wS = wS;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getZiwaixian() {
            return ziwaixian;
        }

        public void setZiwaixian(String ziwaixian) {
            this.ziwaixian = ziwaixian;
        }
    }

    public static class WeatherDetailsInfoBean {
        @SerializedName("publishTime")
        String publishTime;
        @SerializedName("weather24HoursDetailsInfos")
        List<Weather24HoursDetailsInfosBean> weather24HoursDetailsInfos;

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public List<Weather24HoursDetailsInfosBean> getWeather24HoursDetailsInfos() {
            return weather24HoursDetailsInfos;
        }

        public void setWeather24HoursDetailsInfos(List<Weather24HoursDetailsInfosBean> weather24HoursDetailsInfos) {
            this.weather24HoursDetailsInfos = weather24HoursDetailsInfos;
        }

        public static class Weather24HoursDetailsInfosBean {
            @SerializedName("endTime")
            String endTime;
            @SerializedName("highestTemperature")
            String highestTemperature;
            @SerializedName("img")
            String img;
            @SerializedName("isRainFall")
            String isRainFall;
            @SerializedName("lowerestTemperature")
            String lowerestTemperature;
            @SerializedName("precipitation")
            String precipitation;
            @SerializedName("startTime")
            String startTime;
            @SerializedName("wd")
            String wd;
            @SerializedName("weather")
            String weather;
            @SerializedName("ws")
            String ws;

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getHighestTemperature() {
                return highestTemperature;
            }

            public void setHighestTemperature(String highestTemperature) {
                this.highestTemperature = highestTemperature;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getIsRainFall() {
                return isRainFall;
            }

            public void setIsRainFall(String isRainFall) {
                this.isRainFall = isRainFall;
            }

            public String getLowerestTemperature() {
                return lowerestTemperature;
            }

            public void setLowerestTemperature(String lowerestTemperature) {
                this.lowerestTemperature = lowerestTemperature;
            }

            public String getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(String precipitation) {
                this.precipitation = precipitation;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getWd() {
                return wd;
            }

            public void setWd(String wd) {
                this.wd = wd;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public String getWs() {
                return ws;
            }

            public void setWs(String ws) {
                this.ws = ws;
            }
        }
    }

    public static class IndexesBean {
        @SerializedName("abbreviation")
        String abbreviation;
        @SerializedName("alias")
        String alias;
        @SerializedName("content")
        String content;
        @SerializedName("level")
        String level;
        @SerializedName("name")
        String name;

        public String getAbbreviation() {
            return abbreviation;
        }

        public void setAbbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class WeathersBean {
        @SerializedName("date")
        String date;
        @SerializedName("img")
        String img;
        @SerializedName("sun_down_time")
        String sun_down_time;
        @SerializedName("sun_rise_time")
        String sun_rise_time;
        @SerializedName("temp_day_c")
        String temp_day_c;
        @SerializedName("temp_day_f")
        String temp_day_f;
        @SerializedName("temp_night_c")
        String temp_night_c;
        @SerializedName("temp_night_f")
        String temp_night_f;
        @SerializedName("wd")
        String wd;
        @SerializedName("weather")
        String weather;
        @SerializedName("week")
        String week;
        @SerializedName("ws")
        String ws;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getSun_down_time() {
            return sun_down_time;
        }

        public void setSun_down_time(String sun_down_time) {
            this.sun_down_time = sun_down_time;
        }

        public String getSun_rise_time() {
            return sun_rise_time;
        }

        public void setSun_rise_time(String sun_rise_time) {
            this.sun_rise_time = sun_rise_time;
        }

        public String getTemp_day_c() {
            return temp_day_c;
        }

        public void setTemp_day_c(String temp_day_c) {
            this.temp_day_c = temp_day_c;
        }

        public String getTemp_day_f() {
            return temp_day_f;
        }

        public void setTemp_day_f(String temp_day_f) {
            this.temp_day_f = temp_day_f;
        }

        public String getTemp_night_c() {
            return temp_night_c;
        }

        public void setTemp_night_c(String temp_night_c) {
            this.temp_night_c = temp_night_c;
        }

        public String getTemp_night_f() {
            return temp_night_f;
        }

        public void setTemp_night_f(String temp_night_f) {
            this.temp_night_f = temp_night_f;
        }

        public String getWd() {
            return wd;
        }

        public void setWd(String wd) {
            this.wd = wd;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getWs() {
            return ws;
        }

        public void setWs(String ws) {
            this.ws = ws;
        }
    }
}
