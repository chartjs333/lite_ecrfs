package net.mdsgene.admin.generatedproject;

import java.util.Date;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "PINK1PRKN130", schema = "public")
@Cacheable(false)
public class PINK1PRKN130 implements java.io.Serializable {

    private static final Logger log = LoggerFactory.getLogger(PINK1PRKN130.class);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PINK1PRKN130_id_seq")
    @SequenceGenerator(name="PINK1PRKN130_id_seq", sequenceName="PINK1PRKN130_id_seq", allocationSize=1)
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    private int id;

    public PINK1PRKN130() {
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

    private String scopaaut1;

    @Column(name = "scopaaut1", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut1() {
        return this.scopaaut1;
    }

    public void setScopaaut1(String scopaaut1) {
        this.scopaaut1 = scopaaut1;
    }

    private String scopaaut10;

    @Column(name = "scopaaut10", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut10() {
        return this.scopaaut10;
    }

    public void setScopaaut10(String scopaaut10) {
        this.scopaaut10 = scopaaut10;
    }

    private String scopaaut11;

    @Column(name = "scopaaut11", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut11() {
        return this.scopaaut11;
    }

    public void setScopaaut11(String scopaaut11) {
        this.scopaaut11 = scopaaut11;
    }

    private String scopaaut12;

    @Column(name = "scopaaut12", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut12() {
        return this.scopaaut12;
    }

    public void setScopaaut12(String scopaaut12) {
        this.scopaaut12 = scopaaut12;
    }

    private String scopaaut13;

    @Column(name = "scopaaut13", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut13() {
        return this.scopaaut13;
    }

    public void setScopaaut13(String scopaaut13) {
        this.scopaaut13 = scopaaut13;
    }

    private String scopaaut14;

    @Column(name = "scopaaut14", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut14() {
        return this.scopaaut14;
    }

    public void setScopaaut14(String scopaaut14) {
        this.scopaaut14 = scopaaut14;
    }

    private String scopaaut15;

    @Column(name = "scopaaut15", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut15() {
        return this.scopaaut15;
    }

    public void setScopaaut15(String scopaaut15) {
        this.scopaaut15 = scopaaut15;
    }

    private String scopaaut16;

    @Column(name = "scopaaut16", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut16() {
        return this.scopaaut16;
    }

    public void setScopaaut16(String scopaaut16) {
        this.scopaaut16 = scopaaut16;
    }

    private String scopaaut17;

    @Column(name = "scopaaut17", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut17() {
        return this.scopaaut17;
    }

    public void setScopaaut17(String scopaaut17) {
        this.scopaaut17 = scopaaut17;
    }

    private String scopaaut18;

    @Column(name = "scopaaut18", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut18() {
        return this.scopaaut18;
    }

    public void setScopaaut18(String scopaaut18) {
        this.scopaaut18 = scopaaut18;
    }

    private String scopaaut19;

    @Column(name = "scopaaut19", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut19() {
        return this.scopaaut19;
    }

    public void setScopaaut19(String scopaaut19) {
        this.scopaaut19 = scopaaut19;
    }

    private String scopaaut2;

    @Column(name = "scopaaut2", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut2() {
        return this.scopaaut2;
    }

    public void setScopaaut2(String scopaaut2) {
        this.scopaaut2 = scopaaut2;
    }

    private String scopaaut20;

    @Column(name = "scopaaut20", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut20() {
        return this.scopaaut20;
    }

    public void setScopaaut20(String scopaaut20) {
        this.scopaaut20 = scopaaut20;
    }

    private String scopaaut21;

    @Column(name = "scopaaut21", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut21() {
        return this.scopaaut21;
    }

    public void setScopaaut21(String scopaaut21) {
        this.scopaaut21 = scopaaut21;
    }

    private String scopaaut22;

    @Column(name = "scopaaut22", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut22() {
        return this.scopaaut22;
    }

    public void setScopaaut22(String scopaaut22) {
        this.scopaaut22 = scopaaut22;
    }

    private String scopaaut23;

    @Column(name = "scopaaut23", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut23() {
        return this.scopaaut23;
    }

    public void setScopaaut23(String scopaaut23) {
        this.scopaaut23 = scopaaut23;
    }

    private String scopaaut23a;

    @Column(name = "scopaaut23a", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut23a() {
        return this.scopaaut23a;
    }

    public void setScopaaut23a(String scopaaut23a) {
        this.scopaaut23a = scopaaut23a;
    }

    private String scopaaut23a1;

    @Column(name = "scopaaut23a1", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut23a1() {
        return this.scopaaut23a1;
    }

    public void setScopaaut23a1(String scopaaut23a1) {
        this.scopaaut23a1 = scopaaut23a1;
    }

    private String scopaaut24;

    @Column(name = "scopaaut24", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut24() {
        return this.scopaaut24;
    }

    public void setScopaaut24(String scopaaut24) {
        this.scopaaut24 = scopaaut24;
    }

    private String scopaaut25;

    @Column(name = "scopaaut25", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut25() {
        return this.scopaaut25;
    }

    public void setScopaaut25(String scopaaut25) {
        this.scopaaut25 = scopaaut25;
    }

    private String scopaaut26a;

    @Column(name = "scopaaut26a", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut26a() {
        return this.scopaaut26a;
    }

    public void setScopaaut26a(String scopaaut26a) {
        this.scopaaut26a = scopaaut26a;
    }

    private String scopaaut26a1;

    @Column(name = "scopaaut26a1", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut26a1() {
        return this.scopaaut26a1;
    }

    public void setScopaaut26a1(String scopaaut26a1) {
        this.scopaaut26a1 = scopaaut26a1;
    }

    private String scopaaut26b;

    @Column(name = "scopaaut26b", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut26b() {
        return this.scopaaut26b;
    }

    public void setScopaaut26b(String scopaaut26b) {
        this.scopaaut26b = scopaaut26b;
    }

    private String scopaaut26b1;

    @Column(name = "scopaaut26b1", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut26b1() {
        return this.scopaaut26b1;
    }

    public void setScopaaut26b1(String scopaaut26b1) {
        this.scopaaut26b1 = scopaaut26b1;
    }

    private String scopaaut26c;

    @Column(name = "scopaaut26c", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut26c() {
        return this.scopaaut26c;
    }

    public void setScopaaut26c(String scopaaut26c) {
        this.scopaaut26c = scopaaut26c;
    }

    private String scopaaut26c1;

    @Column(name = "scopaaut26c1", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut26c1() {
        return this.scopaaut26c1;
    }

    public void setScopaaut26c1(String scopaaut26c1) {
        this.scopaaut26c1 = scopaaut26c1;
    }

    private String scopaaut26d;

    @Column(name = "scopaaut26d", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut26d() {
        return this.scopaaut26d;
    }

    public void setScopaaut26d(String scopaaut26d) {
        this.scopaaut26d = scopaaut26d;
    }

    private String scopaaut26d1;

    @Column(name = "scopaaut26d1", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut26d1() {
        return this.scopaaut26d1;
    }

    public void setScopaaut26d1(String scopaaut26d1) {
        this.scopaaut26d1 = scopaaut26d1;
    }

    private String scopaaut3;

    @Column(name = "scopaaut3", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut3() {
        return this.scopaaut3;
    }

    public void setScopaaut3(String scopaaut3) {
        this.scopaaut3 = scopaaut3;
    }

    private String scopaaut4;

    @Column(name = "scopaaut4", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut4() {
        return this.scopaaut4;
    }

    public void setScopaaut4(String scopaaut4) {
        this.scopaaut4 = scopaaut4;
    }

    private String scopaaut5;

    @Column(name = "scopaaut5", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut5() {
        return this.scopaaut5;
    }

    public void setScopaaut5(String scopaaut5) {
        this.scopaaut5 = scopaaut5;
    }

    private String scopaaut6;

    @Column(name = "scopaaut6", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut6() {
        return this.scopaaut6;
    }

    public void setScopaaut6(String scopaaut6) {
        this.scopaaut6 = scopaaut6;
    }

    private String scopaaut7;

    @Column(name = "scopaaut7", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut7() {
        return this.scopaaut7;
    }

    public void setScopaaut7(String scopaaut7) {
        this.scopaaut7 = scopaaut7;
    }

    private String scopaaut8;

    @Column(name = "scopaaut8", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut8() {
        return this.scopaaut8;
    }

    public void setScopaaut8(String scopaaut8) {
        this.scopaaut8 = scopaaut8;
    }

    private String scopaaut9;

    @Column(name = "scopaaut9", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut9() {
        return this.scopaaut9;
    }

    public void setScopaaut9(String scopaaut9) {
        this.scopaaut9 = scopaaut9;
    }

    private String scopaaut_ex;

    @Column(name = "scopaaut_ex", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaaut_ex() {
        return this.scopaaut_ex;
    }

    public void setScopaaut_ex(String scopaaut_ex) {
        this.scopaaut_ex = scopaaut_ex;
    }

    private String scopaauta;

    @Column(name = "scopaauta", nullable = true, columnDefinition = "varchar", length = 128)
    public String getScopaauta() {
        return this.scopaauta;
    }

    public void setScopaauta(String scopaauta) {
        this.scopaauta = scopaauta;
    }

	/**
	 * Метод возвращает статус заполненности формы:
	 * - blue: если ни одно рабочее поле (без заголовков) не заполнено;
	 * - red: если тест не проводился (scopaaut_ex == "2");
	 * - green: если тест проведён (scopaaut_ex == "1") и все обязательные рабочие поля заполнены,
	 * - orange: если тест проведён, но отсутствуют обязательные поля.
	 */
	public String getStatusColor() {
		if (areAllWorkingFieldsEmpty()) {
			log.info("Все рабочие поля пусты → blue");
			return "blue";
		}
		if ("2".equalsIgnoreCase(scopaaut_ex)) {
			log.info("scopaaut_ex == '2' → тест не проводился → red");
			return "red";
		}
		if ("1".equalsIgnoreCase(scopaaut_ex)) {
			if (areAllWorkingFieldsCompleted()) {
				log.info("Все обязательные рабочие поля заполнены → green");
				return "green";
			} else {
				log.info("Некоторые обязательные рабочие поля не заполнены → orange");
				return "orange";
			}
		}
		log.info("Рабочие поля заполнены частично → orange");
		return "orange";
	}

	/**
	 * Проверяет, что все рабочие поля (без заголовков) пусты.
	 * Для зависимых полей:
	 * - Если scopaaut23a == "1", то scopaaut23a1 должна быть пустой.
	 * - Если scopaaut26a == "1", то scopaaut26a1 должна быть пустой.
	 * - Если scopaaut26b == "1", то scopaaut26b1 должна быть пустой.
	 * - Если scopaaut26c == "1", то scopaaut26c1 должна быть пустой.
	 */
	private boolean areAllWorkingFieldsEmpty() {
		boolean baseEmpty = isEmpty(surveyTwoId)
				&& isEmpty(fillingStatus)
				&& isEmpty(scopaaut_ex)
				&& isEmpty(scopaaut1)
				&& isEmpty(scopaaut2)
				&& isEmpty(scopaaut3)
				&& isEmpty(scopaaut4)
				&& isEmpty(scopaaut5)
				&& isEmpty(scopaaut6)
				&& isEmpty(scopaaut7)
				&& isEmpty(scopaaut8)
				&& isEmpty(scopaaut9)
				&& isEmpty(scopaaut10)
				&& isEmpty(scopaaut11)
				&& isEmpty(scopaaut12)
				&& isEmpty(scopaaut13)
				&& isEmpty(scopaaut14)
				&& isEmpty(scopaaut15)
				&& isEmpty(scopaaut16)
				&& isEmpty(scopaaut17)
				&& isEmpty(scopaaut18)
				&& isEmpty(scopaaut19)
				&& isEmpty(scopaaut20)
				&& isEmpty(scopaaut21)
				&& isEmpty(scopaaut22)
				&& isEmpty(scopaaut23)
				&& isEmpty(scopaaut24)
				&& isEmpty(scopaaut25);
		// Зависимые проверки:
		boolean dep23Empty = true;
		if (!isEmpty(scopaaut23a)) {
			dep23Empty = "1".equals(scopaaut23a) ? isEmpty(scopaaut23a1) : false;
		}
		boolean dep26aEmpty = true;
		if (!isEmpty(scopaaut26a)) {
			dep26aEmpty = "1".equals(scopaaut26a) ? isEmpty(scopaaut26a1) : false;
		}
		boolean dep26bEmpty = true;
		if (!isEmpty(scopaaut26b)) {
			dep26bEmpty = "1".equals(scopaaut26b) ? isEmpty(scopaaut26b1) : false;
		}
		boolean dep26cEmpty = true;
		if (!isEmpty(scopaaut26c)) {
			dep26cEmpty = "1".equals(scopaaut26c) ? isEmpty(scopaaut26c1) : false;
		}
		boolean dep26dEmpty = true;
		if (!isEmpty(scopaaut26d)) {
			dep26dEmpty = "1".equals(scopaaut26d) ? isEmpty(scopaaut26d1) : false;
		}
		return baseEmpty && dep23Empty && dep26aEmpty && dep26bEmpty && dep26cEmpty && dep26dEmpty;
	}

	/**
	 * Проверяет, что все обязательные рабочие поля заполнены.
	 * Для зависимых полей:
	 * - Если scopaaut23a == "1", то scopaaut23a1 должно быть заполнено.
	 * - Если scopaaut26a == "1", то scopaaut26a1 должно быть заполнено.
	 * - Если scopaaut26b == "1", то scopaaut26b1 должно быть заполнено.
	 * - Если scopaaut26c == "1", то scopaaut26c1 должно быть заполнено.
	 * - Если scopaaut26d == "1", то scopaaut26d1 должно быть заполнено.
	 */
	private boolean areAllWorkingFieldsCompleted() {
		boolean complete = true;
		if (isEmpty(surveyTwoId)) {
			log.info("Поле surveyTwoId не заполнено");
			complete = false;
		}
		if (isEmpty(fillingStatus)) {
			log.info("Поле fillingStatus не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut_ex)) {
			log.info("Поле scopaaut_ex не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut1)) {
			log.info("Поле scopaaut1 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut2)) {
			log.info("Поле scopaaut2 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut3)) {
			log.info("Поле scopaaut3 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut4)) {
			log.info("Поле scopaaut4 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut5)) {
			log.info("Поле scopaaut5 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut6)) {
			log.info("Поле scopaaut6 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut7)) {
			log.info("Поле scopaaut7 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut8)) {
			log.info("Поле scopaaut8 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut9)) {
			log.info("Поле scopaaut9 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut10)) {
			log.info("Поле scopaaut10 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut11)) {
			log.info("Поле scopaaut11 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut12)) {
			log.info("Поле scopaaut12 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut13)) {
			log.info("Поле scopaaut13 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut14)) {
			log.info("Поле scopaaut14 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut15)) {
			log.info("Поле scopaaut15 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut16)) {
			log.info("Поле scopaaut16 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut17)) {
			log.info("Поле scopaaut17 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut18)) {
			log.info("Поле scopaaut18 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut19)) {
			log.info("Поле scopaaut19 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut20)) {
			log.info("Поле scopaaut20 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut21)) {
			log.info("Поле scopaaut21 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut22)) {
			log.info("Поле scopaaut22 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut23)) {
			log.info("Поле scopaaut23 не заполнено");
			complete = false;
		}
		// Зависимое поле scopaaut23a и scopaaut23a1
		if (isEmpty(scopaaut23a)) {
			log.info("Поле scopaaut23a не заполнено");
			complete = false;
		} else if ("1".equals(scopaaut23a)) {
			if (isEmpty(scopaaut23a1)) {
				log.info("Поле scopaaut23a1 не заполнено, хотя scopaaut23a == \"1\"");
				complete = false;
			}
		}
		if (isEmpty(scopaaut24)) {
			log.info("Поле scopaaut24 не заполнено");
			complete = false;
		}
		if (isEmpty(scopaaut25)) {
			log.info("Поле scopaaut25 не заполнено");
			complete = false;
		}
		// Зависимое поле scopaaut26a и scopaaut26a1
		if (isEmpty(scopaaut26a)) {
			log.info("Поле scopaaut26a не заполнено");
			complete = false;
		} else if ("1".equals(scopaaut26a)) {
			if (isEmpty(scopaaut26a1)) {
				log.info("Поле scopaaut26a1 не заполнено, хотя scopaaut26a == \"1\"");
				complete = false;
			}
		}
		// Зависимое поле scopaaut26b и scopaaut26b1
		if (isEmpty(scopaaut26b)) {
			log.info("Поле scopaaut26b не заполнено");
			complete = false;
		} else if ("1".equals(scopaaut26b)) {
			if (isEmpty(scopaaut26b1)) {
				log.info("Поле scopaaut26b1 не заполнено, хотя scopaaut26b == \"1\"");
				complete = false;
			}
		}
		// Зависимое поле scopaaut26c и scopaaut26c1
		if (isEmpty(scopaaut26c)) {
			log.info("Поле scopaaut26c не заполнено");
			complete = false;
		} else if ("1".equals(scopaaut26c)) {
			if (isEmpty(scopaaut26c1)) {
				log.info("Поле scopaaut26c1 не заполнено, хотя scopaaut26c == \"1\"");
				complete = false;
			}
		}
		// Зависимое поле scopaaut26d и scopaaut26d1
		if (isEmpty(scopaaut26d)) {
			log.info("Поле scopaaut26d не заполнено");
			complete = false;
		} else if ("1".equals(scopaaut26d)) {
			if (isEmpty(scopaaut26d1)) {
				log.info("Поле scopaaut26d1 не заполнено, хотя scopaaut26d == \"1\"");
				complete = false;
			}
		}
		if (isEmpty(scopaauta)) {
			log.info("Поле scopaauta не заполнено");
			complete = false;
		}
		return complete;
	}

	/**
	 * Проверяет, что хотя бы одно рабочее поле заполнено.
	 */
	private boolean isAtLeastOneFieldCompleted() {
		return !isEmpty(surveyTwoId)
				|| !isEmpty(fillingStatus)
				|| !isEmpty(scopaaut_ex)
				|| !isEmpty(scopaaut1)
				|| !isEmpty(scopaaut2)
				|| !isEmpty(scopaaut3)
				|| !isEmpty(scopaaut4)
				|| !isEmpty(scopaaut5)
				|| !isEmpty(scopaaut6)
				|| !isEmpty(scopaaut7)
				|| !isEmpty(scopaaut8)
				|| !isEmpty(scopaaut9)
				|| !isEmpty(scopaaut10)
				|| !isEmpty(scopaaut11)
				|| !isEmpty(scopaaut12)
				|| !isEmpty(scopaaut13)
				|| !isEmpty(scopaaut14)
				|| !isEmpty(scopaaut15)
				|| !isEmpty(scopaaut16)
				|| !isEmpty(scopaaut17)
				|| !isEmpty(scopaaut18)
				|| !isEmpty(scopaaut19)
				|| !isEmpty(scopaaut20)
				|| !isEmpty(scopaaut21)
				|| !isEmpty(scopaaut22)
				|| !isEmpty(scopaaut23)
				|| !isEmpty(scopaaut23a)
				|| !isEmpty(scopaaut23a1)
				|| !isEmpty(scopaaut24)
				|| !isEmpty(scopaaut25)
				|| !isEmpty(scopaaut26a)
				|| !isEmpty(scopaaut26a1)
				|| !isEmpty(scopaaut26b)
				|| !isEmpty(scopaaut26b1)
				|| !isEmpty(scopaaut26c)
				|| !isEmpty(scopaaut26c1)
				|| !isEmpty(scopaaut26d)
				|| !isEmpty(scopaaut26d1)
				|| !isEmpty(scopaauta);
	}

	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}
}


