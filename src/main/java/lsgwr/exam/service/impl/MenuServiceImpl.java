package lsgwr.exam.service.impl;

import lsgwr.exam.Menu;
import lsgwr.exam.repository.MenuRepository;
import lsgwr.exam.service.MenuService;
import lsgwr.exam.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
   @Autowired
   private MenuRepository menuRepository;
    @Override
    public List<MenuVO> getAllMenus() {
            return menuRepository.findAll();
    }
}
