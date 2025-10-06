package com.ggocodelab.program06.entities;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_oder")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant monument;
	private OrderStatus status;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
		
	public Order() {
	}

	public Order(Long id, Instant monument, OrderStatus status, User client) {
		this.id = id;
		this.monument = monument;
		this.status = status;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMonument() {
		return monument;
	}

	public void setMonument(Instant monument) {
		this.monument = monument;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
}
