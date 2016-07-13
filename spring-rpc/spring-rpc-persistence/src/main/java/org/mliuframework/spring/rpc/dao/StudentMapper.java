package org.mliuframework.spring.rpc.dao;

import org.mliuframework.spring.rpc.entity.Student;
import org.mliuframework.spring.rpc.vo.StudentVo;

import java.util.List;

/**
 * Created by Michael on 7/6/16.
 */
public interface StudentMapper {

    StudentVo selectByPrimaryKey(Long id);

    List<StudentVo> selectAll();

    List<StudentVo> selectByProperties(Student student);

    List<StudentVo> selectByName(String name);

    List<StudentVo> selectByIdList(List<Long> idList);

    int insert(Student student);

    int insertSelective(Student student);

    int updateByPrimaryKeySelective(Student student);

}
