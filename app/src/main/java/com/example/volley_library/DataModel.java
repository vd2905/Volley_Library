package com.example.volley_library;

import java.util.ArrayList;
import java.util.List;

public class DataModel {

    private String success;
    private String message;
    private Data data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        private ArrayList<Create> create;

        public ArrayList<Create> getCreate() {
            return create;
        }

        public void setCreate(ArrayList<Create> create) {
            this.create = create;
        }
    }

    public class Create {
        private Integer id;
        private String catName;
        private String catType;
        private String shortDesc;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }

        public String getCatType() {
            return catType;
        }

        public void setCatType(String catType) {
            this.catType = catType;
        }

        public String getShortDesc() {
            return shortDesc;
        }

        public void setShortDesc(String shortDesc) {
            this.shortDesc = shortDesc;
        }

    }

}
