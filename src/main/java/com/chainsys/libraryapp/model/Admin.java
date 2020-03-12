package com.chainsys.libraryapp.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Admin {
private int id;
private String name;
private String mailId;
private long mobileNo;
private String gender;
private LocalDate dob;
private String password;
}
