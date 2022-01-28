package com.driverinventoryportal.models.dto;

import com.driverinventoryportal.models.Driver;

/**
 * @author PJ090169
 * This class implements a DriverDto that can be used by controller to add and update driver instead of
 * using Persistent entity directly in Request Mapping which could expose  a to our database from intruder
 */
public class DriverDto {
        private long driverId;
        private String communicationProtocol;
        private String driverType;
        private String vendor;
        private String model;
        private String description;
        private String latestJar;
        private Integer packageNumber;
        private String gitHubRepository;

    /**
     * @param driver
     * @return DriverDto class is interconnected with Driver class
     */
        public static DriverDto from(Driver driver){
            DriverDto driverDto = new DriverDto();
            driverDto.setDriverId(driver.getDriverId());
            driverDto.setCommunicationProtocol(driver.getCommunicationProtocol());
            driverDto.setDriverType(driver.getDriverType());
            driverDto.setVendor(driver.getVendor());
            driverDto.setModel(driver.getModel());
            driverDto.setDescription(driver.getDescription());
            driverDto.setLatestJar(driver.getLatestJar());
            driverDto.setPackageNumber(driver.getPackageNumber());
            driverDto.setGitHubRepository(driver.getGitHubRepository());
            return driverDto;
        }

        //default constructor
         public DriverDto(){}

    /**
     * @param communicationProtocol
     * @param driverType
     * @param vendor
     * @param model
     * @param description
     * @param latestJar
     * @param packageNumber
     * @param gitHubRepository
     */
    public DriverDto(String communicationProtocol, String driverType, String vendor, String model, String description, String latestJar, Integer packageNumber, String gitHubRepository) {
        this.communicationProtocol = communicationProtocol;
        this.driverType = driverType;
        this.vendor = vendor;
        this.model = model;
        this.description = description;
        this.latestJar = latestJar;
        this.packageNumber = packageNumber;
        this.gitHubRepository = gitHubRepository;
    }

    /**
     * @return Driver Id
     */
    public long getDriverId() {
        return driverId; }
    /**
     * @param driverId
     */
    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    /**
     * @return Communication Protocol
     */
    public String getCommunicationProtocol() {
        return communicationProtocol;
    }
    /**
     * @param communicationProtocol
     */
    public void setCommunicationProtocol(String communicationProtocol) {
        this.communicationProtocol = communicationProtocol; }

    /**
     * @return Driver Type
     */
    public String getDriverType() {
        return driverType;
    }
    /**
     * @param driverType
     */
    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    /**
     * @return Vendor
     */
    public String getVendor() {
        return vendor;
    }
    /**
     * @param vendor
     */
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     * @return Model
     */
    public String getModel() {
        return model;
    }
    /**
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return Description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Latest Jar
     */
    public String getLatestJar() {
        return latestJar;
    }
    /**
     * @param latestJar
     */
    public void setLatestJar(String latestJar) {
        this.latestJar = latestJar;
    }

    /**
     * @return Package Number
     */
    public Integer getPackageNumber() {
        return packageNumber;
    }
    /**
     * @param packageNumber
     */
    public void setPackageNumber(Integer packageNumber) {
        this.packageNumber = packageNumber;
    }

    /**
     * @return Github Repository
     */
    public String getGitHubRepository() {
        return gitHubRepository;
    }
    /**
     * @param gitHubRepository
     */
    public void setGitHubRepository(String gitHubRepository) {
        this.gitHubRepository = gitHubRepository;
    }

}
