package com.stage.pfe.persistance;

public class Message {
	private Integer idMsg;
	private String nomMessage;
	private String url;
	
	
	public Message() {
		super();
	}
	public Message(Integer idMsg, String nomMessage, String url) {
		super();
		this.idMsg = idMsg;
		this.nomMessage = nomMessage;
		this.url = url;
	}
	public Integer getIdMsg() {
		return idMsg;
	}
	public void setIdMsg(Integer idMsg) {
		this.idMsg = idMsg;
	}
	public String getNomMessage() {
		return nomMessage;
	}
	public void setNomMessage(String nomMessage) {
		this.nomMessage = nomMessage;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Message [idMsg=" + idMsg + ", nomMessage=" + nomMessage
				+ ", url=" + url + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMsg == null) ? 0 : idMsg.hashCode());
		result = prime * result
				+ ((nomMessage == null) ? 0 : nomMessage.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (idMsg == null) {
			if (other.idMsg != null)
				return false;
		} else if (!idMsg.equals(other.idMsg))
			return false;
		if (nomMessage == null) {
			if (other.nomMessage != null)
				return false;
		} else if (!nomMessage.equals(other.nomMessage))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	
}
