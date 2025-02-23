package net.mdsgene.admin.generatedproject;

import javax.persistence.*;

@Entity
@Table(name = "survey51", schema = "public")
public class survey51 implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="survey51_id_seq")
    @SequenceGenerator(name="survey51_id_seq", sequenceName="survey51_id_seq", allocationSize=1)
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    private int id;

    private String surveyTwoId;

    public survey51() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "survey_two_id", nullable = true, columnDefinition = "varchar", length = 128)
    public String getSurveyTwoId() {
        return this.surveyTwoId;
    }

    public void setSurveyTwoId(String surveyTwoId) {
        this.surveyTwoId = surveyTwoId;
    }
}
