package com.nulabinc.backlog4j.http;

/**
 * Created by yuhkim on 2014/10/17.
 */
public class NameValuePair {
    private String name;
    private String value;

    public NameValuePair(String name, String value){
        this.name = name;
        this.value = value;
    }
    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }




}
