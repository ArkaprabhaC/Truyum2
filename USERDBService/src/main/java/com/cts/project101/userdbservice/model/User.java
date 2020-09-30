package com.cts.project101.userdbservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="user_id")
	long userId;
	
	@Column(name="first_name")
	@NotBlank(message = "First Name cannot be blank!")
	String firstName;
	
	
	@Column(name="last_name")
	String lastName;
	
	@Email(message = "Please enter a valid email ID!")
	@NotBlank(message = "Email ID cannot be blank!")
	@Column(name="email_id", unique = true)
	String emailId;
	
	@NotBlank(message = "Username cannot be blank!")
	@Column(name="username",unique = true)
	String username;
	
	@NotBlank(message = "Password cannot be blank!")
	@Column(name="password")
	String password;
	
	@Column(name="role")
	Role role;
}
