package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN17", schema = "public")
@Cacheable(false)
public class PINK1PRKN17 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN17_id_seq")
    @SequenceGenerator(name="PINK1PRKN17_id_seq", sequenceName="PINK1PRKN17_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN17() {
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

	private String eth_afber;

	@Column(name = "eth_afber", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEth_afber() {
		return this.eth_afber;
	}

	public void setEth_afber(String eth_afber) {
		this.eth_afber = eth_afber;
	}
	private String eth_amind;

	@Column(name = "eth_amind", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEth_amind() {
		return this.eth_amind;
	}

	public void setEth_amind(String eth_amind) {
		this.eth_amind = eth_amind;
	}
	private String eth_ashj;

	@Column(name = "eth_ashj", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEth_ashj() {
		return this.eth_ashj;
	}

	public void setEth_ashj(String eth_ashj) {
		this.eth_ashj = eth_ashj;
	}
	private String eth_asia;

	@Column(name = "eth_asia", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEth_asia() {
		return this.eth_asia;
	}

	public void setEth_asia(String eth_asia) {
		this.eth_asia = eth_asia;
	}
	private String eth_basq;

	@Column(name = "eth_basq", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEth_basq() {
		return this.eth_basq;
	}

	public void setEth_basq(String eth_basq) {
		this.eth_basq = eth_basq;
	}
	private String eth_black;

	@Column(name = "eth_black", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEth_black() {
		return this.eth_black;
	}

	public void setEth_black(String eth_black) {
		this.eth_black = eth_black;
	}
	private String eth_hislat;

	@Column(name = "eth_hislat", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEth_hislat() {
		return this.eth_hislat;
	}

	public void setEth_hislat(String eth_hislat) {
		this.eth_hislat = eth_hislat;
	}
	private String eth_other;

	@Column(name = "eth_other", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEth_other() {
		return this.eth_other;
	}

	public void setEth_other(String eth_other) {
		this.eth_other = eth_other;
	}
	private String eth_other_spec;

	@Column(name = "eth_other_spec", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEth_other_spec() {
		return this.eth_other_spec;
	}

	public void setEth_other_spec(String eth_other_spec) {
		this.eth_other_spec = eth_other_spec;
	}
	private String eth_pacis;

	@Column(name = "eth_pacis", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEth_pacis() {
		return this.eth_pacis;
	}

	public void setEth_pacis(String eth_pacis) {
		this.eth_pacis = eth_pacis;
	}
	private String eth_white;

	@Column(name = "eth_white", nullable = true, columnDefinition = "varchar", length = 128)
	public String getEth_white() {
		return this.eth_white;
	}

	public void setEth_white(String eth_white) {
		this.eth_white = eth_white;
	}
	private String gender;

	@Column(name = "gender", nullable = true, columnDefinition = "varchar", length = 128)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	private String hand;

	@Column(name = "hand", nullable = true, columnDefinition = "varchar", length = 128)
	public String getHand() {
		return this.hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}
	private String yob;

	@Column(name = "yob", nullable = true, columnDefinition = "varchar", length = 128)
	public String getYob() {
		return this.yob;
	}

	public void setYob(String yob) {
		this.yob = yob;
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
		// Проверяем, что все обязательные поля заполнены
		return isFieldCompleted(this.eth_afber) &&
				isFieldCompleted(this.eth_amind) &&
				isFieldCompleted(this.eth_ashj) &&
				isFieldCompleted(this.eth_asia) &&
				isFieldCompleted(this.eth_basq) &&
				isFieldCompleted(this.eth_black) &&
				isFieldCompleted(this.eth_hislat) &&
				isFieldCompleted(this.eth_other) &&
				(shouldDisplayField("eth_other_spec") ? isFieldCompleted(this.eth_other_spec) : true) &&
				isFieldCompleted(this.eth_pacis) &&
				isFieldCompleted(this.eth_white) &&
				isFieldCompleted(this.gender) &&
				isFieldCompleted(this.hand) &&
				isFieldCompleted(this.yob);
	}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно поле
		return isFieldCompleted(this.eth_afber) ||
				isFieldCompleted(this.eth_amind) ||
				isFieldCompleted(this.eth_ashj) ||
				isFieldCompleted(this.eth_asia) ||
				isFieldCompleted(this.eth_basq) ||
				isFieldCompleted(this.eth_black) ||
				isFieldCompleted(this.eth_hislat) ||
				isFieldCompleted(this.eth_other) ||
				isFieldCompleted(this.eth_other_spec) ||
				isFieldCompleted(this.eth_pacis) ||
				isFieldCompleted(this.eth_white) ||
				isFieldCompleted(this.gender) ||
				isFieldCompleted(this.hand) ||
				isFieldCompleted(this.yob);
	}

	private boolean isFieldCompleted(String field) {
		// Проверяем, что поле не равно null и не пустое
		return field != null && !field.isEmpty();
	}

	private boolean shouldDisplayField(String fieldName) {
		// Логика проверки, должно ли поле отображаться на основе @Condition
		switch (fieldName) {
			case "eth_other_spec":
				return "1".equals(this.eth_other); //yes
			default:
				return true; // По умолчанию поле отображается
		}
	}
}


