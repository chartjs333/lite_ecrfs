package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN16", schema = "public")
@Cacheable(false)
public class PINK1PRKN16 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN16_id_seq")
    @SequenceGenerator(name="PINK1PRKN16_id_seq", sequenceName="PINK1PRKN16_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN16() {
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

	private String im_dat;

	@Column(name = "im_dat", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIm_dat() {
		return this.im_dat;
	}

	public void setIm_dat(String im_dat) {
		this.im_dat = im_dat;
	}
	private String im_dat_day;

	@Column(name = "im_dat_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIm_dat_day() {
		return this.im_dat_day;
	}

	public void setIm_dat_day(String im_dat_day) {
		this.im_dat_day = im_dat_day;
	}
	private String im_dat_month;

	@Column(name = "im_dat_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIm_dat_month() {
		return this.im_dat_month;
	}

	public void setIm_dat_month(String im_dat_month) {
		this.im_dat_month = im_dat_month;
	}
	private String im_dat_year;

	@Column(name = "im_dat_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIm_dat_year() {
		return this.im_dat_year;
	}

	public void setIm_dat_year(String im_dat_year) {
		this.im_dat_year = im_dat_year;
	}
	private String im_mri;

	@Column(name = "im_mri", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIm_mri() {
		return this.im_mri;
	}

	public void setIm_mri(String im_mri) {
		this.im_mri = im_mri;
	}
	private String im_mri_day;

	@Column(name = "im_mri_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIm_mri_day() {
		return this.im_mri_day;
	}

	public void setIm_mri_day(String im_mri_day) {
		this.im_mri_day = im_mri_day;
	}
	private String im_mri_month;

	@Column(name = "im_mri_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIm_mri_month() {
		return this.im_mri_month;
	}

	public void setIm_mri_month(String im_mri_month) {
		this.im_mri_month = im_mri_month;
	}
	private String im_mri_year;

	@Column(name = "im_mri_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIm_mri_year() {
		return this.im_mri_year;
	}

	public void setIm_mri_year(String im_mri_year) {
		this.im_mri_year = im_mri_year;
	}
	private String im_mridev;

	@Column(name = "im_mridev", nullable = true, columnDefinition = "varchar", length = 128)
	public String getIm_mridev() {
		return this.im_mridev;
	}

	public void setIm_mridev(String im_mridev) {
		this.im_mridev = im_mridev;
	}

	public String getStatusColor() {
		// Проверяем, заполнены ли все обязательные поля
		boolean allCompleted = areAllFieldsCompleted();
		boolean imDatAvailable = "1".equals(this.im_dat);
		boolean imMriAvailable = "1".equals(this.im_mri);
		boolean imDatNotAvailable = "2".equals(this.im_dat); //not available should be fixed
		boolean imMriNotAvailable = "0".equals(this.im_mri); //not available

		// Проверяем условия для green
		if (allCompleted || (imDatNotAvailable && imMriNotAvailable)) {
			return "green";
		}

		// Проверяем, заполнены ли связанные поля, если im_MRI или im_DAT = "available"
		if ((imDatAvailable && !areImDatFieldsCompleted()) || (imMriAvailable && !areImMriFieldsCompleted())) {
			return "orange";
		}

		// Проверяем, заполнено ли хотя бы одно поле
		if (isAtLeastOneFieldCompleted()) {
			return "orange";
		} else {
			return "blue";
		}
	}

	private boolean areAllFieldsCompleted() {
		// Проверяем, что все обязательные поля заполнены
		return isFieldCompleted(this.im_dat) &&
				isFieldCompleted(this.im_mri) &&
				(shouldDisplayField("im_dat_day") ? isFieldCompleted(this.im_dat_day) : true) &&
				(shouldDisplayField("im_dat_month") ? isFieldCompleted(this.im_dat_month) : true) &&
				(shouldDisplayField("im_dat_year") ? isFieldCompleted(this.im_dat_year) : true) &&
				(shouldDisplayField("im_mri_day") ? isFieldCompleted(this.im_mri_day) : true) &&
				(shouldDisplayField("im_mri_month") ? isFieldCompleted(this.im_mri_month) : true) &&
				(shouldDisplayField("im_mri_year") ? isFieldCompleted(this.im_mri_year) : true) &&
				(shouldDisplayField("im_mridev") ? isFieldCompleted(this.im_mridev) : true);
	}

	private boolean areImDatFieldsCompleted() {
		// Проверяем, что все связанные с im_dat поля заполнены
		return isFieldCompleted(this.im_dat_day) &&
				isFieldCompleted(this.im_dat_month) &&
				isFieldCompleted(this.im_dat_year);
	}

	private boolean areImMriFieldsCompleted() {
		// Проверяем, что все связанные с im_mri поля заполнены
		return isFieldCompleted(this.im_mri_day) &&
				isFieldCompleted(this.im_mri_month) &&
				isFieldCompleted(this.im_mri_year) &&
				isFieldCompleted(this.im_mridev);
	}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно поле
		return isFieldCompleted(this.im_dat) ||
				isFieldCompleted(this.im_mri) ||
				isFieldCompleted(this.im_dat_day) ||
				isFieldCompleted(this.im_dat_month) ||
				isFieldCompleted(this.im_dat_year) ||
				isFieldCompleted(this.im_mri_day) ||
				isFieldCompleted(this.im_mri_month) ||
				isFieldCompleted(this.im_mri_year) ||
				isFieldCompleted(this.im_mridev);
}

	private boolean isFieldCompleted(String field) {
		// Проверяем, что поле не равно null и не пустое
		return field != null && !field.trim().isEmpty() && !"-".equals(field.trim());
	}

	private boolean shouldDisplayField(String fieldName) {
		// Логика проверки, должно ли поле отображаться на основе @Condition
		switch (fieldName) {
			case "im_dat_day":
			case "im_dat_month":
			case "im_dat_year":
				return "1".equals(this.im_dat);
			case "im_mri_day":
			case "im_mri_month":
			case "im_mri_year":
			case "im_mridev":
				return "1".equals(this.im_mri);
			default:
				return true; // По умолчанию поле отображается
		}
	}
}

//green if all items are completed OR if im_MRI OR im_DAT=not available, the subsequent items can be blank; orange if im_MRI or im_DAT=avialable but subsequent items not completed
