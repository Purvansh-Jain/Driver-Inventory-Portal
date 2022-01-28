package com.driverinventoryportal.services;

import com.driverinventoryportal.models.Driver;
import com.driverinventoryportal.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author PJ090169
 * This class is a  implementation of the DriverService Interface
 * This class will provide service to Driver Inventory Portal
 * It connects Controller with repository
 */
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository repository;

    /**
     * @param driver
     * @return Driver
     * Add driver details into database
     */
    @Override
    public Driver saveAndFlushDriver(Driver driver) {
        return repository.save(driver);
    }

    /**
     * @param driverId
     * @return Get Driver By Id
     * Get driver details from database using driver id
     */
    @Override
    public Driver getDriverById(long driverId) {
        return repository.findById(driverId).orElse(null);
    }
    /**
     * @param driverId
     * @return Delete Driver By Id
     * Delete unwanted driver from database
     */
    @Override
    public Driver deleteDriverById(long driverId) {
        Driver driver = getDriverById(driverId);
        repository.deleteById(driverId);
        return driver;
    }

    /**
     * @param driverId
     * @param driver
     * @return Updated Driver By Id
     * Update existing driver model in database
     */
    @Override
    public Driver updateDriverById(long driverId, Driver driver) {
        Driver existingDriver = getDriverById(driverId);
        existingDriver.setCommunicationProtocol(driver.getCommunicationProtocol());
        existingDriver.setDriverType(driver.getDriverType());
        existingDriver.setVendor(driver.getVendor());
        existingDriver.setModel(driver.getModel());
        existingDriver.setDescription(driver.getDescription());
        existingDriver.setLatestJar(driver.getLatestJar());
        existingDriver.setPackageNumber(driver.getPackageNumber());
        existingDriver.setGitHubRepository(driver.getGitHubRepository());
        return repository.save(existingDriver);
    }


}