package com.gokuecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(name = "user_id")
    private long id;

	@NotBlank
	@Column(length = 20 )
    private String zipCode;

    @NotBlank
	@Column(length = 150)
    private String street;

    @NotBlank
	@Column(length = 150)
    private String neighborhood;

    @NotBlank
	@Column(length = 150)
    private String city;

    @NotBlank
	@Column(length = 100)
    private String state;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
