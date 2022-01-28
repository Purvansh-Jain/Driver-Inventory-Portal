package com.driverinventoryportal.services;

import com.driverinventoryportal.models.Driver;

/**
 * @author PJ090169
 * This is interface for Driver Service
 */
public interface DriverService {

    public Driver saveAndFlushDriver(Driver driver);
    public Driver getDriverById(long driverId);
    public Driver deleteDriverById(long driverId);
    public Driver updateDriverById(long driverId , Driver driver);
}
