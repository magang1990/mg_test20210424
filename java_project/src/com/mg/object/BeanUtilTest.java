package com.mg.object;

import cn.hutool.core.bean.BeanUtil;

/**
 * Apache的BeanUtils拷贝对象是浅拷贝
 * Hutool的BeanUtil拷贝对象是深拷贝
 * 建议对象的拷贝使用MapStruct
 *
 * @author mg
 * @date 2024-10-06
 */
public class BeanUtilTest {
    public static void main(String[] args) {
        WorkContent workContent = new WorkContent().setWorkName("服务").setWorkEfficiency("重要");
        Cattle cattle = new Cattle().setNickName("小牛牛").setAge(3).setMasterName("马斯克").setWorkContent(workContent);
        Horse horse = new Horse();
        BeanUtil.copyProperties(cattle, horse);
    }
}
