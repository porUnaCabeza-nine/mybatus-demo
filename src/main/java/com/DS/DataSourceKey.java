package com.DS;

public enum DataSourceKey {
    DB_MASTER("master"),
    DB_SLAVE("slave");
    private String name;

    DataSourceKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
