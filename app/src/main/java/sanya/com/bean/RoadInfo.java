package sanya.com.bean;

import java.util.List;

/**
 * Created by Sep
 */
public class RoadInfo {

    /**
     * Title : 亚龙湾 - 热带天堂森林公园
     * Summary : ["上午在沙滩大海亲密接触。","乘坐25路公交去热带天堂森林公园，重温非诚勿扰2的浪漫，看鸟巢过索道。"]
     * Filmstrips : [{"PicUrl":"Scene1.jpg","Title":"亚龙湾旅游度假区","KeyID":"00004101","DataPath":"00004101json.txt"},{"PicUrl":"Scene5.jpg","Title":"热带天堂森林公园","KeyID":"00004102","DataPath":"00004102json.txt"}]
     */

    private List<RoutesEntity> Routes;

    public void setRoutes(List<RoutesEntity> Routes) {
        this.Routes = Routes;
    }

    public List<RoutesEntity> getRoutes() {
        return Routes;
    }

    public static class RoutesEntity {
        private String Title;
        private List<String> Summary;
        /**
         * PicUrl : Scene1.jpg
         * Title : 亚龙湾旅游度假区
         * KeyID : 00004101
         * DataPath : 00004101json.txt
         */

        private List<FilmstripsEntity> Filmstrips;

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public void setSummary(List<String> Summary) {
            this.Summary = Summary;
        }

        public void setFilmstrips(List<FilmstripsEntity> Filmstrips) {
            this.Filmstrips = Filmstrips;
        }

        public String getTitle() {
            return Title;
        }

        public List<String> getSummary() {
            return Summary;
        }

        public List<FilmstripsEntity> getFilmstrips() {
            return Filmstrips;
        }

        public static class FilmstripsEntity {
            private String PicUrl;
            private String Title;

            public void setPicUrl(String PicUrl) {
                this.PicUrl = PicUrl;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public String getPicUrl() {
                return PicUrl;
            }

            public String getTitle() {
                return Title;
            }
        }
    }
}
