package com.bhaskerStreet.hotelBooking.entities.customer;

public class CustomerCreator {


    public static class CustomerCreatorBuilder {
        private String name;
        private String emailId;
        private String phoneNumber;
        private String gender;
        private Long addressId;


        public CustomerCreatorBuilder(String name, String emailId, String phoneNumber, String gender) {
            this.name = name;
            this.emailId = emailId;
            this.phoneNumber = phoneNumber;
            this.gender = gender;
        }


        public CustomerCreatorBuilder setAddressId(Long addressId) {
            this.addressId = addressId;
            return this;
        }

        public com.bhaskerStreet.hotelBooking.entities.customer.Customer create() {
            Customer c = new Customer(this.name, this.emailId, this.phoneNumber, this.gender);
            c.setAddressId(this.addressId);
            return c;
        }


    }


}
