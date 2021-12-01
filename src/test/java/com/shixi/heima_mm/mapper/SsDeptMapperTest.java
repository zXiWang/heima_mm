package com.shixi.heima_mm.mapper;

import com.shixi.heima_mm.laji.SsDept;
import com.shixi.heima_mm.laji.SsDeptMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SsDeptMapperTest {
    @Autowired
    private SsDeptMapper ssDeptMapper;

    @Test
    public void testFindAll(){
        ssDeptMapper.findAll().forEach(e-> System.out.println(e));
    }
    
    @Test
    public void testInsert(){
        SsDept ssDept=new SsDept();
        ssDept.setDeptId("110");
        ssDept.setDeptName("123");
        ssDept.setParentId("100");
        ssDept.setState(1L);
        int num=ssDeptMapper.insert(ssDept);
    }

}
