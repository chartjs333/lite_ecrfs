package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN118", schema = "public")
@Cacheable(false)
public class PINK1PRKN118 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN118_id_seq")
    @SequenceGenerator(name="PINK1PRKN118_id_seq", sequenceName="PINK1PRKN118_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN118() {
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

	private String mdsupdrspat1_10;

	@Column(name = "mdsupdrspat1_10", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat1_10() {
		return this.mdsupdrspat1_10;
	}

	public void setMdsupdrspat1_10(String mdsupdrspat1_10) {
		this.mdsupdrspat1_10 = mdsupdrspat1_10;
	}
	private String mdsupdrspat1_11;

	@Column(name = "mdsupdrspat1_11", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat1_11() {
		return this.mdsupdrspat1_11;
	}

	public void setMdsupdrspat1_11(String mdsupdrspat1_11) {
		this.mdsupdrspat1_11 = mdsupdrspat1_11;
	}
	private String mdsupdrspat1_12;

	@Column(name = "mdsupdrspat1_12", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat1_12() {
		return this.mdsupdrspat1_12;
	}

	public void setMdsupdrspat1_12(String mdsupdrspat1_12) {
		this.mdsupdrspat1_12 = mdsupdrspat1_12;
	}
	private String mdsupdrspat1_13;

	@Column(name = "mdsupdrspat1_13", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat1_13() {
		return this.mdsupdrspat1_13;
	}

	public void setMdsupdrspat1_13(String mdsupdrspat1_13) {
		this.mdsupdrspat1_13 = mdsupdrspat1_13;
	}
	private String mdsupdrspat1_7;

	@Column(name = "mdsupdrspat1_7", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat1_7() {
		return this.mdsupdrspat1_7;
	}

	public void setMdsupdrspat1_7(String mdsupdrspat1_7) {
		this.mdsupdrspat1_7 = mdsupdrspat1_7;
	}
	private String mdsupdrspat1_8;

	@Column(name = "mdsupdrspat1_8", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat1_8() {
		return this.mdsupdrspat1_8;
	}

	public void setMdsupdrspat1_8(String mdsupdrspat1_8) {
		this.mdsupdrspat1_8 = mdsupdrspat1_8;
	}
	private String mdsupdrspat1_9;

	@Column(name = "mdsupdrspat1_9", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat1_9() {
		return this.mdsupdrspat1_9;
	}

	public void setMdsupdrspat1_9(String mdsupdrspat1_9) {
		this.mdsupdrspat1_9 = mdsupdrspat1_9;
	}
	private String mdsupdrspat2_1;

	@Column(name = "mdsupdrspat2_1", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat2_1() {
		return this.mdsupdrspat2_1;
	}

	public void setMdsupdrspat2_1(String mdsupdrspat2_1) {
		this.mdsupdrspat2_1 = mdsupdrspat2_1;
	}
	private String mdsupdrspat2_10;

	@Column(name = "mdsupdrspat2_10", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat2_10() {
		return this.mdsupdrspat2_10;
	}

	public void setMdsupdrspat2_10(String mdsupdrspat2_10) {
		this.mdsupdrspat2_10 = mdsupdrspat2_10;
	}
	private String mdsupdrspat2_11;

	@Column(name = "mdsupdrspat2_11", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat2_11() {
		return this.mdsupdrspat2_11;
	}

	public void setMdsupdrspat2_11(String mdsupdrspat2_11) {
		this.mdsupdrspat2_11 = mdsupdrspat2_11;
	}
	private String mdsupdrspat2_12;

	@Column(name = "mdsupdrspat2_12", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat2_12() {
		return this.mdsupdrspat2_12;
	}

	public void setMdsupdrspat2_12(String mdsupdrspat2_12) {
		this.mdsupdrspat2_12 = mdsupdrspat2_12;
	}
	private String mdsupdrspat2_13;

	@Column(name = "mdsupdrspat2_13", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat2_13() {
		return this.mdsupdrspat2_13;
	}

	public void setMdsupdrspat2_13(String mdsupdrspat2_13) {
		this.mdsupdrspat2_13 = mdsupdrspat2_13;
	}
	private String mdsupdrspat2_2;

	@Column(name = "mdsupdrspat2_2", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat2_2() {
		return this.mdsupdrspat2_2;
	}

	public void setMdsupdrspat2_2(String mdsupdrspat2_2) {
		this.mdsupdrspat2_2 = mdsupdrspat2_2;
	}
	private String mdsupdrspat2_3;

	@Column(name = "mdsupdrspat2_3", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat2_3() {
		return this.mdsupdrspat2_3;
	}

	public void setMdsupdrspat2_3(String mdsupdrspat2_3) {
		this.mdsupdrspat2_3 = mdsupdrspat2_3;
	}
	private String mdsupdrspat2_4;

	@Column(name = "mdsupdrspat2_4", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat2_4() {
		return this.mdsupdrspat2_4;
	}

	public void setMdsupdrspat2_4(String mdsupdrspat2_4) {
		this.mdsupdrspat2_4 = mdsupdrspat2_4;
	}
	private String mdsupdrspat2_5;

	@Column(name = "mdsupdrspat2_5", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat2_5() {
		return this.mdsupdrspat2_5;
	}

	public void setMdsupdrspat2_5(String mdsupdrspat2_5) {
		this.mdsupdrspat2_5 = mdsupdrspat2_5;
	}
	private String mdsupdrspat2_6;

	@Column(name = "mdsupdrspat2_6", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat2_6() {
		return this.mdsupdrspat2_6;
	}

	public void setMdsupdrspat2_6(String mdsupdrspat2_6) {
		this.mdsupdrspat2_6 = mdsupdrspat2_6;
	}
	private String mdsupdrspat2_7;

	@Column(name = "mdsupdrspat2_7", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat2_7() {
		return this.mdsupdrspat2_7;
	}

	public void setMdsupdrspat2_7(String mdsupdrspat2_7) {
		this.mdsupdrspat2_7 = mdsupdrspat2_7;
	}
	private String mdsupdrspat2_8;

	@Column(name = "mdsupdrspat2_8", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat2_8() {
		return this.mdsupdrspat2_8;
	}

	public void setMdsupdrspat2_8(String mdsupdrspat2_8) {
		this.mdsupdrspat2_8 = mdsupdrspat2_8;
	}
	private String mdsupdrspat2_9;

	@Column(name = "mdsupdrspat2_9", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat2_9() {
		return this.mdsupdrspat2_9;
	}

	public void setMdsupdrspat2_9(String mdsupdrspat2_9) {
		this.mdsupdrspat2_9 = mdsupdrspat2_9;
	}
	private String mdsupdrspat_psi;

	@Column(name = "mdsupdrspat_psi", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMdsupdrspat_psi() {
		return this.mdsupdrspat_psi;
	}

	public void setMdsupdrspat_psi(String mdsupdrspat_psi) {
		this.mdsupdrspat_psi = mdsupdrspat_psi;
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
		// Проверяем, заполнены ли все поля
		return !isEmpty(this.surveyTwoId) &&
				!isEmpty(this.fillingStatus) &&
				!isEmpty(this.mdsupdrspat1_10) &&
				!isEmpty(this.mdsupdrspat1_11) &&
				!isEmpty(this.mdsupdrspat1_12) &&
				!isEmpty(this.mdsupdrspat1_13) &&
				!isEmpty(this.mdsupdrspat1_7) &&
				!isEmpty(this.mdsupdrspat1_8) &&
				!isEmpty(this.mdsupdrspat1_9) &&
				!isEmpty(this.mdsupdrspat2_1) &&
				!isEmpty(this.mdsupdrspat2_10) &&
				!isEmpty(this.mdsupdrspat2_11) &&
				!isEmpty(this.mdsupdrspat2_12) &&
				!isEmpty(this.mdsupdrspat2_13) &&
				!isEmpty(this.mdsupdrspat2_2) &&
				!isEmpty(this.mdsupdrspat2_3) &&
				!isEmpty(this.mdsupdrspat2_4) &&
				!isEmpty(this.mdsupdrspat2_5) &&
				!isEmpty(this.mdsupdrspat2_6) &&
				!isEmpty(this.mdsupdrspat2_7) &&
				!isEmpty(this.mdsupdrspat2_8) &&
				!isEmpty(this.mdsupdrspat2_9) &&
				!isEmpty(this.mdsupdrspat_psi);
	}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно поле
		return !isEmpty(this.surveyTwoId) ||
				!isEmpty(this.fillingStatus) ||
				!isEmpty(this.mdsupdrspat1_10) ||
				!isEmpty(this.mdsupdrspat1_11) ||
				!isEmpty(this.mdsupdrspat1_12) ||
				!isEmpty(this.mdsupdrspat1_13) ||
				!isEmpty(this.mdsupdrspat1_7) ||
				!isEmpty(this.mdsupdrspat1_8) ||
				!isEmpty(this.mdsupdrspat1_9) ||
				!isEmpty(this.mdsupdrspat2_1) ||
				!isEmpty(this.mdsupdrspat2_10) ||
				!isEmpty(this.mdsupdrspat2_11) ||
				!isEmpty(this.mdsupdrspat2_12) ||
				!isEmpty(this.mdsupdrspat2_13) ||
				!isEmpty(this.mdsupdrspat2_2) ||
				!isEmpty(this.mdsupdrspat2_3) ||
				!isEmpty(this.mdsupdrspat2_4) ||
				!isEmpty(this.mdsupdrspat2_5) ||
				!isEmpty(this.mdsupdrspat2_6) ||
				!isEmpty(this.mdsupdrspat2_7) ||
				!isEmpty(this.mdsupdrspat2_8) ||
				!isEmpty(this.mdsupdrspat2_9) ||
				!isEmpty(this.mdsupdrspat_psi);
	}

	private boolean isEmpty(String value) {
		// Проверяем, является ли строка пустой или null
		return value == null || value.trim().isEmpty();
	}
}


//green if all items completed, orange if some but not all, blue if none are completed