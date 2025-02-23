package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN117", schema = "public")
@Cacheable(false)
public class PINK1PRKN117 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN117_id_seq")
    @SequenceGenerator(name="PINK1PRKN117_id_seq", sequenceName="PINK1PRKN117_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN117() {
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

	private String mdsupdrs_1_1_selection;

	@Column(name = "mdsupdrs_1_1_selection", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_1_1_selection() {
		return this.mdsupdrs_1_1_selection;
	}

	public void setMdsupdrs_1_1_selection(String mdsupdrs_1_1_selection) {
		this.mdsupdrs_1_1_selection = mdsupdrs_1_1_selection;
	}
	private String mdsupdrs_1_2_selection;

	@Column(name = "mdsupdrs_1_2_selection", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_1_2_selection() {
		return this.mdsupdrs_1_2_selection;
	}

	public void setMdsupdrs_1_2_selection(String mdsupdrs_1_2_selection) {
		this.mdsupdrs_1_2_selection = mdsupdrs_1_2_selection;
	}
	private String mdsupdrs_1_3_selection;

	@Column(name = "mdsupdrs_1_3_selection", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_1_3_selection() {
		return this.mdsupdrs_1_3_selection;
	}

	public void setMdsupdrs_1_3_selection(String mdsupdrs_1_3_selection) {
		this.mdsupdrs_1_3_selection = mdsupdrs_1_3_selection;
	}
	private String mdsupdrs_1_4_selection;

	@Column(name = "mdsupdrs_1_4_selection", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_1_4_selection() {
		return this.mdsupdrs_1_4_selection;
	}

	public void setMdsupdrs_1_4_selection(String mdsupdrs_1_4_selection) {
		this.mdsupdrs_1_4_selection = mdsupdrs_1_4_selection;
	}
	private String mdsupdrs_1_5_selection;

	@Column(name = "mdsupdrs_1_5_selection", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_1_5_selection() {
		return this.mdsupdrs_1_5_selection;
	}

	public void setMdsupdrs_1_5_selection(String mdsupdrs_1_5_selection) {
		this.mdsupdrs_1_5_selection = mdsupdrs_1_5_selection;
	}
	private String mdsupdrs_1_6_selection;

	@Column(name = "mdsupdrs_1_6_selection", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_1_6_selection() {
		return this.mdsupdrs_1_6_selection;
	}

	public void setMdsupdrs_1_6_selection(String mdsupdrs_1_6_selection) {
		this.mdsupdrs_1_6_selection = mdsupdrs_1_6_selection;
	}
	private String mdsupdrs_1_psi;

	@Column(name = "mdsupdrs_1_psi", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrs_1_psi() {
		return this.mdsupdrs_1_psi;
	}

	public void setMdsupdrs_1_psi(String mdsupdrs_1_psi) {
		this.mdsupdrs_1_psi = mdsupdrs_1_psi;
	}

	public String getStatusColor() {
		// Проверяем, заполнены ли все поля
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
		// Проверяем заполненность всех полей
		return !isEmpty(this.surveyTwoId) &&
				!isEmpty(this.fillingStatus) &&
				!isEmpty(this.mdsupdrs_1_1_selection) &&
				!isEmpty(this.mdsupdrs_1_2_selection) &&
				!isEmpty(this.mdsupdrs_1_3_selection) &&
				!isEmpty(this.mdsupdrs_1_4_selection) &&
				!isEmpty(this.mdsupdrs_1_5_selection) &&
				!isEmpty(this.mdsupdrs_1_6_selection) &&
				!isEmpty(this.mdsupdrs_1_psi);
	}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно поле
		return !isEmpty(this.surveyTwoId) ||
				!isEmpty(this.fillingStatus) ||
				!isEmpty(this.mdsupdrs_1_1_selection) ||
				!isEmpty(this.mdsupdrs_1_2_selection) ||
				!isEmpty(this.mdsupdrs_1_3_selection) ||
				!isEmpty(this.mdsupdrs_1_4_selection) ||
				!isEmpty(this.mdsupdrs_1_5_selection) ||
				!isEmpty(this.mdsupdrs_1_6_selection) ||
				!isEmpty(this.mdsupdrs_1_psi);
	}

	private boolean isEmpty(String value) {
		// Проверяем, является ли строка пустой или null
		return value == null || value.trim().isEmpty();
	}
}


//green if all items completed, orange if some but not all, blue if none are completed