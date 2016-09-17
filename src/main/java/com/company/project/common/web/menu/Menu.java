package com.company.project.common.web.menu;

/**
 * 菜单对象
 *
 * @author wangzhj
 */
public class Menu {

    /** 节点编号 */
    private Long id = null;
    /** 节点父编号 */
    private Long pId = null;

    /** 节点名称 */
    private String name = null;
    /**  */
    private String url = null;
    /**  */
    private String target = "_self";

    /** 展开 */
    private boolean open = true;
    /** 不可选 */
    private boolean nocheck = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isNocheck() {
        return nocheck;
    }

    public void setNocheck(boolean nocheck) {
        this.nocheck = nocheck;
    }

    public String getTarget() {
        return target;
    }
}
