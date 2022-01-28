package com.driverinventoryportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.driverinventoryportal.models.Driver;

/**
 * @author PJ090169
 * This is interface for Driver Repository which has domain type of Driver
 * and data type of entity that repository manages is long
 */
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
