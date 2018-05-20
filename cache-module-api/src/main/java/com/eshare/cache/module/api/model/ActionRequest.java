package com.eshare.cache.module.api.model;

public class ActionRequest {

    private int operation;

    private String key;

    private String value;

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public enum OPERATION {
        SAVE("保存", 0), GET("查询", 1);
        // 成员变量
        private String name;
        private int index;

        // 构造方法
        private OPERATION(String name, int index) {
            this.name = name;
            this.index = index;
        }

        //覆盖方法
        @Override
        public String toString() {
            return this.index + "_" + this.name;
        }

        // get set 方法
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

    }

}