package com.safronov.pages;

import com.safronov.driver.Driver;

abstract class AbstractPage {
    abstract void waitForLoadFinished();
    Driver driver = Driver.getInstance();

}
