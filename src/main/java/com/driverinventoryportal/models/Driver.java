package com.driverinventoryportal.models;

import com.driverinventoryportal.models.dto.DriverDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

/**
 * @author PJ090169
 * This class implements a Driver that can access Request class
 */
@Entity
@Table(name="driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long driverId;
    @NotBlank
    private String communicationProtocol;
    @NotBlank
    private String driverType;
    @NotBlank
    private String vendor;
    @NotBlank
    private String model;
    private String description;
    private String latestJar;
    private Integer packageNumber;
    private String gitHubRepository;

    /**
     * Using JsonIgnore we can stop repetitive loops
     * Here, Driver class is being mapped using OneToMany Relationship with Request class
     */
    @JsonIgnore
    @OneToMany(mappedBy = "driver")
    private Set<Request> requests = new HashSet<>();

    /**
     * @param driverDto
     * @return Driver class is interconnected with DriverDto class
     */
    public static Driver from(DriverDto driverDto){
        Driver driver = new Driver();
        driver.setCommunicationProtocol(driverDto.getCommunicationProtocol());
        driver.setDriverType(driverDto.getDriverType());
        driver.setVendor(driverDto.getDriverType());
        driver.setVendor(driverDto.getVendor());
        driver.setModel(driverDto.getModel());
        driver.setDescription(driverDto.getDescription());
        driver.setLatestJar(driverDto.getLatestJar());
        driver.setPackageNumber(driverDto.getPackageNumber());
        driver.setGitHubRepository(driverDto.getGitHubRepository());
        return driver;
    }

    /**
     * @return driver_id
     */
    public long getDriverId() {
        return driverId; }
    /**
     * @return Communication Protocol
     */
    public String getCommunicationProtocol() {
        return communicationProtocol; }
    /**
     * @param communicationProtocol
     */
    public void setCommunicationProtocol(String communicationProtocol) {
        this.communicationProtocol = communicationProtocol; }
    /**
     * @return Vendor
     */
    public String getVendor() {
        return vendor; }
    /**
     * @param vendor
     */
    public void setVendor(String vendor) {
        this.vendor = vendor; }
    /**
     * @return Model
     */
    public String getModel() {
        return model; }
    /**
     * @param model
     */
    public void setModel(String model) {
        this.model = model; }
    /**
     * @return Description
     */
    public String getDescription() {
        return description; }
    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description; }
    /**
     * @return Latest Jar
     */
    public String getLatestJar() {
        return latestJar; }
    /**
     * @param latestJar
     */
    public void setLatestJar(String latestJar) {
        this.latestJar = latestJar; }
    /**
     * @return Package Number
     */
    public Integer getPackageNumber() {
        return packageNumber; }
    /**
     * @param packageNumber
     */
    public void setPackageNumber(Integer packageNumber) {
        this.packageNumber = packageNumber; }
    /**
     * @return Github Repository
     */
    public String getGitHubRepository() {
        return gitHubRepository; }
    /**
     * @param gitHubRepository
     */
    public void setGitHubRepository(String gitHubRepository) {
        this.gitHubRepository = gitHubRepository; }
    /**
     * @return Driver Type
     */
    public String getDriverType() {
        return driverType; }
    /**
     * @param driverType
     */
    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }
}
