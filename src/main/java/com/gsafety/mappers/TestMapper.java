package com.gsafety.mappers;

import com.gsafety.models.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TestMapper {
    @Insert("INSERT INTO TencentMailStatusChange (img) VALUE (#{img});")
    void insertPicture(Test test);
    @Select("select img from TencentMailStatusChange where id= #{id}")
    byte[] selectImgById(int id);
}
