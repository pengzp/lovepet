package com.pet.lovepet.dao.mapper;

import com.pet.lovepet.entity.RolePermission;

public interface RolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated
     */
    int insert(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated
     */
    int insertSelective(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated
     */
    RolePermission selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(RolePermission record);
}