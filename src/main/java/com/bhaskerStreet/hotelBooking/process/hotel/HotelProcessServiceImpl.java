package com.bhaskerStreet.hotelBooking.process.hotel;

import com.bhaskerStreet.hotelBooking.entities.Facility;
import com.bhaskerStreet.hotelBooking.entities.Hotel;
import com.bhaskerStreet.hotelBooking.services.facility.FacilityService;
import com.bhaskerStreet.hotelBooking.services.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelProcessServiceImpl implements HotelProcessService {

    private final HotelService hotelService;


    private final FacilityService facilityService;


    @Autowired
    public HotelProcessServiceImpl(HotelService hotelService, FacilityService facilityService) {
        this.hotelService = hotelService;
        this.facilityService = facilityService;
    }

    @Override
    public ResponseEntity<List<Hotel>> processFetchAll() {
        List<Hotel> hotels = hotelService.fetchAllAvailableHotels();

        for (Hotel hotel:hotels) {
            List<Facility> facs=facilityService.getFacilities(hotel.getFacilities());
            hotel.setFacilityList(facs);

        }


        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Hotel> processFetch(Long hotelId) {
        Hotel hotel=hotelService.fetch(hotelId);
        List<Facility> facs=facilityService.getFacilities(hotel.getFacilities());
        hotel.setFacilityList(facs);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity processDelete(Long hotelId) {

        hotelService.delete(hotelId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
