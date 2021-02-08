package org.tyaa.demo.java.console.customannotations.beans;

import org.tyaa.demo.java.console.customannotations.annotations.Getter;
import org.tyaa.demo.java.console.customannotations.annotations.ManagedBean;
import org.tyaa.demo.java.console.customannotations.annotations.Setter;

import java.io.Serializable;

@ManagedBean(name = "cookies")
public class Cookies implements Serializable {
    @Setter
    public void setCookie () {
        System.out.println("setCookie");
    }
    @Getter
    public void getCookie () {
        System.out.println("getCookie");
    }
}
