package net.mdsgene.admin.generatedproject;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN12", schema = "public")
@Cacheable(false)
public class PINK1PRKN12 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN12_id_seq")
    @SequenceGenerator(name="PINK1PRKN12_id_seq", sequenceName="PINK1PRKN12_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN12() {
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

	private String PPMI_ID;

	@Column(name = "PPMI_ID", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPPMI_ID() {
		return this.PPMI_ID;
	}

	public void setPPMI_ID(String PPMI_ID) {
		this.PPMI_ID = PPMI_ID;
	}
	private String ex_hc_ex;

	@Column(name = "ex_hc_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEx_hc_ex() {
		return this.ex_hc_ex;
	}

	public void setEx_hc_ex(String ex_hc_ex) {
		this.ex_hc_ex = ex_hc_ex;
	}
	private String ex_hc_monogenic;

	@Column(name = "ex_hc_monogenic", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEx_hc_monogenic() {
		return this.ex_hc_monogenic;
	}

	public void setEx_hc_monogenic(String ex_hc_monogenic) {
		this.ex_hc_monogenic = ex_hc_monogenic;
	}
	private String ex_hc_mri_neuro;

	@Column(name = "ex_hc_mri_neuro", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEx_hc_mri_neuro() {
		return this.ex_hc_mri_neuro;
	}

	public void setEx_hc_mri_neuro(String ex_hc_mri_neuro) {
		this.ex_hc_mri_neuro = ex_hc_mri_neuro;
	}
	private String ex_hc_neuro;

	@Column(name = "ex_hc_neuro", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEx_hc_neuro() {
		return this.ex_hc_neuro;
	}

	public void setEx_hc_neuro(String ex_hc_neuro) {
		this.ex_hc_neuro = ex_hc_neuro;
	}
	private String ex_ipd_ex;

	@Column(name = "ex_ipd_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEx_ipd_ex() {
		return this.ex_ipd_ex;
	}

	public void setEx_ipd_ex(String ex_ipd_ex) {
		this.ex_ipd_ex = ex_ipd_ex;
	}
	private String ex_ipd_monogenic;

	@Column(name = "ex_ipd_monogenic", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEx_ipd_monogenic() {
		return this.ex_ipd_monogenic;
	}

	public void setEx_ipd_monogenic(String ex_ipd_monogenic) {
		this.ex_ipd_monogenic = ex_ipd_monogenic;
	}
	private String ex_ipd_symptomatic;

	@Column(name = "ex_ipd_symptomatic", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEx_ipd_symptomatic() {
		return this.ex_ipd_symptomatic;
	}

	public void setEx_ipd_symptomatic(String ex_ipd_symptomatic) {
		this.ex_ipd_symptomatic = ex_ipd_symptomatic;
	}
	private String ex_ipd_var;

	@Column(name = "ex_ipd_var", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEx_ipd_var() {
		return this.ex_ipd_var;
	}

	public void setEx_ipd_var(String ex_ipd_var) {
		this.ex_ipd_var = ex_ipd_var;
	}
	private String ex_mitopd_ex;

	@Column(name = "ex_mitopd_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEx_mitopd_ex() {
		return this.ex_mitopd_ex;
	}

	public void setEx_mitopd_ex(String ex_mitopd_ex) {
		this.ex_mitopd_ex = ex_mitopd_ex;
	}
	private String ex_mitopd_symptomatic;

	@Column(name = "ex_mitopd_symptomatic", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEx_mitopd_symptomatic() {
		return this.ex_mitopd_symptomatic;
	}

	public void setEx_mitopd_symptomatic(String ex_mitopd_symptomatic) {
		this.ex_mitopd_symptomatic = ex_mitopd_symptomatic;
	}
	private String ex_unaff_ex;

	@Column(name = "ex_unaff_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEx_unaff_ex() {
		return this.ex_unaff_ex;
	}

	public void setEx_unaff_ex(String ex_unaff_ex) {
		this.ex_unaff_ex = ex_unaff_ex;
	}
	private String ex_unaff_mri_neuro;

	@Column(name = "ex_unaff_mri_neuro", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEx_unaff_mri_neuro() {
		return this.ex_unaff_mri_neuro;
	}

	public void setEx_unaff_mri_neuro(String ex_unaff_mri_neuro) {
		this.ex_unaff_mri_neuro = ex_unaff_mri_neuro;
	}
	private String ex_unaff_neuro;

	@Column(name = "ex_unaff_neuro", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEx_unaff_neuro() {
		return this.ex_unaff_neuro;
	}

	public void setEx_unaff_neuro(String ex_unaff_neuro) {
		this.ex_unaff_neuro = ex_unaff_neuro;
	}
	private String gp2_part;

	@Column(name = "gp2_part", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGp2_part() {
		return this.gp2_part;
	}

	public void setGp2_part(String gp2_part) {
		this.gp2_part = gp2_part;
	}
	private String in_cat;

	@Column(name = "in_cat", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_cat() {
		return this.in_cat;
	}

	public void setIn_cat(String in_cat) {
		this.in_cat = in_cat;
	}
	private String in_hc_age;

	@Column(name = "in_hc_age", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_hc_age() {
		return this.in_hc_age;
	}

	public void setIn_hc_age(String in_hc_age) {
		this.in_hc_age = in_hc_age;
	}
	private String in_hc_ic;

	@Column(name = "in_hc_ic", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_hc_ic() {
		return this.in_hc_ic;
	}

	public void setIn_hc_ic(String in_hc_ic) {
		this.in_hc_ic = in_hc_ic;
	}
	private String in_hc_match;

	@Column(name = "in_hc_match", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_hc_match() {
		return this.in_hc_match;
	}

	public void setIn_hc_match(String in_hc_match) {
		this.in_hc_match = in_hc_match;
	}
	private String in_ipd_age;

	@Column(name = "in_ipd_age", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_ipd_age() {
		return this.in_ipd_age;
	}

	public void setIn_ipd_age(String in_ipd_age) {
		this.in_ipd_age = in_ipd_age;
	}
	private String in_ipd_dx;

	@Column(name = "in_ipd_dx", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_ipd_dx() {
		return this.in_ipd_dx;
	}

	public void setIn_ipd_dx(String in_ipd_dx) {
		this.in_ipd_dx = in_ipd_dx;
	}
	private String in_ipd_ic;

	@Column(name = "in_ipd_ic", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_ipd_ic() {
		return this.in_ipd_ic;
	}

	public void setIn_ipd_ic(String in_ipd_ic) {
		this.in_ipd_ic = in_ipd_ic;
	}
	private String in_ipd_match;

	@Column(name = "in_ipd_match", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_ipd_match() {
		return this.in_ipd_match;
	}

	public void setIn_ipd_match(String in_ipd_match) {
		this.in_ipd_match = in_ipd_match;
	}
	private String in_pink1pd_age;

	@Column(name = "in_pink1pd_age", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_pink1pd_age() {
		return this.in_pink1pd_age;
	}

	public void setIn_pink1pd_age(String in_pink1pd_age) {
		this.in_pink1pd_age = in_pink1pd_age;
	}
	private String in_pink1pd_dx;

	@Column(name = "in_pink1pd_dx", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_pink1pd_dx() {
		return this.in_pink1pd_dx;
	}

	public void setIn_pink1pd_dx(String in_pink1pd_dx) {
		this.in_pink1pd_dx = in_pink1pd_dx;
	}
	private String in_pink1pd_ic;

	@Column(name = "in_pink1pd_ic", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_pink1pd_ic() {
		return this.in_pink1pd_ic;
	}

	public void setIn_pink1pd_ic(String in_pink1pd_ic) {
		this.in_pink1pd_ic = in_pink1pd_ic;
	}
	private String in_pink1pd_pathvar;

	@Column(name = "in_pink1pd_pathvar", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_pink1pd_pathvar() {
		return this.in_pink1pd_pathvar;
	}

	public void setIn_pink1pd_pathvar(String in_pink1pd_pathvar) {
		this.in_pink1pd_pathvar = in_pink1pd_pathvar;
	}
	private String in_pink1pd_var;

	@Column(name = "in_pink1pd_var", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_pink1pd_var() {
		return this.in_pink1pd_var;
	}

	public void setIn_pink1pd_var(String in_pink1pd_var) {
		this.in_pink1pd_var = in_pink1pd_var;
	}
	private String in_pink1unaff_age;

	@Column(name = "in_pink1unaff_age", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_pink1unaff_age() {
		return this.in_pink1unaff_age;
	}

	public void setIn_pink1unaff_age(String in_pink1unaff_age) {
		this.in_pink1unaff_age = in_pink1unaff_age;
	}
	private String in_pink1unaff_ic;

	@Column(name = "in_pink1unaff_ic", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_pink1unaff_ic() {
		return this.in_pink1unaff_ic;
	}

	public void setIn_pink1unaff_ic(String in_pink1unaff_ic) {
		this.in_pink1unaff_ic = in_pink1unaff_ic;
	}
	private String in_pink1unaff_pathvar;

	@Column(name = "in_pink1unaff_pathvar", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_pink1unaff_pathvar() {
		return this.in_pink1unaff_pathvar;
	}

	public void setIn_pink1unaff_pathvar(String in_pink1unaff_pathvar) {
		this.in_pink1unaff_pathvar = in_pink1unaff_pathvar;
	}
	private String in_pink1unaff_var;

	@Column(name = "in_pink1unaff_var", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_pink1unaff_var() {
		return this.in_pink1unaff_var;
	}

	public void setIn_pink1unaff_var(String in_pink1unaff_var) {
		this.in_pink1unaff_var = in_pink1unaff_var;
	}
	private String in_prknpd_age;

	@Column(name = "in_prknpd_age", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_prknpd_age() {
		return this.in_prknpd_age;
	}

	public void setIn_prknpd_age(String in_prknpd_age) {
		this.in_prknpd_age = in_prknpd_age;
	}
	private String in_prknpd_dx;

	@Column(name = "in_prknpd_dx", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_prknpd_dx() {
		return this.in_prknpd_dx;
	}

	public void setIn_prknpd_dx(String in_prknpd_dx) {
		this.in_prknpd_dx = in_prknpd_dx;
	}
	private String in_prknpd_ic;

	@Column(name = "in_prknpd_ic", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_prknpd_ic() {
		return this.in_prknpd_ic;
	}

	public void setIn_prknpd_ic(String in_prknpd_ic) {
		this.in_prknpd_ic = in_prknpd_ic;
	}
	private String in_prknpd_pathvar;

	@Column(name = "in_prknpd_pathvar", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_prknpd_pathvar() {
		return this.in_prknpd_pathvar;
	}

	public void setIn_prknpd_pathvar(String in_prknpd_pathvar) {
		this.in_prknpd_pathvar = in_prknpd_pathvar;
	}
	private String in_prknpd_var;

	@Column(name = "in_prknpd_var", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_prknpd_var() {
		return this.in_prknpd_var;
	}

	public void setIn_prknpd_var(String in_prknpd_var) {
		this.in_prknpd_var = in_prknpd_var;
	}
	private String in_prknunaff_age;

	@Column(name = "in_prknunaff_age", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_prknunaff_age() {
		return this.in_prknunaff_age;
	}

	public void setIn_prknunaff_age(String in_prknunaff_age) {
		this.in_prknunaff_age = in_prknunaff_age;
	}
	private String in_prknunaff_ic;

	@Column(name = "in_prknunaff_ic", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_prknunaff_ic() {
		return this.in_prknunaff_ic;
	}

	public void setIn_prknunaff_ic(String in_prknunaff_ic) {
		this.in_prknunaff_ic = in_prknunaff_ic;
	}
	private String in_prknunaff_pathvar;

	@Column(name = "in_prknunaff_pathvar", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_prknunaff_pathvar() {
		return this.in_prknunaff_pathvar;
	}

	public void setIn_prknunaff_pathvar(String in_prknunaff_pathvar) {
		this.in_prknunaff_pathvar = in_prknunaff_pathvar;
	}
	private String in_prknunaff_var;

	@Column(name = "in_prknunaff_var", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIn_prknunaff_var() {
		return this.in_prknunaff_var;
	}

	public void setIn_prknunaff_var(String in_prknunaff_var) {
		this.in_prknunaff_var = in_prknunaff_var;
	}
	private String ppmi_part;

	@Column(name = "ppmi_part", nullable = true, columnDefinition = "varchar", length = 128)
	public String getPpmi_part() {
		return this.ppmi_part;
	}

	public void setPpmi_part(String ppmi_part) {
		this.ppmi_part = ppmi_part;
	}

	public String getStatusColor() {
		if (this.in_cat == null) {
			return "blue"; // Если in_cat не указан, считаем, что ни одно поле не заполнено
		}

		switch (this.in_cat) {
			case "individual with PD and at least one pathogenic variant in PRKN":
			case "individual with PD and at least one pathogenic variant in PINK1":
				return checkGroupCompletion(getPdPrknPink1Fields());
			case "individual with iPD":
				return checkGroupCompletion(getIpdFields());
			case "unaffected individual with at least one pathogenic variant in PRKN":
			case "unaffected individual with at least one pathogenic variant in PINK1":
				return checkGroupCompletion(getNonManifestingFields());
			case "healthy control":
				return checkGroupCompletion(getHealthyControlFields());
			default:
				return "blue"; // Если in_cat не соответствует ни одной группе
		}
	}

	private String checkGroupCompletion(String[] fields) {
		int completedCount = 0;
		int totalFields = 0;

		for (String field : fields) {
			if (shouldDisplayField(field)) { // Проверяем, должно ли поле отображаться
				totalFields++;
				//field приходит название поля, а не значение можешь получить значение поля через рефлексию
				String value = null;
				try {
					value = (String) this.getClass().getDeclaredField(field).get(this);
				} catch (IllegalAccessException | NoSuchFieldException e) {
					e.printStackTrace();
				}
				if (value != null && !value.isEmpty()) {
					completedCount++;
				}
			}
		}

		if (totalFields == 0) {
			return "blue"; // Если нет полей для отображения
		} else if (completedCount == totalFields) {
			return "green"; // Все поля заполнены
		} else if (completedCount > 0) {
			return "orange"; // Некоторые поля заполнены
		} else {
			return "blue"; // Ни одно поле не заполнено
		}
	}

	private boolean shouldDisplayField(String fieldName) {
		// Логика проверки, должно ли поле отображаться на основе @Condition
		switch (fieldName) {
			case "PPMI_ID":
            return "1".equals(this.ppmi_part); // Поле PPMI_ID отображается только если ppmi_part = "1" (yes)
			case "ex_hc_ex":
			case "ex_hc_monogenic":
			case "ex_hc_mri_neuro":
			case "ex_hc_neuro":
			case "in_hc_age":
			case "in_hc_ic":
			case "in_hc_match":
				return "healthy control".equals(this.in_cat); // Поля отображаются только для healthy control
			case "ex_ipd_ex":
			case "ex_ipd_monogenic":
			case "ex_ipd_symptomatic":
			case "ex_ipd_var":
			case "in_ipd_age":
			case "in_ipd_dx":
			case "in_ipd_ic":
			case "in_ipd_match":
				return "individual with iPD".equals(this.in_cat); // Поля отображаются только для iPD
			case "ex_mitopd_ex":
			case "ex_mitopd_symptomatic":
				return "individual with PD and at least one pathogenic variant in PRKN".equals(this.in_cat) ||
						"individual with PD and at least one pathogenic variant in PINK1".equals(this.in_cat); // Поля отображаются для PD с PRKN/PINK1
			case "ex_unaff_ex":
			case "ex_unaff_mri_neuro":
			case "ex_unaff_neuro":
			case "in_pink1unaff_age":
			case "in_pink1unaff_ic":
			case "in_pink1unaff_pathvar":
			case "in_pink1unaff_var":
			case "in_prknunaff_age":
			case "in_prknunaff_ic":
			case "in_prknunaff_pathvar":
			case "in_prknunaff_var":
				return "unaffected individual with at least one pathogenic variant in PRKN".equals(this.in_cat) ||
						"unaffected individual with at least one pathogenic variant in PINK1".equals(this.in_cat); // Поля отображаются для Non-manifesting carriers
			default:
				return true; // По умолчанию поле отображается
		}
	}

	private String[] getPdPrknPink1Fields() {
		return new String[]{
				"ex_mitopd_ex",
				"ex_mitopd_symptomatic",
				"in_pink1pd_age",
				"in_pink1pd_dx",
				"in_pink1pd_ic",
				"in_pink1pd_pathvar",
				"in_pink1pd_var",
				"in_prknpd_age",
				"in_prknpd_dx",
				"in_prknpd_ic",
				"in_prknpd_pathvar",
				"in_prknpd_var"
		};
	}

	private String[] getIpdFields() {
		return new String[]{
				"ex_ipd_ex",
				"ex_ipd_monogenic",
				"ex_ipd_symptomatic",
				"ex_ipd_var",
				"in_ipd_age",
				"in_ipd_dx",
				"in_ipd_ic",
				"in_ipd_match"
		};
	}

	private String[] getNonManifestingFields() {
		return new String[]{
				"ex_unaff_ex",
				"ex_unaff_mri_neuro",
				"ex_unaff_neuro",
				"in_pink1unaff_age",
				"in_pink1unaff_ic",
				"in_pink1unaff_pathvar",
				"in_pink1unaff_var",
				"in_prknunaff_age",
				"in_prknunaff_ic",
				"in_prknunaff_pathvar",
				"in_prknunaff_var"
		};
	}

	private String[] getHealthyControlFields() {
		return new String[]{
				"ex_hc_ex",
				"ex_hc_monogenic",
				"ex_hc_mri_neuro",
				"ex_hc_neuro",
				"in_hc_age",
				"in_hc_ic",
				"in_hc_match"
		};
	}
}


