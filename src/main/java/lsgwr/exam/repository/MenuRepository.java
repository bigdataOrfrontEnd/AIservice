package lsgwr.exam.repository;

import lsgwr.exam.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByParentId(Long parentId);

    @Query("SELECT m FROM Menu m WHERE m.parentId IS NULL")
    List<Menu> findRootMenus();
}