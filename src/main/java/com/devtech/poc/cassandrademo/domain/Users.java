package com.devtech.poc.cassandrademo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Getter
@Setter
public class Users {
    @PrimaryKey
    private UUID id;
    private String first_name;
    private String last_name;
    private String email;
}