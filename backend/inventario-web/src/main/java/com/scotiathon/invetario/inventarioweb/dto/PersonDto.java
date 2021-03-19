package com.scotiathon.invetario.inventarioweb.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto implements Serializable {

	private int id;
	private String name;

}
