package net.mdsgene.admin.ui.survey;

import lombok.Getter;
import lombok.Setter;
import net.mdsgene.admin.admintool.entities.User;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user_surveys")
public class UserSurveys {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fromWhom;
    private String messageId;
    private String localId;
    private String kitId;
    private String projectId;

    @Column(name = "date_of_enrolment")
    private Long dateOfEnrolment;

    private Long createdAt;
    private Long updatedAt;
    private Long sentAt;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "survey_id")
    private String surveyId;

    @Column(name = "favorite")
    private Boolean isFavorite;

    @Column(name = "deleted_at")
    private Long deletedAt;

    @Column(name = "survey_status")
    @Convert(converter = SurveyStatusConverter.class)
    private SurveyStatus status;

//    @OneToMany(mappedBy = "survey", orphanRemoval = true, cascade = CascadeType.ALL)
//    private List<FavoriteSurvey> user;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @Fetch(FetchMode.JOIN)
    private UserSurveys parent;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "workflow_id", referencedColumnName = "id")
//    private Workflow workflow;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.ALL)
//    private Set<UserSurveys> children = new HashSet<>();
//
//    @JsonIgnore
//    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<SurveyAttachment> surveyAttachment;
}