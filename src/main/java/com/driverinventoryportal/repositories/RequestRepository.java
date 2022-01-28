package com.driverinventoryportal.repositories;

import com.driverinventoryportal.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author PJ090169
 * This is interface for Request Repository which has domain type of Request
 * and data type of entity that repository manages is integer
 */
public interface RequestRepository extends JpaRepository<Request, Integer> {

}
