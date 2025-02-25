package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN11", schema = "public")
@Cacheable(false)
public class PINK1PRKN11 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN11_id_seq")
    @SequenceGenerator(name="PINK1PRKN11_id_seq", sequenceName="PINK1PRKN11_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN11() {
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

	private String ic_date_day;

	@Column(name = "ic_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIc_date_day() {
		return this.ic_date_day;
	}

	public void setIc_date_day(String ic_date_day) {
		this.ic_date_day = ic_date_day;
	}
	private String ic_date_month;

	@Column(name = "ic_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIc_date_month() {
		return this.ic_date_month;
	}

	public void setIc_date_month(String ic_date_month) {
		this.ic_date_month = ic_date_month;
	}
	private String ic_date_year;

	@Column(name = "ic_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIc_date_year() {
		return this.ic_date_year;
	}

	public void setIc_date_year(String ic_date_year) {
		this.ic_date_year = ic_date_year;
	}
	private String ic_ex;

	@Column(name = "ic_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIc_ex() {
		return this.ic_ex;
	}

	public void setIc_ex(String ic_ex) {
		this.ic_ex = ic_ex;
	}
	private String ic_version;

	@Column(name = "ic_version", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIc_version() {
		return this.ic_version;
	}

	public void setIc_version(String ic_version) {
		this.ic_version = ic_version;
	}
	private String ic_version_date_day;

	@Column(name = "ic_version_date_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIc_version_date_day() {
		return this.ic_version_date_day;
	}

	public void setIc_version_date_day(String ic_version_date_day) {
		this.ic_version_date_day = ic_version_date_day;
	}
	private String ic_version_date_month;

	@Column(name = "ic_version_date_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIc_version_date_month() {
		return this.ic_version_date_month;
	}

	public void setIc_version_date_month(String ic_version_date_month) {
		this.ic_version_date_month = ic_version_date_month;
	}
	private String ic_version_date_year;

	@Column(name = "ic_version_date_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIc_version_date_year() {
		return this.ic_version_date_year;
	}

	public void setIc_version_date_year(String ic_version_date_year) {
		this.ic_version_date_year = ic_version_date_year;
	}

	public String getStatusColor() {
		boolean allItemsCompleted = isAllItemsCompleted();
		boolean atLeastOneCompleted = isAtLeastOneFieldCompleted();

		if ("1".equals(this.ic_ex)) { // yes = 1
			if (allItemsCompleted) {
				return "green"; // Все поля заполнены и IC_EX=yes
			} else {
				return "orange"; // Не все поля заполнены, но IC_EX=yes
			}
		} else if ("2".equals(this.ic_ex)) { // no = 2
			return "red"; // IC_EX=no
		} else {
			if (allItemsCompleted) {
				return "green"; // Все поля заполнены, но IC_EX не указан
			} else if (atLeastOneCompleted) {
				return "orange"; // Некоторые поля заполнены, но не все
			} else {
				return "blue"; // Ни одно поле не заполнено
			}
		}
	}

	private boolean isAllItemsCompleted() {
		return isFieldCompleted(this.ic_date_day) &&
				isFieldCompleted(this.ic_date_month) &&
				isFieldCompleted(this.ic_date_year) &&
				isFieldCompleted(this.ic_version) &&
				isFieldCompleted(this.ic_version_date_day) &&
				isFieldCompleted(this.ic_version_date_month) &&
				isFieldCompleted(this.ic_version_date_year);
	}

	private boolean isAtLeastOneFieldCompleted() {
		return isFieldCompleted(this.ic_date_day) ||
				isFieldCompleted(this.ic_date_month) ||
				isFieldCompleted(this.ic_date_year) ||
				isFieldCompleted(this.ic_version) ||
				isFieldCompleted(this.ic_version_date_day) ||
				isFieldCompleted(this.ic_version_date_month) ||
				isFieldCompleted(this.ic_version_date_year);
	}

	private boolean isFieldCompleted(String field) {
		return field != null && !field.trim().isEmpty() && !field.trim().equals("-");
	}

}


//green if all items completed AND IC_EX=yes, red if IC_EX=no, if some but not all items completed: orange, if none completed: blue
