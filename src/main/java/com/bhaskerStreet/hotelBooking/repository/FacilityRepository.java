package com.bhaskerStreet.hotelBooking.repository;

import com.bhaskerStreet.hotelBooking.entities.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {

    List<Facility> findFacilitiesByIdIn(Integer[] facilityIds);

}
