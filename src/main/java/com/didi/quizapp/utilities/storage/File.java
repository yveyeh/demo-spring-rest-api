package com.didi.quizapp.utilities.storage;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    protected String name;

    protected String path;

    protected float size;

    protected abstract File getFileProperties(UUID id);

}
