package com.company.project.common.tree;

import java.io.Serializable;

/**
 * @author wangzhj
 */
public class JSTree implements Serializable {

    /**  */
    private String id = null;
    /**  */
    private String parent = null;
    /**  */
    private String text = null;
    /**  */
    private String icon = null;
    /**  */
    private State state = null;

    public JSTree() {

    }

    public static class State {

        private boolean opened;

        private boolean disabled;

        private boolean selected;

        public State() {

        }

        public boolean isOpened() {
            return opened;
        }

        public void setOpened(boolean opened) {
            this.opened = opened;
        }

        public boolean isDisabled() {
            return disabled;
        }

        public void setDisabled(boolean disabled) {
            this.disabled = disabled;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
