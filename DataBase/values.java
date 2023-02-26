package com.example.databaselab;

public class values {
	 
    private long id;
    private String value;
 
    public values() {
        super();
    }
 
    public values(String value) {
        super();
        this.value = value;
    }
 
    public values(long id, String value) {
        super();
        this.id = id;
        this.value = value;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getValue() {
        return value;
    }
 
    public void setValue(String value) {
        this.value = value;
    }
 
}
