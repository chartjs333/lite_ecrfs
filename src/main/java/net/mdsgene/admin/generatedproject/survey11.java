package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "survey11", schema = "public")
@Cacheable(false)
public class survey11 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="survey11_id_seq")
    @SequenceGenerator(name="survey11_id_seq", sequenceName="survey11_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public survey11() {
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	


	private String ecrfStatus;

	@Column(name = "ecrf_status", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEcrfStatus() {
		return ecrfStatus;
	}

	public void setEcrfStatus(String ecrfStatus) {
		this.ecrfStatus = ecrfStatus;
	}

	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, columnDefinition = "timestamp", length = 29)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

   private String surveyTwoId;

   @Column(name = "survey_two_id", nullable = true, columnDefinition = "varchar", length = 128)
   public String getSurveyTwoId() {
       return this.surveyTwoId;
   }

   public void setSurveyTwoId(String surveyTwoId) {
       this.surveyTwoId = surveyTwoId;
   }

   private String fillingStatus;

   @Column(name = "filling_status", nullable = true, columnDefinition = "varchar", length = 128)
   public String getFillingStatus() {
       return this.fillingStatus;
   }

   public void setFillingStatus(String fillingStatus) {
       this.fillingStatus = fillingStatus;
   }

	private String aliquoting;

	@Column(name = "aliquoting", nullable = true, columnDefinition = "varchar", length = 128)
	public String getAliquoting() {
		return this.aliquoting;
	}

	public void setAliquoting(String aliquoting) {
		this.aliquoting = aliquoting;
	}
	private String centrifuge;

	@Column(name = "centrifuge", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCentrifuge() {
		return this.centrifuge;
	}

	public void setCentrifuge(String centrifuge) {
		this.centrifuge = centrifuge;
	}
	private String csf;

	@Column(name = "csf", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCsf() {
		return this.csf;
	}

	public void setCsf(String csf) {
		this.csf = csf;
	}
	private String csf_com;

	@Column(name = "csf_com", nullable = true, columnDefinition = "varchar", length = 128)
	public String getCsfCom() {
		return this.csf_com;
	}

	public void setCsfCom(String csf_com) {
		this.csf_com = csf_com;
	}
	private String dat_sc_im;

	@Column(name = "dat_sc_im", nullable = true, columnDefinition = "varchar", length = 128)
	public String getDatScIm() {
		return this.dat_sc_im;
	}

	public void setDatScIm(String dat_sc_im) {
		this.dat_sc_im = dat_sc_im;
	}
	private String edta_blood;

	@Column(name = "edta_blood", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEdtaBlood() {
		return this.edta_blood;
	}

	public void setEdtaBlood(String edta_blood) {
		this.edta_blood = edta_blood;
	}
	private String edta_blood_com;

	@Column(name = "edta_blood_com", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEdtaBloodCom() {
		return this.edta_blood_com;
	}

	public void setEdtaBloodCom(String edta_blood_com) {
		this.edta_blood_com = edta_blood_com;
	}
	private String epw_sleep_sc_lang;

	@Column(name = "epw_sleep_sc_lang", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEpwSleepScLang() {
		return this.epw_sleep_sc_lang;
	}

	public void setEpwSleepScLang(String epw_sleep_sc_lang) {
		this.epw_sleep_sc_lang = epw_sleep_sc_lang;
	}
	private String epw_sleep_sc_team;

	@Column(name = "epw_sleep_sc_team", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEpwSleepScTeam() {
		return this.epw_sleep_sc_team;
	}

	public void setEpwSleepScTeam(String epw_sleep_sc_team) {
		this.epw_sleep_sc_team = epw_sleep_sc_team;
	}
	private String epw_sleep_sc_team_why;

	@Column(name = "epw_sleep_sc_team_why", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEpwSleepScTeamWhy() {
		return this.epw_sleep_sc_team_why;
	}

	public void setEpwSleepScTeamWhy(String epw_sleep_sc_team_why) {
		this.epw_sleep_sc_team_why = epw_sleep_sc_team_why;
	}
	private String freezer_20;

	@Column(name = "freezer_20", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFreezer20() {
		return this.freezer_20;
	}

	public void setFreezer20(String freezer_20) {
		this.freezer_20 = freezer_20;
	}
	private String freezer_80;

	@Column(name = "freezer_80", nullable = true, columnDefinition = "varchar", length = 128)
	public String getFreezer80() {
		return this.freezer_80;
	}

	public void setFreezer80(String freezer_80) {
		this.freezer_80 = freezer_80;
	}
	private String ger_depr_sc_lang;

	@Column(name = "ger_depr_sc_lang", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGerDeprScLang() {
		return this.ger_depr_sc_lang;
	}

	public void setGerDeprScLang(String ger_depr_sc_lang) {
		this.ger_depr_sc_lang = ger_depr_sc_lang;
	}
	private String ger_depr_sc_team;

	@Column(name = "ger_depr_sc_team", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGerDeprScTeam() {
		return this.ger_depr_sc_team;
	}

	public void setGerDeprScTeam(String ger_depr_sc_team) {
		this.ger_depr_sc_team = ger_depr_sc_team;
	}
	private String ger_depr_sc_team_why;

	@Column(name = "ger_depr_sc_team_why", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGerDeprScTeamWhy() {
		return this.ger_depr_sc_team_why;
	}

	public void setGerDeprScTeamWhy(String ger_depr_sc_team_why) {
		this.ger_depr_sc_team_why = ger_depr_sc_team_why;
	}
	private String match_contr_healthy_indiv;

	@Column(name = "match_contr_healthy_indiv", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMatchContrHealthyIndiv() {
		return this.match_contr_healthy_indiv;
	}

	public void setMatchContrHealthyIndiv(String match_contr_healthy_indiv) {
		this.match_contr_healthy_indiv = match_contr_healthy_indiv;
	}
	private String match_contr_indiv_idiop_Park;

	@Column(name = "match_contr_indiv_idiop_Park", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMatchContrIndivIdiopPark() {
		return this.match_contr_indiv_idiop_Park;
	}

	public void setMatchContrIndivIdiopPark(String match_contr_indiv_idiop_Park) {
		this.match_contr_indiv_idiop_Park = match_contr_indiv_idiop_Park;
	}
	private String moca_lang;

	@Column(name = "moca_lang", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMocaLang() {
		return this.moca_lang;
	}

	public void setMocaLang(String moca_lang) {
		this.moca_lang = moca_lang;
	}
	private String moca_team;

	@Column(name = "moca_team", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMocaTeam() {
		return this.moca_team;
	}

	public void setMocaTeam(String moca_team) {
		this.moca_team = moca_team;
	}
	private String moca_team_why;

	@Column(name = "moca_team_why", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMocaTeamWhy() {
		return this.moca_team_why;
	}

	public void setMocaTeamWhy(String moca_team_why) {
		this.moca_team_why = moca_team_why;
	}
	private String mri_brain;

	@Column(name = "mri_brain", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMriBrain() {
		return this.mri_brain;
	}

	public void setMriBrain(String mri_brain) {
		this.mri_brain = mri_brain;
	}
	private String mri_brain_name;

	@Column(name = "mri_brain_name", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMriBrainName() {
		return this.mri_brain_name;
	}

	public void setMriBrainName(String mri_brain_name) {
		this.mri_brain_name = mri_brain_name;
	}
	private String mri_brain_str;

	@Column(name = "mri_brain_str", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMriBrainStr() {
		return this.mri_brain_str;
	}

	public void setMriBrainStr(String mri_brain_str) {
		this.mri_brain_str = mri_brain_str;
	}
	private String num_new;

	@Column(name = "num_new", nullable = true, columnDefinition = "varchar", length = 128)
	public String getNumNew() {
		return this.num_new;
	}

	public void setNumNew(String num_new) {
		this.num_new = num_new;
	}
	private String pbmc;

	@Column(name = "pbmc", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPbmc() {
		return this.pbmc;
	}

	public void setPbmc(String pbmc) {
		this.pbmc = pbmc;
	}
	private String pbmcs;

	@Column(name = "pbmcs", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPbmcs() {
		return this.pbmcs;
	}

	public void setPbmcs(String pbmcs) {
		this.pbmcs = pbmcs;
	}
	private String pbmcs_com;

	@Column(name = "pbmcs_com", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPbmcsCom() {
		return this.pbmcs_com;
	}

	public void setPbmcsCom(String pbmcs_com) {
		this.pbmcs_com = pbmcs_com;
	}
	private String quip_lang;

	@Column(name = "quip_lang", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuipLang() {
		return this.quip_lang;
	}

	public void setQuipLang(String quip_lang) {
		this.quip_lang = quip_lang;
	}
	private String quip_team;

	@Column(name = "quip_team", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuipTeam() {
		return this.quip_team;
	}

	public void setQuipTeam(String quip_team) {
		this.quip_team = quip_team;
	}
	private String quip_team_why;

	@Column(name = "quip_team_why", nullable = true, columnDefinition = "varchar", length = 128)
	public String getQuipTeamWhy() {
		return this.quip_team_why;
	}

	public void setQuipTeamWhy(String quip_team_why) {
		this.quip_team_why = quip_team_why;
	}
	private String rbd_lang;

	@Column(name = "rbd_lang", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdLang() {
		return this.rbd_lang;
	}

	public void setRbdLang(String rbd_lang) {
		this.rbd_lang = rbd_lang;
	}
	private String rbd_team;

	@Column(name = "rbd_team", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdTeam() {
		return this.rbd_team;
	}

	public void setRbdTeam(String rbd_team) {
		this.rbd_team = rbd_team;
	}
	private String rbd_team_why;

	@Column(name = "rbd_team_why", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRbdTeamWhy() {
		return this.rbd_team_why;
	}

	public void setRbdTeamWhy(String rbd_team_why) {
		this.rbd_team_why = rbd_team_why;
	}
	private String rna;

	@Column(name = "rna", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRna() {
		return this.rna;
	}

	public void setRna(String rna) {
		this.rna = rna;
	}
	private String rna_com;

	@Column(name = "rna_com", nullable = true, columnDefinition = "varchar", length = 128)
	public String getRnaCom() {
		return this.rna_com;
	}

	public void setRnaCom(String rna_com) {
		this.rna_com = rna_com;
	}
	private String scopa_aut_lang;

	@Column(name = "scopa_aut_lang", nullable = true, columnDefinition = "varchar", length = 128)
	public String getScopaAutLang() {
		return this.scopa_aut_lang;
	}

	public void setScopaAutLang(String scopa_aut_lang) {
		this.scopa_aut_lang = scopa_aut_lang;
	}
	private String scopa_aut_team;

	@Column(name = "scopa_aut_team", nullable = true, columnDefinition = "varchar", length = 128)
	public String getScopaAutTeam() {
		return this.scopa_aut_team;
	}

	public void setScopaAutTeam(String scopa_aut_team) {
		this.scopa_aut_team = scopa_aut_team;
	}
	private String scopa_aut_team_why;

	@Column(name = "scopa_aut_team_why", nullable = true, columnDefinition = "varchar", length = 128)
	public String getScopaAutTeamWhy() {
		return this.scopa_aut_team_why;
	}

	public void setScopaAutTeamWhy(String scopa_aut_team_why) {
		this.scopa_aut_team_why = scopa_aut_team_why;
	}
	private String ser_blood;

	@Column(name = "ser_blood", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSerBlood() {
		return this.ser_blood;
	}

	public void setSerBlood(String ser_blood) {
		this.ser_blood = ser_blood;
	}
	private String ser_blood_com;

	@Column(name = "ser_blood_com", nullable = true, columnDefinition = "varchar", length = 128)
	public String getSerBloodCom() {
		return this.ser_blood_com;
	}

	public void setSerBloodCom(String ser_blood_com) {
		this.ser_blood_com = ser_blood_com;
	}
	private String st_tr_anx_inv_lang;

	@Column(name = "st_tr_anx_inv_lang", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStTrAnxInvLang() {
		return this.st_tr_anx_inv_lang;
	}

	public void setStTrAnxInvLang(String st_tr_anx_inv_lang) {
		this.st_tr_anx_inv_lang = st_tr_anx_inv_lang;
	}
	private String st_tr_anx_inv_team;

	@Column(name = "st_tr_anx_inv_team", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStTrAnxInvTeam() {
		return this.st_tr_anx_inv_team;
	}

	public void setStTrAnxInvTeam(String st_tr_anx_inv_team) {
		this.st_tr_anx_inv_team = st_tr_anx_inv_team;
	}
	private String st_tr_anx_inv_team_why;

	@Column(name = "st_tr_anx_inv_team_why", nullable = true, columnDefinition = "varchar", length = 128)
	public String getStTrAnxInvTeamWhy() {
		return this.st_tr_anx_inv_team_why;
	}

	public void setStTrAnxInvTeamWhy(String st_tr_anx_inv_team_why) {
		this.st_tr_anx_inv_team_why = st_tr_anx_inv_team_why;
	}
	private String upsit_lang;

	@Column(name = "upsit_lang", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsitLang() {
		return this.upsit_lang;
	}

	public void setUpsitLang(String upsit_lang) {
		this.upsit_lang = upsit_lang;
	}
	private String upsit_team;

	@Column(name = "upsit_team", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsitTeam() {
		return this.upsit_team;
	}

	public void setUpsitTeam(String upsit_team) {
		this.upsit_team = upsit_team;
	}
	private String upsit_team_why;

	@Column(name = "upsit_team_why", nullable = true, columnDefinition = "varchar", length = 128)
	public String getUpsitTeamWhy() {
		return this.upsit_team_why;
	}

	public void setUpsitTeamWhy(String upsit_team_why) {
		this.upsit_team_why = upsit_team_why;
	}
}
