package com.bhaskerStreet.hotelBooking.services.facility;

import com.bhaskerStreet.hotelBooking.entities.Facility;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacilityService {

    List<Facility> getFacilities(int facilityFeatuers);

}
