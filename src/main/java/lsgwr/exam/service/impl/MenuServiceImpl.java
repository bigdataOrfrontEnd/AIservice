package lsgwr.exam.service.impl;

import lsgwr.exam.entity.Menu;
import lsgwr.exam.repository.MenuRepository;
import lsgwr.exam.service.MenuService;
import lsgwr.exam.vo.MenuVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
   @Autowired
   private MenuRepository menuRepository;
    @Override
    public List<MenuVO> getMenuTree() {
        return buildMenuTree(null);
    }
    private List<MenuVO> buildMenuTree(Long parentId) {
        List<Menu> menus = menuRepository.findByParentId(parentId);
        return menus.stream().map(menu -> {
            MenuVO vo = new MenuVO();
            BeanUtils.copyProperties(menu, vo);
            List<MenuVO> children = buildMenuTree(menu.getId());
            if (!children.isEmpty()) {
                vo.setChildren(children);
            }
            return vo;
        }).collect(Collectors.toList());
    }
}
