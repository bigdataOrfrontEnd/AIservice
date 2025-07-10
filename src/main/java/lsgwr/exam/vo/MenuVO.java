package lsgwr.exam.vo;

import lombok.Data;

import java.util.List;

@Data
public class MenuVO {
    private Long id;
    private String icon;
    private String title;
    private String path;
    private String isLink;
    private Long parentId;
    private List<MenuVO> children;
}