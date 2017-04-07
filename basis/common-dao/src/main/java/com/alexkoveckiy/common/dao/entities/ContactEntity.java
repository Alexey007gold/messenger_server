package com.alexkoveckiy.common.dao.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by alex on 05.03.17.
 */

@Entity
@Table(name = "contact")
public class ContactEntity extends BaseEntity {

    private static final long serialVersionUID = -7753889542769024084L;

    //Whose contact it is
    private String profileId;

    //Contact name
    private String name;

    //Contact numbers
    @ElementCollection
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "contact_number",
            joinColumns = @JoinColumn(name = "contactId"),
            inverseJoinColumns = @JoinColumn(name = "numberId"))
    private Set<NumberEntity> numbers;

    public ContactEntity() {
    }

    public ContactEntity(String profileId, String name, Set<NumberEntity> numbers) {
        this.profileId = profileId;
        this.name = name;
        this.numbers = numbers;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<NumberEntity> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<NumberEntity> numbers) {
        this.numbers = numbers;
    }
}
