package lsgwr.exam.controller;

import lsgwr.exam.service.MenuService;
import lsgwr.exam.vo.MenuVO;
import lsgwr.exam.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    ResultVO<List<MenuVO>> getAllMenus() {
        ResultVO<List<MenuVO>>resultVO;
        try {
            List<MenuVO>menuAll=menuService.getMenuTree();
            resultVO = new ResultVO<>(0, "获取全部问题列表成功", menuAll);
        }catch (Exception e){
            resultVO = new ResultVO<>(-1, "获取全部问题列表失败", null);
        }
        return resultVO;

    }
}
