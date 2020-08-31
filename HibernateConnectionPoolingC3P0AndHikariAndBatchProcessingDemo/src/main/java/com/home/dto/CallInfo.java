package com.home.dto;

public class CallInfo {
	private Long totalNoOfcalls;
	private Long totalDistinctPhonesFromCalls;
	private Integer maxCallDuration;
	private Double avgCallDuration;
	private Long sumCallDuration;
	
	public CallInfo(Long totalNoOfcalls, Long totalDistinctPhonesFromCalls, Integer maxCallDuration,
			Double avgCallDuration, Long sumCallDuration) {
		super();
		this.totalNoOfcalls = totalNoOfcalls;
		this.totalDistinctPhonesFromCalls = totalDistinctPhonesFromCalls;
		this.maxCallDuration = maxCallDuration;
		this.avgCallDuration = avgCallDuration;
		this.sumCallDuration = sumCallDuration;
	}

	public Long getTotalNoOfcalls() {
		return totalNoOfcalls;
	}

	public Long getTotalDistinctPhonesFromCalls() {
		return totalDistinctPhonesFromCalls;
	}

	public Integer getMaxCallDuration() {
		return maxCallDuration;
	}

	public Double getAvgCallDuration() {
		return avgCallDuration;
	}

	public Long getSumCallDuration() {
		return sumCallDuration;
	}

	@Override
	public String toString() {
		return "CallInfo [totalNoOfcalls=" + totalNoOfcalls + ", totalDistinctPhonesFromCalls="
				+ totalDistinctPhonesFromCalls + ", maxCallDuration=" + maxCallDuration + ", avgCallDuration="
				+ avgCallDuration + ", sumCallDuration=" + sumCallDuration + "]";
	}
			
}
