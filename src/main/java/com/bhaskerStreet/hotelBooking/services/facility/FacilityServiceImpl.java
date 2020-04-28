package com.bhaskerStreet.hotelBooking.services.facility;

import com.bhaskerStreet.hotelBooking.entities.Facility;
import com.bhaskerStreet.hotelBooking.repository.FacilityRepository;
import com.bhaskerStreet.hotelBooking.services.feature.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private FeatureService featureService;

    @Override
    public List<Facility> getFacilities(int facilityFeatures) {

        Integer[] ids = featureService.getIdsFromFeature(facilityFeatures);


        return facilityRepository.findFacilitiesByIdIn(ids);
    }

}
