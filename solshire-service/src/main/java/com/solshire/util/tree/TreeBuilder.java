package com.solshire.util.tree;

import com.solshire.model.domain.UserPermission;
import com.solshire.util.JsonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author koabs
 * @Date 2018/6/21.
 * @Describe
 */
public class TreeBuilder {

    public static List<TreeNode> build(List list) {

        List<TreeNode> treeNodes = new ArrayList<>();
        for (Object obj : list) {
            treeNodes.add(new TreeNode(obj));
        }

        List<TreeNode> trees = new ArrayList<>();

        for (TreeNode treeNode : treeNodes) {

            if ("0".equals(treeNode.getParentId())) {
                trees.add(treeNode);
            }

            for (TreeNode it : treeNodes) {
                if (it.getParentId().equalsIgnoreCase(treeNode.getId())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.getChildren().add(it);
                }
            }
        }
        return trees;
    }

    public static void main(String[] args) {

        UserPermission treeNode1 = new UserPermission(1L,"url","广州",0L,"1C","1");
        UserPermission treeNode2 = new UserPermission(2L,"url","深圳",0L,"1C","1");
        UserPermission treeNode3 = new UserPermission(3L,"url","天河区",treeNode1.getId(),"1C","1");
        UserPermission treeNode4 = new UserPermission(4L,"url","越秀区",treeNode1.getId(),"1C","1");
        UserPermission treeNode5 = new UserPermission(5L,"url","黄埔区",treeNode1.getId(),"1C","1");
        UserPermission treeNode6 = new UserPermission(6L,"url","石牌",treeNode3.getId(),"1C","1");
        UserPermission treeNode7 = new UserPermission(7L,"url","百脑汇",treeNode6.getId(),"1C","1");
        UserPermission treeNode8 = new UserPermission(8L,"url","南山区",treeNode2.getId(),"1C","1");
        UserPermission treeNode10 = new UserPermission(10L,"url","科技园",treeNode8.getId(),"1C","1");
        UserPermission treeNode11 = new UserPermission(11L,"url","科技园11",treeNode10.getId(),"1C","1");

        List<UserPermission> list = new ArrayList<>();

        list.add(treeNode1);
        list.add(treeNode2);
        list.add(treeNode3);
        list.add(treeNode4);
        list.add(treeNode5);
        list.add(treeNode6);
        list.add(treeNode7);
        list.add(treeNode8);
        list.add(treeNode10);
        list.add(treeNode11);
        List<TreeNode> trees = TreeBuilder.build(list);
        System.out.printf(JsonUtils.toJson(trees));
    }

}
