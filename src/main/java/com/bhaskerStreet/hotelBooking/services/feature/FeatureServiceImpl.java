package com.bhaskerStreet.hotelBooking.services.feature;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeatureServiceImpl implements FeatureService {


    @Override
    public Integer[] getIdsFromFeature(int features) {

        char[] a = Long.toBinaryString(features).toCharArray();
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {

            char c = a[i];

            if (c == '1') {
                ids.add(a.length - i - 1);
            }

        }
        return ids.stream().toArray(Integer[]::new);
    }

    @Override
    public Integer updateFeature(int feature, int removeFacilityId) {
        char[] a = Long.toBinaryString(feature).toCharArray();
        a[a.length - removeFacilityId - 1] = '0';

        return Integer.valueOf(new String(a), 2);
    }

    @Override
    public Integer generateFeature(int[] ids) {

        int sum = 0;
        for (int id : ids) {
            sum += Math.pow(2, id);
        }
        return sum;

    }
}
