package com.example.web.server.detail.domain.info;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class DetailInfo {
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private List<String> openTimes;
	private String region;
	private String address;
	private int ticketPrice;
	private boolean parkingAvailability;
}
