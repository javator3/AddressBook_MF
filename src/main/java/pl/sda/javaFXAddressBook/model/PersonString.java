package pl.sda.javaFXAddressBook.model;

import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter

public class PersonString {

        private String name;
        private String lastname;
        private String street;
        private String city;
        private String postalcode;
        private String telephone;

        public void PersonString() {}

        public PersonString(String name, String lastname,
                      String street, String city, String postalcode, String telephone) {
            this.name = name;
            this.lastname =lastname;
            this.street = street;
            this.city = city;
            this.postalcode = postalcode;
            this.telephone = telephone;
        }

}
