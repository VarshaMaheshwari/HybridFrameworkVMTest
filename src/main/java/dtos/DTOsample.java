package dtos;

import io.cucumber.java.DataTableType;

import java.util.Map;

public class DTOsample {

        private String accept;
        private String contentType;

        private Integer idleTime;


        public String getAccept() {
            return accept;
        }


        public Integer getIdleTime() {
            return idleTime;
        }

        public String getContentType() {
            return contentType;
        }



        public DTOsample() {
            super();
        }

        public DTOsample(Map<String, String> entry) {
          //  super(entry);
        }


        @DataTableType
        public static DTOsample convertToDtos(Map<String, String> entry) {
            DTOsample dtType = new DTOsample(entry);
            dtType.accept=entry.get("accept");
            dtType.contentType=entry.get("contentType");
             dtType.idleTime=entry.get("idleTime")!=null?Integer.valueOf(entry.get("idleTime")):null;
            return dtType;
        }



    }

