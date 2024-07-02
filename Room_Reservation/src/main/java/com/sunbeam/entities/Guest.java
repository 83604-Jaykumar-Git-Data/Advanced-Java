package com.sunbeam.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Guest extends BaseEntity {
	@Column(name = "first_name", length = 25)
	private String firstName;

	@Column(name = "last_name", length = 25)
	private String lastName;

	@Column(name = "Date_Of_Birth")
	private LocalDate dob;
}
