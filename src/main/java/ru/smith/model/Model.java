package ru.smith.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@RequiredArgsConstructor
public abstract class Model implements Serializable {

    private static final long serialVersionUID = 7711242740300932601L;

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

}
