package br.com.ntconsult.enun;

public enum StatusCPF {
	
	ABLE_TO_VOTE("Able to vote"), UNABLE_TO_VOTE("Unable to Vote");

	private String status;

	private StatusCPF(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}	

}
