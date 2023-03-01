package com.main.Admin;

public class Admin implements Runnable {

    ADMIN_HOMEPAGE             home = new ADMIN_HOMEPAGE();
    ADMIN_HOMEPAGE_ADDUSER     adduser = new ADMIN_HOMEPAGE_ADDUSER();
    ADMIN_HOMEPAGE_CREATERESET create_or_reset = new ADMIN_HOMEPAGE_CREATERESET();
    ADMIN_HOMEPAGE_ISSUEBOOK   issuebook = new ADMIN_HOMEPAGE_ISSUEBOOK();
    ADMIN_HOMEPAGE_RETURNBOOK  returnbook = new ADMIN_HOMEPAGE_RETURNBOOK();
    ADMIN_HOMEPAGE_VIEWBOOKS   viewbooks = new ADMIN_HOMEPAGE_VIEWBOOKS();
    ADMIN_HOMEPAGE_VIEWUSERS   viewusers = new ADMIN_HOMEPAGE_VIEWUSERS();

    @Override
    public void run() {
        System.out.println("Welcome to admin Homepage");

/*
 *  The program will launch the homepage.
 */

    }
}
