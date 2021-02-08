package org.tyaa.demo.java.console.customannotations.beans;

import java.io.Serializable;

public class IsNotBean implements Serializable {
    public void setData(){
        System.out.println("setData");
    }
    public void getData(){
        System.out.println("getData");
    }
}
