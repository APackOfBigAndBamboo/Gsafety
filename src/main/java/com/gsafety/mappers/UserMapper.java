package com.gsafety.mappers;

import com.gsafety.models.Person;
import com.gsafety.models.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @SelectProvider(type = DeployDynamicSQLProvider.class, method = "getUserByCriteriaWithObjects")
    List<User> getUsersAll(String searchText, int offset, int limit);
    @SelectProvider(type = DeployDynamicSQLProvider.class, method = "getUserPage")
    List<User> getUsersAllPage(String searchText);

    @Select("SELECT id,account,accountStatus,accountType,department,password,name,email,mobile,accessControl FROM user")
    List<User> getAllUsersEver();

    @Select("select id,account,accountStatus,accountType,department,password,name,email,mobile,accessControl from user where id = #{id}")
    User getUserById(Integer id);

    @Select("select id,account,accountStatus,accountType,department,password,name,email,mobile,accessControl from user where email = #{email}")
    User getUserByEmail(String email);

    @Update("UPDATE user SET  department = #{department},name = #{name}, accountStatus = #{accountStatus}, \n" +
            "  accountType = #{accountType},mobile = #{mobile},email = #{email} WHERE id = #{id}")
    void updateUser(User user);

    @Update("UPDATE user SET  accountStatus = #{accountStatus} WHERE id = #{id}")
    void updateUsers(User user);

    @Update("UPDATE user SET  department = #{department},name = #{name}, mobile = #{mobile},email = #{email} WHERE id = #{id}")
    void updateUserFromCRm(User user);

    @Update("UPDATE user SET password=#{password} WHERE id = #{id}")
    void resetPassword(User user);

    @Update("UPDATE user SET password = #{password} WHERE id = #{id}")
    void updateUserPassword(User user);

    @Update("UPDATE user SET accessControl = #{accessControl} WHERE id = #{id}")
    void updateUserAccessControl(User user);

    @Insert("INSERT INTO user (account,accountStatus,accountType,department,password,name,email,mobile,accessControl)\n" +
            "VALUES (#{account}, #{accountStatus}, #{accountType}, #{department}, #{password},#{name},#{email},#{mobile},#{accessControl})")
    void insertUser(User user);

    //@SelectProvider(type = DeployDynamicSQLProvider.class,method = "insertAll")
    //void insertAllPerson(List list);

    @Insert("INSERT INTO cperson (cEmail, cMobile, cName, cDepartment) VALUES (#{cEmail},#{cMobile},#{cName},#{cDepartment})")
    void insertPerson(Person person);

    @Select("select * from  cperson\n" +
            "   where (select count(1) as num from user where user.email = cperson.cEmail) = 0;")
    List<Person> newPersonNeedtoInsert();

    @Select("select * from  user\n" +
            "   where (select count(1) as num from cperson where cperson.cEmail = user.email) = 0")
    List<User> oldUserNeedToForbidden();

    @Select("SELECT * FROM user u,cperson c WHERE c.cEmail=u.email AND u.email IS NOT NULL AND c.cEmail IS NOT NULL AND (c.cDepartment!=u.department OR c.cMobile!=u.mobile OR c.cName!=u.name)")
    List<Person> userNeedUpdated();
    @Delete("truncate table cperson")
    void deleteAllPerson();

}