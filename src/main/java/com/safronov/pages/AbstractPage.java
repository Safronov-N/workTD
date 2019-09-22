package com.safronov.pages;

import com.safronov.Driver.Driver;

abstract class AbstractPage {
    abstract void waitForLoadFinished();
    Driver driver = Driver.getInstance();

}
