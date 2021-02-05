package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "zip_code", nullable = true, length = 5)
    private int zipCode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    private String flat;
}
