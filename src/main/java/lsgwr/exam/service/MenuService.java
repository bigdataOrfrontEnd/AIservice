package lsgwr.exam.service;

import lsgwr.exam.vo.MenuVO;

import java.util.List;

public interface MenuService {
    List<MenuVO> getMenuTree();
}