package net.mdsgene.admin.generatedproject;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "PINK1PRKN121", schema = "public")
@Cacheable(false)
public class PINK1PRKN121 implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN121_id_seq")
    @SequenceGenerator(name="PINK1PRKN121_id_seq", sequenceName="PINK1PRKN121_id_seq", allocationSize=1)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	private int id;

	public PINK1PRKN121() {
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

	private String moca_bw;

	@Column(name = "moca_bw", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_bw() {
		return this.moca_bw;
	}

	public void setMoca_bw(String moca_bw) {
		this.moca_bw = moca_bw;
	}
	private String moca_camel;

	@Column(name = "moca_camel", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_camel() {
		return this.moca_camel;
	}

	public void setMoca_camel(String moca_camel) {
		this.moca_camel = moca_camel;
	}
	private String moca_church;

	@Column(name = "moca_church", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_church() {
		return this.moca_church;
	}

	public void setMoca_church(String moca_church) {
		this.moca_church = moca_church;
	}
	private String moca_city;

	@Column(name = "moca_city", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_city() {
		return this.moca_city;
	}

	public void setMoca_city(String moca_city) {
		this.moca_city = moca_city;
	}
	private String moca_clock_cont;

	@Column(name = "moca_clock_cont", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_clock_cont() {
		return this.moca_clock_cont;
	}

	public void setMoca_clock_cont(String moca_clock_cont) {
		this.moca_clock_cont = moca_clock_cont;
	}
	private String moca_clock_hands;

	@Column(name = "moca_clock_hands", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_clock_hands() {
		return this.moca_clock_hands;
	}

	public void setMoca_clock_hands(String moca_clock_hands) {
		this.moca_clock_hands = moca_clock_hands;
	}
	private String moca_clock_num;

	@Column(name = "moca_clock_num", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_clock_num() {
		return this.moca_clock_num;
	}

	public void setMoca_clock_num(String moca_clock_num) {
		this.moca_clock_num = moca_clock_num;
	}
	private String moca_cube;

	@Column(name = "moca_cube", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_cube() {
		return this.moca_cube;
	}

	public void setMoca_cube(String moca_cube) {
		this.moca_cube = moca_cube;
	}
	private String moca_daisy;

	@Column(name = "moca_daisy", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_daisy() {
		return this.moca_daisy;
	}

	public void setMoca_daisy(String moca_daisy) {
		this.moca_daisy = moca_daisy;
	}
	private String moca_date;

	@Column(name = "moca_date", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_date() {
		return this.moca_date;
	}

	public void setMoca_date(String moca_date) {
		this.moca_date = moca_date;
	}
	private String moca_day;

	@Column(name = "moca_day", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_day() {
		return this.moca_day;
	}

	public void setMoca_day(String moca_day) {
		this.moca_day = moca_day;
	}
	private String moca_ex;

	@Column(name = "moca_ex", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_ex() {
		return this.moca_ex;
	}

	public void setMoca_ex(String moca_ex) {
		this.moca_ex = moca_ex;
	}
	private String moca_face;

	@Column(name = "moca_face", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_face() {
		return this.moca_face;
	}

	public void setMoca_face(String moca_face) {
		this.moca_face = moca_face;
	}
	private String moca_flu_num;

	@Column(name = "moca_flu_num", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_flu_num() {
		return this.moca_flu_num;
	}

	public void setMoca_flu_num(String moca_flu_num) {
		this.moca_flu_num = moca_flu_num;
	}
	private String moca_flu_sc;

	@Column(name = "moca_flu_sc", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_flu_sc() {
		return this.moca_flu_sc;
	}

	public void setMoca_flu_sc(String moca_flu_sc) {
		this.moca_flu_sc = moca_flu_sc;
	}
	private String moca_fw;

	@Column(name = "moca_fw", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_fw() {
		return this.moca_fw;
	}

	public void setMoca_fw(String moca_fw) {
		this.moca_fw = moca_fw;
	}
	private String moca_limit;

	@Column(name = "moca_limit", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_limit() {
		return this.moca_limit;
	}

	public void setMoca_limit(String moca_limit) {
		this.moca_limit = moca_limit;
	}
	private String moca_lio;

	@Column(name = "moca_lio", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_lio() {
		return this.moca_lio;
	}

	public void setMoca_lio(String moca_lio) {
		this.moca_lio = moca_lio;
	}
	private String moca_month;

	@Column(name = "moca_month", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_month() {
		return this.moca_month;
	}

	public void setMoca_month(String moca_month) {
		this.moca_month = moca_month;
	}
	private String moca_place;

	@Column(name = "moca_place", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_place() {
		return this.moca_place;
	}

	public void setMoca_place(String moca_place) {
		this.moca_place = moca_place;
	}
	private String moca_red;

	@Column(name = "moca_red", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_red() {
		return this.moca_red;
	}

	public void setMoca_red(String moca_red) {
		this.moca_red = moca_red;
	}
	private String moca_rep;

	@Column(name = "moca_rep", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_rep() {
		return this.moca_rep;
	}

	public void setMoca_rep(String moca_rep) {
		this.moca_rep = moca_rep;
	}
	private String moca_rhino;

	@Column(name = "moca_rhino", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_rhino() {
		return this.moca_rhino;
	}

	public void setMoca_rhino(String moca_rhino) {
		this.moca_rhino = moca_rhino;
	}
	private String moca_ser7;

	@Column(name = "moca_ser7", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_ser7() {
		return this.moca_ser7;
	}

	public void setMoca_ser7(String moca_ser7) {
		this.moca_ser7 = moca_ser7;
	}
	private String moca_tm;

	@Column(name = "moca_tm", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_tm() {
		return this.moca_tm;
	}

	public void setMoca_tm(String moca_tm) {
		this.moca_tm = moca_tm;
	}
	private String moca_total;

	@Column(name = "moca_total", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_total() {
		return this.moca_total;
	}

	public void setMoca_total(String moca_total) {
		this.moca_total = moca_total;
	}
	private String moca_velvet;

	@Column(name = "moca_velvet", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_velvet() {
		return this.moca_velvet;
	}

	public void setMoca_velvet(String moca_velvet) {
		this.moca_velvet = moca_velvet;
	}
	private String moca_vig;

	@Column(name = "moca_vig", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_vig() {
		return this.moca_vig;
	}

	public void setMoca_vig(String moca_vig) {
		this.moca_vig = moca_vig;
	}
	private String moca_year;

	@Column(name = "moca_year", nullable = true, columnDefinition = "varchar", length = 128)
	public String getMoca_year() {
		return this.moca_year;
	}

	public void setMoca_year(String moca_year) {
		this.moca_year = moca_year;
	}


	public String getStatusColor() {
		boolean allCompleted = areAllFieldsCompleted();

		if (allCompleted) {
			// 3) Если moca_ex == "1", считаем, что тест не проводился -> "red"
			if ("1".equals(moca_ex)) {
				System.out.println("moca_ex == '1' (тест не проводился)");
				return "red";
			}
			return "green"; // Все обязательные поля заполнены
		} else if (isAtLeastOneFieldCompleted()) {
			return "orange"; // Некоторые поля заполнены, но не все
		} else {
			return "blue"; // Ни одно поле не заполнено
		}
	}

	private boolean areAllFieldsCompleted() {
		boolean mainFieldsCompleted = !isEmpty(this.moca_ex);

		// Если "yes", проверяем и остальные поля
		if ("0".equalsIgnoreCase(this.moca_ex)) {
			boolean conditionalFieldsCompleted = !isEmpty(this.moca_bw)
					&& !isEmpty(this.moca_camel)
					&& !isEmpty(this.moca_church)
					&& !isEmpty(this.moca_city)
					&& !isEmpty(this.moca_clock_cont)
					&& !isEmpty(this.moca_clock_hands)
					&& !isEmpty(this.moca_clock_num)
					&& !isEmpty(this.moca_cube)
					&& !isEmpty(this.moca_daisy)
					&& !isEmpty(this.moca_day)
					&& !isEmpty(this.moca_face)
					&& !isEmpty(this.moca_flu_num)
					&& !isEmpty(this.moca_flu_sc)
					&& !isEmpty(this.moca_fw)
					&& !isEmpty(this.moca_limit)
					&& !isEmpty(this.moca_lio)
					&& !isEmpty(this.moca_month)
					&& !isEmpty(this.moca_place)
					&& !isEmpty(this.moca_red)
					&& !isEmpty(this.moca_rep)
					&& !isEmpty(this.moca_rhino)
					&& !isEmpty(this.moca_ser7)
					&& !isEmpty(this.moca_tm)
					&& !isEmpty(this.moca_total)
					&& !isEmpty(this.moca_velvet)
					&& !isEmpty(this.moca_vig)
					&& !isEmpty(this.moca_year);

			return mainFieldsCompleted && conditionalFieldsCompleted;
		}

		// Если не "yes", считаем незавершённым (возвращаем false)
		return false;
	}

	private boolean isAtLeastOneFieldCompleted() {
		// Проверяем, заполнено ли хотя бы одно поле
		boolean mainFieldsCompleted = !isEmpty(this.moca_ex);

		if ("0".equalsIgnoreCase(this.moca_ex)) {
			boolean conditionalFieldsCompleted = !isEmpty(this.moca_bw) ||
					!isEmpty(this.moca_camel) ||
					!isEmpty(this.moca_church) ||
					!isEmpty(this.moca_city) ||
					!isEmpty(this.moca_clock_cont) ||
					!isEmpty(this.moca_clock_hands) ||
					!isEmpty(this.moca_clock_num) ||
					!isEmpty(this.moca_cube) ||
					!isEmpty(this.moca_daisy) ||
					!isEmpty(this.moca_day) ||
					!isEmpty(this.moca_face) ||
					!isEmpty(this.moca_flu_num) ||
					!isEmpty(this.moca_flu_sc) ||
					!isEmpty(this.moca_fw) ||
					!isEmpty(this.moca_limit) ||
					!isEmpty(this.moca_lio) ||
					!isEmpty(this.moca_month) ||
					!isEmpty(this.moca_place) ||
					!isEmpty(this.moca_red) ||
					!isEmpty(this.moca_rep) ||
					!isEmpty(this.moca_rhino) ||
					!isEmpty(this.moca_ser7) ||
					!isEmpty(this.moca_tm) ||
					!isEmpty(this.moca_total) ||
					!isEmpty(this.moca_velvet) ||
					!isEmpty(this.moca_vig) ||
					!isEmpty(this.moca_year);

			return mainFieldsCompleted || conditionalFieldsCompleted;
		}

		return mainFieldsCompleted;
	}

	private boolean isEmpty(String value) {
		// Если значение null, пустое или равно "-", считаем его незаполненным
		return value == null || value.trim().isEmpty() || value.trim().equals("-");
	}


}


//green if all items completed, red if moca_ex=no, orange if some but not all, blue if none are completed
