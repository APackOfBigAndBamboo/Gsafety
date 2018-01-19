package com.gsafety.mappers;

import com.gsafety.models.Deploy;
import org.apache.ibatis.annotations.*;

import java.io.FileInputStream;
import java.util.List;

public interface DeployMapper {
    @SelectProvider(type = DeployDynamicSQLProvider.class, method = "getDeployAccessControlByCriteriaWithObjects")
    List<Deploy> getDeploysAllByAccessControl(String searchText, int offset, int limit, String accessControlArr);

    @SelectProvider(type = DeployDynamicSQLProvider.class, method = "getDeployAccessControlPage")
    List<Deploy> getDeploysAllByAccessControlPage(String searchText, String accessControlArr);


    @SelectProvider(type = DeployDynamicSQLProvider.class, method = "getDeployAllByCriteriaWithObjects")
    List<Deploy> getDeployAllAccessControl(String searchText, int offset, int limit);

    @SelectProvider(type = DeployDynamicSQLProvider.class, method = "getDeployPage")
    List<Deploy> getDeployPage(String searchText);

    @Select("SELECT id,browser,contact,deploymentInterfacePeople,deploymentServices,industry,manual,script,storageSpace,systemStatus,systemSynopsis,url,master_id,systemName,picture FROM deploy")
    List<Deploy> getDeployAll();

    @Insert("UPDATE deploy SET  picture = #{picture}  WHERE id = #{id};")
    void updatePicture(Deploy deploy);

    @Select("SELECT id,browser,contact,deploymentInterfacePeople,deploymentServices,industry,manual,script,storageSpace,systemStatus,systemSynopsis,url,master_id,systemName,picture FROM deploy WHERE id = #{id}")
    Deploy getDeployById(int id);

    @Select("SELECT picture FROM deploy WHERE id = #{id}")
    Object getpictureById(int id);
}
