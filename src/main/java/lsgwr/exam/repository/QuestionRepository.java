/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2019-05-14 08:25
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package lsgwr.exam.repository;

import lsgwr.exam.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    List<Question> findByQuestionTypeId(Integer id);
    @Query("select q from Question q order by q.updateTime desc")
    List<Question> findAll();
    // 随机获取题目（MySQL方式）
    @Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Question> findRandomQuestions(@Param("limit") int limit);
//    // 按条件随机获取题目
//    @Query(value = " SELECT * FROM question
//        WHERE (:categoryId IS NULL OR question_category_id = :categoryId)
//          AND (:levelId IS NULL OR question_level_id = :levelId)
//          AND (:examYear IS NULL OR question_exam_year = :examYear)
//        ORDER BY RAND()
//        LIMIT :limit
//        ", nativeQuery = true)
//    List<Question> findRandomQuestionsByConditions(
//            @Param("categoryId") Integer categoryId,
//            @Param("levelId") Integer levelId,
//            @Param("examYear") String examYear,
//            @Param("limit") int limit
//    );
}
