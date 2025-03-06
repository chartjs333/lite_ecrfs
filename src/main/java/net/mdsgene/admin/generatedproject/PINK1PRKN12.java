package net.mdsgene.admin.generatedproject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "PINK1PRKN12", schema = "public")
@Cacheable(false)
public class PINK1PRKN12 implements java.io.Serializable {
	private static final Logger LOGGER = LoggerFactory.getLogger(PINK1PRKN12.class);

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

	/**
	 * Determine the status color based on completion of required fields.
	 * - If in_cat (group) is null, defaults to overall completion check (no crash).
	 * - If any field (except surveyTwoId and fillingStatus) is filled, returns ORANGE.
	 * - If all required fields for the selected group are filled, returns GREEN.
	 * - If no fields are filled, returns BLUE.
	 */
	public String getStatusColor() {
		LOGGER.info("Determining status color for PINK1PRKN12...");
		if (this.in_cat == null) {
			LOGGER.info("in_cat (group) is null. Defaulting to overall completion check.");
		} else {
			LOGGER.info("Group (in_cat) selected: " + this.in_cat);
		}

		// Check all required fields for the specific group
		boolean allGroupCompleted = true;
		List<String> missingFields = new ArrayList<>();
		if (this.in_cat == null) {
			allGroupCompleted = false;
		} else if ("healthy control".equals(this.in_cat)) {
			if (!isFilled(this.ex_hc_ex)) { missingFields.add("ex_hc_ex"); allGroupCompleted = false; }
			if (!isFilled(this.ex_hc_monogenic)) { missingFields.add("ex_hc_monogenic"); allGroupCompleted = false; }
			if (!isFilled(this.ex_hc_mri_neuro)) { missingFields.add("ex_hc_mri_neuro"); allGroupCompleted = false; }
			if (!isFilled(this.ex_hc_neuro)) { missingFields.add("ex_hc_neuro"); allGroupCompleted = false; }
			if (!isFilled(this.in_hc_age)) { missingFields.add("in_hc_age"); allGroupCompleted = false; }
			if (!isFilled(this.in_hc_ic)) { missingFields.add("in_hc_ic"); allGroupCompleted = false; }
			if (!isFilled(this.in_hc_match)) { missingFields.add("in_hc_match"); allGroupCompleted = false; }
		} else if ("individual with iPD".equals(this.in_cat)) {
			if (!isFilled(this.ex_ipd_ex)) { missingFields.add("ex_ipd_ex"); allGroupCompleted = false; }
			if (!isFilled(this.ex_ipd_monogenic)) { missingFields.add("ex_ipd_monogenic"); allGroupCompleted = false; }
			if (!isFilled(this.ex_ipd_symptomatic)) { missingFields.add("ex_ipd_symptomatic"); allGroupCompleted = false; }
			if (!isFilled(this.ex_ipd_var)) { missingFields.add("ex_ipd_var"); allGroupCompleted = false; }
			if (!isFilled(this.in_ipd_age)) { missingFields.add("in_ipd_age"); allGroupCompleted = false; }
			if (!isFilled(this.in_ipd_dx)) { missingFields.add("in_ipd_dx"); allGroupCompleted = false; }
			if (!isFilled(this.in_ipd_ic)) { missingFields.add("in_ipd_ic"); allGroupCompleted = false; }
			if (!isFilled(this.in_ipd_match)) { missingFields.add("in_ipd_match"); allGroupCompleted = false; }
		} else if ("individual with PD and at least one pathogenic variant in PINK1".equals(this.in_cat)) {
			if (!isFilled(this.ex_mitopd_ex)) { missingFields.add("ex_mitopd_ex"); allGroupCompleted = false; }
			if (!isFilled(this.ex_mitopd_symptomatic)) { missingFields.add("ex_mitopd_symptomatic"); allGroupCompleted = false; }
			if (!isFilled(this.in_pink1pd_age)) { missingFields.add("in_pink1pd_age"); allGroupCompleted = false; }
			if (!isFilled(this.in_pink1pd_dx)) { missingFields.add("in_pink1pd_dx"); allGroupCompleted = false; }
			if (!isFilled(this.in_pink1pd_ic)) { missingFields.add("in_pink1pd_ic"); allGroupCompleted = false; }
			if (!isFilled(this.in_pink1pd_pathvar)) { missingFields.add("in_pink1pd_pathvar"); allGroupCompleted = false; }
			if (!isFilled(this.in_pink1pd_var)) { missingFields.add("in_pink1pd_var"); allGroupCompleted = false; }
		} else if ("individual with PD and at least one pathogenic variant in PRKN".equals(this.in_cat)) {
			if (!isFilled(this.ex_mitopd_ex)) { missingFields.add("ex_mitopd_ex"); allGroupCompleted = false; }
			if (!isFilled(this.ex_mitopd_symptomatic)) { missingFields.add("ex_mitopd_symptomatic"); allGroupCompleted = false; }
			if (!isFilled(this.in_prknpd_age)) { missingFields.add("in_prknpd_age"); allGroupCompleted = false; }
			if (!isFilled(this.in_prknpd_dx)) { missingFields.add("in_prknpd_dx"); allGroupCompleted = false; }
			if (!isFilled(this.in_prknpd_ic)) { missingFields.add("in_prknpd_ic"); allGroupCompleted = false; }
			if (!isFilled(this.in_prknpd_pathvar)) { missingFields.add("in_prknpd_pathvar"); allGroupCompleted = false; }
			if (!isFilled(this.in_prknpd_var)) { missingFields.add("in_prknpd_var"); allGroupCompleted = false; }
		} else if ("unaffected individual with at least one pathogenic variant in PINK1".equals(this.in_cat)) {
			if (!isFilled(this.ex_unaff_ex)) { missingFields.add("ex_unaff_ex"); allGroupCompleted = false; }
			if (!isFilled(this.ex_unaff_mri_neuro)) { missingFields.add("ex_unaff_mri_neuro"); allGroupCompleted = false; }
			if (!isFilled(this.ex_unaff_neuro)) { missingFields.add("ex_unaff_neuro"); allGroupCompleted = false; }
			if (!isFilled(this.in_pink1unaff_age)) { missingFields.add("in_pink1unaff_age"); allGroupCompleted = false; }
			if (!isFilled(this.in_pink1unaff_ic)) { missingFields.add("in_pink1unaff_ic"); allGroupCompleted = false; }
			if (!isFilled(this.in_pink1unaff_pathvar)) { missingFields.add("in_pink1unaff_pathvar"); allGroupCompleted = false; }
			if (!isFilled(this.in_pink1unaff_var)) { missingFields.add("in_pink1unaff_var"); allGroupCompleted = false; }
		} else if ("unaffected individual with at least one pathogenic variant in PRKN".equals(this.in_cat)) {
			if (!isFilled(this.ex_unaff_ex)) { missingFields.add("ex_unaff_ex"); allGroupCompleted = false; }
			if (!isFilled(this.ex_unaff_mri_neuro)) { missingFields.add("ex_unaff_mri_neuro"); allGroupCompleted = false; }
			if (!isFilled(this.ex_unaff_neuro)) { missingFields.add("ex_unaff_neuro"); allGroupCompleted = false; }
			if (!isFilled(this.in_prknunaff_age)) { missingFields.add("in_prknunaff_age"); allGroupCompleted = false; }
			if (!isFilled(this.in_prknunaff_ic)) { missingFields.add("in_prknunaff_ic"); allGroupCompleted = false; }
			if (!isFilled(this.in_prknunaff_pathvar)) { missingFields.add("in_prknunaff_pathvar"); allGroupCompleted = false; }
			if (!isFilled(this.in_prknunaff_var)) { missingFields.add("in_prknunaff_var"); allGroupCompleted = false; }
		} else {
			// Unexpected category value
			LOGGER.warn("Unknown in_cat value: " + this.in_cat);
			allGroupCompleted = false;
		}

		if (!missingFields.isEmpty()) {
			LOGGER.info("Missing required fields for group '" + (this.in_cat == null ? "none" : this.in_cat) + "': "
					+ String.join(", ", missingFields));
		}

		// Check if any field (except surveyTwoId and fillingStatus) is completed
		boolean anyFieldFilled = false;
		if (isFilled(this.gp2_part) || isFilled(this.in_cat) || isFilled(this.ppmi_part) || isFilled(this.PPMI_ID) ||
				isFilled(this.ex_hc_ex) || isFilled(this.ex_hc_monogenic) || isFilled(this.ex_hc_mri_neuro) || isFilled(this.ex_hc_neuro) ||
				isFilled(this.ex_ipd_ex) || isFilled(this.ex_ipd_monogenic) || isFilled(this.ex_ipd_symptomatic) || isFilled(this.ex_ipd_var) ||
				isFilled(this.ex_mitopd_ex) || isFilled(this.ex_mitopd_symptomatic) ||
				isFilled(this.ex_unaff_ex) || isFilled(this.ex_unaff_mri_neuro) || isFilled(this.ex_unaff_neuro) ||
				isFilled(this.in_hc_age) || isFilled(this.in_hc_ic) || isFilled(this.in_hc_match) ||
				isFilled(this.in_ipd_age) || isFilled(this.in_ipd_dx) || isFilled(this.in_ipd_ic) || isFilled(this.in_ipd_match) ||
				isFilled(this.in_pink1pd_age) || isFilled(this.in_pink1pd_dx) || isFilled(this.in_pink1pd_ic) || isFilled(this.in_pink1pd_pathvar) || isFilled(this.in_pink1pd_var) ||
				isFilled(this.in_prknpd_age) || isFilled(this.in_prknpd_dx) || isFilled(this.in_prknpd_ic) || isFilled(this.in_prknpd_pathvar) || isFilled(this.in_prknpd_var) ||
				isFilled(this.in_pink1unaff_age) || isFilled(this.in_pink1unaff_ic) || isFilled(this.in_pink1unaff_pathvar) || isFilled(this.in_pink1unaff_var) ||
				isFilled(this.in_prknunaff_age) || isFilled(this.in_prknunaff_ic) || isFilled(this.in_prknunaff_pathvar) || isFilled(this.in_prknunaff_var)) {
			anyFieldFilled = true;
		}

		if (anyFieldFilled && this.in_cat == null) {
			LOGGER.info("Some fields are filled even though no group (in_cat) is selected.");
		}

		// Determine and return the status color
		if (this.in_cat != null && allGroupCompleted) {
			LOGGER.info("All required fields for group '" + this.in_cat + "' are completed. Status = GREEN.");
			return "green";
		} else if (anyFieldFilled) {
			LOGGER.info("At least one field is filled, but not all required fields are complete. Status = ORANGE.");
			return "orange";
		} else {
			LOGGER.info("No fields have been filled out. Status = BLUE.");
			return "blue";
		}
	}

	/** Helper to check if a field value is filled (non-null and not empty). */
	private boolean isFilled(String value) {
		return value != null && !value.trim().isEmpty() && !value.trim().equals("-");
	}

}


