package me.hws.core.entity;

import org.springframework.data.annotation.Id;

public class SequenceId {
	
	@Id
	private String id;
	
	private Long sequence;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long dequence) {
		this.sequence = dequence;
	}

}
