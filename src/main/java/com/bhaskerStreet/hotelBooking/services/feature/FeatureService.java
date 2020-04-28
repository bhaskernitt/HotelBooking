package com.bhaskerStreet.hotelBooking.services.feature;

import org.springframework.stereotype.Service;

@Service
public interface FeatureService {

    Integer[] getIdsFromFeature(int features);

    Integer generateFeature(int[] ids);

    Integer updateFeature(int feature,int removeFacilityId);

}
