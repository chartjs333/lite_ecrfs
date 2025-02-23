package net.mdsgene.admin.ui.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<UserSurveys, Long>, JpaSpecificationExecutor {

    @Modifying
    @Query("update UserSurveys ue set ue.deletedAt = :deletedAt WHERE ue.id = :id")
    void updateDeletedAt(@Param("id") Long id, @Param("deletedAt") Long deletedAt);

    @Modifying
    @Query("update UserSurveys ue set ue.isFavorite = :isFavorite WHERE ue.id = :id")
    void updateIsFavorite(@Param("id") Long id, @Param("isFavorite") boolean isFavorite);
}
