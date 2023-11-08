package com.avanade.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author mirco.cennamo on 08/11/2023
 * @project spring-boot-rest-jpa
 */
@MappedSuperclass
@Data
@ToString
public abstract class BaseEntity extends AbstractAuditEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;


}
