package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN119", schema = "public")
@Cacheable(false)
public class PINK1PRKN119 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN119_id_seq")
    @SequenceGenerator(name="PINK1PRKN119_id_seq", sequenceName="PINK1PRKN119_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN119() {
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	private String mdsupdrs_3_ac;

	@Column(name = "mdsupdrs_3_ac", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_ac() {
		return this.mdsupdrs_3_ac;
	}

	public void setMdsupdrs_3_ac(String mdsupdrs_3_ac) {
		this.mdsupdrs_3_ac = mdsupdrs_3_ac;
	}
	private String mdsupdrs_3_bb;

	@Column(name = "mdsupdrs_3_bb", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_bb() {
		return this.mdsupdrs_3_bb;
	}

	public void setMdsupdrs_3_bb(String mdsupdrs_3_bb) {
		this.mdsupdrs_3_bb = mdsupdrs_3_bb;
	}
	private String mdsupdrs_3_c_rtm;

	@Column(name = "mdsupdrs_3_c_rtm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_c_rtm() {
		return this.mdsupdrs_3_c_rtm;
	}

	public void setMdsupdrs_3_c_rtm(String mdsupdrs_3_c_rtm) {
		this.mdsupdrs_3_c_rtm = mdsupdrs_3_c_rtm;
	}
	private String mdsupdrs_3_clinstat;

	@Column(name = "mdsupdrs_3_clinstat", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_clinstat() {
		return this.mdsupdrs_3_clinstat;
	}

	public void setMdsupdrs_3_clinstat(String mdsupdrs_3_clinstat) {
		this.mdsupdrs_3_clinstat = mdsupdrs_3_clinstat;
	}
	private String mdsupdrs_3_dk_e;

	@Column(name = "mdsupdrs_3_dk_e", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_dk_e() {
		return this.mdsupdrs_3_dk_e;
	}

	public void setMdsupdrs_3_dk_e(String mdsupdrs_3_dk_e) {
		this.mdsupdrs_3_dk_e = mdsupdrs_3_dk_e;
	}
	private String mdsupdrs_3_dk_e_r;

	@Column(name = "mdsupdrs_3_dk_e_r", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_dk_e_r() {
		return this.mdsupdrs_3_dk_e_r;
	}

	public void setMdsupdrs_3_dk_e_r(String mdsupdrs_3_dk_e_r) {
		this.mdsupdrs_3_dk_e_r = mdsupdrs_3_dk_e_r;
	}
	private String mdsupdrs_3_f_gait;

	@Column(name = "mdsupdrs_3_f_gait", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_f_gait() {
		return this.mdsupdrs_3_f_gait;
	}

	public void setMdsupdrs_3_f_gait(String mdsupdrs_3_f_gait) {
		this.mdsupdrs_3_f_gait = mdsupdrs_3_f_gait;
	}
	private String mdsupdrs_3_fac;

	@Column(name = "mdsupdrs_3_fac", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_fac() {
		return this.mdsupdrs_3_fac;
	}

	public void setMdsupdrs_3_fac(String mdsupdrs_3_fac) {
		this.mdsupdrs_3_fac = mdsupdrs_3_fac;
	}
	private String mdsupdrs_3_ft_l;

	@Column(name = "mdsupdrs_3_ft_l", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_ft_l() {
		return this.mdsupdrs_3_ft_l;
	}

	public void setMdsupdrs_3_ft_l(String mdsupdrs_3_ft_l) {
		this.mdsupdrs_3_ft_l = mdsupdrs_3_ft_l;
	}
	private String mdsupdrs_3_ft_r;

	@Column(name = "mdsupdrs_3_ft_r", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_ft_r() {
		return this.mdsupdrs_3_ft_r;
	}

	public void setMdsupdrs_3_ft_r(String mdsupdrs_3_ft_r) {
		this.mdsupdrs_3_ft_r = mdsupdrs_3_ft_r;
	}
	private String mdsupdrs_3_gait;

	@Column(name = "mdsupdrs_3_gait", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_gait() {
		return this.mdsupdrs_3_gait;
	}

	public void setMdsupdrs_3_gait(String mdsupdrs_3_gait) {
		this.mdsupdrs_3_gait = mdsupdrs_3_gait;
	}
	private String mdsupdrs_3_hm_l;

	@Column(name = "mdsupdrs_3_hm_l", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_hm_l() {
		return this.mdsupdrs_3_hm_l;
	}

	public void setMdsupdrs_3_hm_l(String mdsupdrs_3_hm_l) {
		this.mdsupdrs_3_hm_l = mdsupdrs_3_hm_l;
	}
	private String mdsupdrs_3_hm_r;

	@Column(name = "mdsupdrs_3_hm_r", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_hm_r() {
		return this.mdsupdrs_3_hm_r;
	}

	public void setMdsupdrs_3_hm_r(String mdsupdrs_3_hm_r) {
		this.mdsupdrs_3_hm_r = mdsupdrs_3_hm_r;
	}
	private String mdsupdrs_3_ktm_l;

	@Column(name = "mdsupdrs_3_ktm_l", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_ktm_l() {
		return this.mdsupdrs_3_ktm_l;
	}

	public void setMdsupdrs_3_ktm_l(String mdsupdrs_3_ktm_l) {
		this.mdsupdrs_3_ktm_l = mdsupdrs_3_ktm_l;
	}
	private String mdsupdrs_3_ktm_r;

	@Column(name = "mdsupdrs_3_ktm_r", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_ktm_r() {
		return this.mdsupdrs_3_ktm_r;
	}

	public void setMdsupdrs_3_ktm_r(String mdsupdrs_3_ktm_r) {
		this.mdsupdrs_3_ktm_r = mdsupdrs_3_ktm_r;
	}
	private String mdsupdrs_3_la_l;

	@Column(name = "mdsupdrs_3_la_l", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_la_l() {
		return this.mdsupdrs_3_la_l;
	}

	public void setMdsupdrs_3_la_l(String mdsupdrs_3_la_l) {
		this.mdsupdrs_3_la_l = mdsupdrs_3_la_l;
	}
	private String mdsupdrs_3_la_r;

	@Column(name = "mdsupdrs_3_la_r", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_la_r() {
		return this.mdsupdrs_3_la_r;
	}

	public void setMdsupdrs_3_la_r(String mdsupdrs_3_la_r) {
		this.mdsupdrs_3_la_r = mdsupdrs_3_la_r;
	}
	private String mdsupdrs_3_on;

	@Column(name = "mdsupdrs_3_on", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_on() {
		return this.mdsupdrs_3_on;
	}

	public void setMdsupdrs_3_on(String mdsupdrs_3_on) {
		this.mdsupdrs_3_on = mdsupdrs_3_on;
	}
	private String mdsupdrs_3_on_min;

	@Column(name = "mdsupdrs_3_on_min", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_on_min() {
		return this.mdsupdrs_3_on_min;
	}

	public void setMdsupdrs_3_on_min(String mdsupdrs_3_on_min) {
		this.mdsupdrs_3_on_min = mdsupdrs_3_on_min;
	}
	private String mdsupdrs_3_p;

	@Column(name = "mdsupdrs_3_p", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_p() {
		return this.mdsupdrs_3_p;
	}

	public void setMdsupdrs_3_p(String mdsupdrs_3_p) {
		this.mdsupdrs_3_p = mdsupdrs_3_p;
	}
	private String mdsupdrs_3_pdmed;

	@Column(name = "mdsupdrs_3_pdmed", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_pdmed() {
		return this.mdsupdrs_3_pdmed;
	}

	public void setMdsupdrs_3_pdmed(String mdsupdrs_3_pdmed) {
		this.mdsupdrs_3_pdmed = mdsupdrs_3_pdmed;
	}
	private String mdsupdrs_3_pm_l;

	@Column(name = "mdsupdrs_3_pm_l", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_pm_l() {
		return this.mdsupdrs_3_pm_l;
	}

	public void setMdsupdrs_3_pm_l(String mdsupdrs_3_pm_l) {
		this.mdsupdrs_3_pm_l = mdsupdrs_3_pm_l;
	}
	private String mdsupdrs_3_pm_r;

	@Column(name = "mdsupdrs_3_pm_r", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_pm_r() {
		return this.mdsupdrs_3_pm_r;
	}

	public void setMdsupdrs_3_pm_r(String mdsupdrs_3_pm_r) {
		this.mdsupdrs_3_pm_r = mdsupdrs_3_pm_r;
	}
	private String mdsupdrs_3_ps;

	@Column(name = "mdsupdrs_3_ps", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_ps() {
		return this.mdsupdrs_3_ps;
	}

	public void setMdsupdrs_3_ps(String mdsupdrs_3_ps) {
		this.mdsupdrs_3_ps = mdsupdrs_3_ps;
	}
	private String mdsupdrs_3_ptm_l;

	@Column(name = "mdsupdrs_3_ptm_l", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_ptm_l() {
		return this.mdsupdrs_3_ptm_l;
	}

	public void setMdsupdrs_3_ptm_l(String mdsupdrs_3_ptm_l) {
		this.mdsupdrs_3_ptm_l = mdsupdrs_3_ptm_l;
	}
	private String mdsupdrs_3_ptm_r;

	@Column(name = "mdsupdrs_3_ptm_r", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_ptm_r() {
		return this.mdsupdrs_3_ptm_r;
	}

	public void setMdsupdrs_3_ptm_r(String mdsupdrs_3_ptm_r) {
		this.mdsupdrs_3_ptm_r = mdsupdrs_3_ptm_r;
	}
	private String mdsupdrs_3_rd_lle;

	@Column(name = "mdsupdrs_3_rd_lle", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_rd_lle() {
		return this.mdsupdrs_3_rd_lle;
	}

	public void setMdsupdrs_3_rd_lle(String mdsupdrs_3_rd_lle) {
		this.mdsupdrs_3_rd_lle = mdsupdrs_3_rd_lle;
	}
	private String mdsupdrs_3_rd_lue;

	@Column(name = "mdsupdrs_3_rd_lue", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_rd_lue() {
		return this.mdsupdrs_3_rd_lue;
	}

	public void setMdsupdrs_3_rd_lue(String mdsupdrs_3_rd_lue) {
		this.mdsupdrs_3_rd_lue = mdsupdrs_3_rd_lue;
	}
	private String mdsupdrs_3_rd_n;

	@Column(name = "mdsupdrs_3_rd_n", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_rd_n() {
		return this.mdsupdrs_3_rd_n;
	}

	public void setMdsupdrs_3_rd_n(String mdsupdrs_3_rd_n) {
		this.mdsupdrs_3_rd_n = mdsupdrs_3_rd_n;
	}
	private String mdsupdrs_3_rd_rle;

	@Column(name = "mdsupdrs_3_rd_rle", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_rd_rle() {
		return this.mdsupdrs_3_rd_rle;
	}

	public void setMdsupdrs_3_rd_rle(String mdsupdrs_3_rd_rle) {
		this.mdsupdrs_3_rd_rle = mdsupdrs_3_rd_rle;
	}
	private String mdsupdrs_3_rd_rue;

	@Column(name = "mdsupdrs_3_rd_rue", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_rd_rue() {
		return this.mdsupdrs_3_rd_rue;
	}

	public void setMdsupdrs_3_rd_rue(String mdsupdrs_3_rd_rue) {
		this.mdsupdrs_3_rd_rue = mdsupdrs_3_rd_rue;
	}
	private String mdsupdrs_3_rtm_lj;

	@Column(name = "mdsupdrs_3_rtm_lj", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_rtm_lj() {
		return this.mdsupdrs_3_rtm_lj;
	}

	public void setMdsupdrs_3_rtm_lj(String mdsupdrs_3_rtm_lj) {
		this.mdsupdrs_3_rtm_lj = mdsupdrs_3_rtm_lj;
	}
	private String mdsupdrs_3_rtm_lle;

	@Column(name = "mdsupdrs_3_rtm_lle", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_rtm_lle() {
		return this.mdsupdrs_3_rtm_lle;
	}

	public void setMdsupdrs_3_rtm_lle(String mdsupdrs_3_rtm_lle) {
		this.mdsupdrs_3_rtm_lle = mdsupdrs_3_rtm_lle;
	}
	private String mdsupdrs_3_rtm_lue;

	@Column(name = "mdsupdrs_3_rtm_lue", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_rtm_lue() {
		return this.mdsupdrs_3_rtm_lue;
	}

	public void setMdsupdrs_3_rtm_lue(String mdsupdrs_3_rtm_lue) {
		this.mdsupdrs_3_rtm_lue = mdsupdrs_3_rtm_lue;
	}
	private String mdsupdrs_3_rtm_rle;

	@Column(name = "mdsupdrs_3_rtm_rle", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_rtm_rle() {
		return this.mdsupdrs_3_rtm_rle;
	}

	public void setMdsupdrs_3_rtm_rle(String mdsupdrs_3_rtm_rle) {
		this.mdsupdrs_3_rtm_rle = mdsupdrs_3_rtm_rle;
	}
	private String mdsupdrs_3_rtm_rue;

	@Column(name = "mdsupdrs_3_rtm_rue", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_rtm_rue() {
		return this.mdsupdrs_3_rtm_rue;
	}

	public void setMdsupdrs_3_rtm_rue(String mdsupdrs_3_rtm_rue) {
		this.mdsupdrs_3_rtm_rue = mdsupdrs_3_rtm_rue;
	}
	private String mdsupdrs_3_spe;

	@Column(name = "mdsupdrs_3_spe", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_spe() {
		return this.mdsupdrs_3_spe;
	}

	public void setMdsupdrs_3_spe(String mdsupdrs_3_spe) {
		this.mdsupdrs_3_spe = mdsupdrs_3_spe;
	}
	private String mdsupdrs_3_tt_l;

	@Column(name = "mdsupdrs_3_tt_l", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_tt_l() {
		return this.mdsupdrs_3_tt_l;
	}

	public void setMdsupdrs_3_tt_l(String mdsupdrs_3_tt_l) {
		this.mdsupdrs_3_tt_l = mdsupdrs_3_tt_l;
	}
	private String mdsupdrs_3_tt_r;

	@Column(name = "mdsupdrs_3_tt_r", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_3_tt_r() {
		return this.mdsupdrs_3_tt_r;
	}

	public void setMdsupdrs_3_tt_r(String mdsupdrs_3_tt_r) {
		this.mdsupdrs_3_tt_r = mdsupdrs_3_tt_r;
	}


	public String getStatusColor() {
		// Проверяем, заполнены ли все обязательные поля
		boolean allCompleted = areAllFieldsCompleted();

		if (allCompleted) {
			return "green"; // Все поля заполнены
		} else if (isAtLeastOneFieldCompleted()) {
			return "orange"; // Некоторые поля заполнены
		} else {
			return "blue"; // Ни одно поле не заполнено
		}
	}

	private boolean areAllFieldsCompleted() {
		// Основные поля, которые всегда проверяются
		boolean mainFieldsCompleted = !isEmpty(this.surveyTwoId) &&
				!isEmpty(this.fillingStatus) &&
				!isEmpty(this.mdsupdrs_3_ac) &&
				!isEmpty(this.mdsupdrs_3_bb) &&
				!isEmpty(this.mdsupdrs_3_c_rtm) &&
				!isEmpty(this.mdsupdrs_3_clinstat) &&
				!isEmpty(this.mdsupdrs_3_dk_e) &&
				!isEmpty(this.mdsupdrs_3_f_gait) &&
				!isEmpty(this.mdsupdrs_3_fac) &&
				!isEmpty(this.mdsupdrs_3_ft_l) &&
				!isEmpty(this.mdsupdrs_3_ft_r) &&
				!isEmpty(this.mdsupdrs_3_gait) &&
				!isEmpty(this.mdsupdrs_3_hm_l) &&
				!isEmpty(this.mdsupdrs_3_hm_r) &&
				!isEmpty(this.mdsupdrs_3_ktm_l) &&
				!isEmpty(this.mdsupdrs_3_ktm_r) &&
				!isEmpty(this.mdsupdrs_3_la_l) &&
				!isEmpty(this.mdsupdrs_3_la_r) &&
				!isEmpty(this.mdsupdrs_3_on) &&
				!isEmpty(this.mdsupdrs_3_p) &&
				!isEmpty(this.mdsupdrs_3_pdmed) &&
				!isEmpty(this.mdsupdrs_3_pm_l) &&
				!isEmpty(this.mdsupdrs_3_pm_r) &&
				!isEmpty(this.mdsupdrs_3_ps) &&
				!isEmpty(this.mdsupdrs_3_ptm_l) &&
				!isEmpty(this.mdsupdrs_3_ptm_r) &&
				!isEmpty(this.mdsupdrs_3_rd_lle) &&
				!isEmpty(this.mdsupdrs_3_rd_lue) &&
				!isEmpty(this.mdsupdrs_3_rd_n) &&
				!isEmpty(this.mdsupdrs_3_rd_rle) &&
				!isEmpty(this.mdsupdrs_3_rd_rue) &&
				!isEmpty(this.mdsupdrs_3_rtm_lj) &&
				!isEmpty(this.mdsupdrs_3_rtm_lle) &&
				!isEmpty(this.mdsupdrs_3_rtm_lue) &&
				!isEmpty(this.mdsupdrs_3_rtm_rle) &&
				!isEmpty(this.mdsupdrs_3_rtm_rue) &&
				!isEmpty(this.mdsupdrs_3_spe) &&
				!isEmpty(this.mdsupdrs_3_tt_l) &&
				!isEmpty(this.mdsupdrs_3_tt_r);

		// Проверяем условные поля, если их условия выполнены
		boolean conditionalFieldsCompleted = true;

		if ("Yes".equalsIgnoreCase(this.mdsupdrs_3_dk_e)) {
			conditionalFieldsCompleted &= !isEmpty(this.mdsupdrs_3_dk_e_r);
		}

		if ("Yes".equalsIgnoreCase(this.mdsupdrs_3_on)) {
			conditionalFieldsCompleted &= !isEmpty(this.mdsupdrs_3_on_min);
		}

		return mainFieldsCompleted && conditionalFieldsCompleted;
	}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно из основных полей
		boolean mainFieldsCompleted = !isEmpty(this.surveyTwoId) ||
				!isEmpty(this.fillingStatus) ||
				!isEmpty(this.mdsupdrs_3_ac) ||
				!isEmpty(this.mdsupdrs_3_bb) ||
				!isEmpty(this.mdsupdrs_3_c_rtm) ||
				!isEmpty(this.mdsupdrs_3_clinstat) ||
				!isEmpty(this.mdsupdrs_3_dk_e) ||
				!isEmpty(this.mdsupdrs_3_f_gait) ||
				!isEmpty(this.mdsupdrs_3_fac) ||
				!isEmpty(this.mdsupdrs_3_ft_l) ||
				!isEmpty(this.mdsupdrs_3_ft_r) ||
				!isEmpty(this.mdsupdrs_3_gait) ||
				!isEmpty(this.mdsupdrs_3_hm_l) ||
				!isEmpty(this.mdsupdrs_3_hm_r) ||
				!isEmpty(this.mdsupdrs_3_ktm_l) ||
				!isEmpty(this.mdsupdrs_3_ktm_r) ||
				!isEmpty(this.mdsupdrs_3_la_l) ||
				!isEmpty(this.mdsupdrs_3_la_r) ||
				!isEmpty(this.mdsupdrs_3_on) ||
				!isEmpty(this.mdsupdrs_3_p) ||
				!isEmpty(this.mdsupdrs_3_pdmed) ||
				!isEmpty(this.mdsupdrs_3_pm_l) ||
				!isEmpty(this.mdsupdrs_3_pm_r) ||
				!isEmpty(this.mdsupdrs_3_ps) ||
				!isEmpty(this.mdsupdrs_3_ptm_l) ||
				!isEmpty(this.mdsupdrs_3_ptm_r) ||
				!isEmpty(this.mdsupdrs_3_rd_lle) ||
				!isEmpty(this.mdsupdrs_3_rd_lue) ||
				!isEmpty(this.mdsupdrs_3_rd_n) ||
				!isEmpty(this.mdsupdrs_3_rd_rle) ||
				!isEmpty(this.mdsupdrs_3_rd_rue) ||
				!isEmpty(this.mdsupdrs_3_rtm_lj) ||
				!isEmpty(this.mdsupdrs_3_rtm_lle) ||
				!isEmpty(this.mdsupdrs_3_rtm_lue) ||
				!isEmpty(this.mdsupdrs_3_rtm_rle) ||
				!isEmpty(this.mdsupdrs_3_rtm_rue) ||
				!isEmpty(this.mdsupdrs_3_spe) ||
				!isEmpty(this.mdsupdrs_3_tt_l) ||
				!isEmpty(this.mdsupdrs_3_tt_r);

		// Проверяем условные поля, если их условия выполнены
		boolean conditionalFieldsCompleted = false;

		if ("Yes".equalsIgnoreCase(this.mdsupdrs_3_dk_e)) {
			conditionalFieldsCompleted |= !isEmpty(this.mdsupdrs_3_dk_e_r);
}

		if ("Yes".equalsIgnoreCase(this.mdsupdrs_3_on)) {
			conditionalFieldsCompleted |= !isEmpty(this.mdsupdrs_3_on_min);
		}

		return mainFieldsCompleted || conditionalFieldsCompleted;
	}

	private boolean isEmpty(String value) {
		// Проверяем, является ли строка пустой или null
		return value == null || value.trim().isEmpty();
	}
}

//green if all items completed, orange if some but not all, blue if none are completed
