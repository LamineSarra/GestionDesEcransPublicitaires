package com.stage.pfe.persistance;

public class PlanMsg {
	private Integer idPlanMsg;
	private String plageHoraire;
	
	
	public PlanMsg() {
		super();
	}
	public PlanMsg(Integer idPlanMsg, String plageHoraire) {
		super();
		this.idPlanMsg = idPlanMsg;
		this.plageHoraire = plageHoraire;
	}
	public Integer getIdPlanMsg() {
		return idPlanMsg;
	}
	public void setIdPlanMsg(Integer idPlanMsg) {
		this.idPlanMsg = idPlanMsg;
	}
	public String getPlageHoraire() {
		return plageHoraire;
	}
	public void setPlageHoraire(String plageHoraire) {
		this.plageHoraire = plageHoraire;
	}
	@Override
	public String toString() {
		return "PlanMsg [idPlanMsg=" + idPlanMsg + ", plageHoraire="
				+ plageHoraire + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPlanMsg == null) ? 0 : idPlanMsg.hashCode());
		result = prime * result
				+ ((plageHoraire == null) ? 0 : plageHoraire.hashCode());
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
		PlanMsg other = (PlanMsg) obj;
		if (idPlanMsg == null) {
			if (other.idPlanMsg != null)
				return false;
		} else if (!idPlanMsg.equals(other.idPlanMsg))
			return false;
		if (plageHoraire == null) {
			if (other.plageHoraire != null)
				return false;
		} else if (!plageHoraire.equals(other.plageHoraire))
			return false;
		return true;
	}
	
	

}
