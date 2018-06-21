package com.solshire.util.tree;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Author koabs
 * @Date 2018/6/21.
 * @Describe
 */
@Getter
@Setter
public class TreeNode<T> {

    private String id;

    private String parentId;

    private T data;

    private List<TreeNode> children;

    public TreeNode(T data) {

        try {
            Field fieldId  = data.getClass().getDeclaredField("id");
            Field fieldParentId  = data.getClass().getDeclaredField("parentId");
            fieldId.setAccessible(true);
            fieldParentId.setAccessible(true);
            this.id = String.valueOf(fieldId.get(data));
            this.parentId = String.valueOf(fieldParentId.get(data));
            this.data = data;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", children=" + children +
                '}';
    }
}
