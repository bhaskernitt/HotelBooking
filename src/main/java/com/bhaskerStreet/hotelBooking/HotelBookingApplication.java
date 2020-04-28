package com.bhaskerStreet.hotelBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = {
        "com.bhaskerStreet.hotelBooking.**"
       /* "com.harsh.hotelBooking.dtos",
        "com.harsh.hotelBooking.entities",
        "com.harsh.hotelBooking.repository",
        "com.harsh.hotelBooking.services"*/

})
@EnableWebMvc
public class HotelBookingApplication  implements ApplicationRunner {


    @Autowired
    ApplicationContext applicationContext;





    public static void main(String[] args) {
        SpringApplication.run(HotelBookingApplication.class, args);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


    }
}
