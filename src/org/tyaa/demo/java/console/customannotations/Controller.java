package org.tyaa.demo.java.console.customannotations;

import org.tyaa.demo.java.console.customannotations.annotations.Inject;
import org.tyaa.demo.java.console.customannotations.beans.Cookies;

public class Controller {
    @Inject(name = "cookies")
    private Cookies cookies;
    public void doWork () {
        cookies.setCookie();
        cookies.getCookie();
    }
}
