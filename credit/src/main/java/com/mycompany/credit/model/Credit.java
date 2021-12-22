package com.mycompany.credit.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Credit {

    public Credit(String creditName) {
        this.creditName = creditName;
    }

    @Id
    @SequenceGenerator(
            name = "credit_id_sequence",
            sequenceName = "credit_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "credit_id_sequence"
    )
    @Column(name = "id", nullable = false)
    private Long id;

    private String creditName;


}
