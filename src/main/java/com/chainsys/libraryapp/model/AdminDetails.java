package com.chainsys.libraryapp.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class AdminDetails {
private int adminId;
private String adminName;
private String adminMailId;
private long adminMobileNo;
private String adminGender;
private LocalDate adminDOB;
private String adminPassword;
}
