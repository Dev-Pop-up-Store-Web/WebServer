package com.example.web.server.member.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Id
	private Long id;

	private String account;

	private int rating;

	private String contents;

	private String popupId;

	@ManyToOne
	@JoinColumn(name = "member")
	private Member member;

	public void setMember(Member member) {
		this.member = member;
	}

}
