<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<#macro mapperEl value>${r"#{"}${value}}</#macro>
<#list originalColumns as po>
 	<#if po.fieldName=="id">
 		<#assign beanKeyField = po.fieldName>
 	</#if>
 </#list>
<mapper namespace="${bussiPackage}.dao.${entityPackage}.${entityName}Dao">
	
	<#list originalColumns as po>
 	<#if po.fieldName=="id">
	<select id="getById" parameterType="<#if po.fieldType=='INT' || po.fieldType=='TINYINT'>Integer</#if><#if po.fieldType=='VARCHAR'>String</#if>" resultType="${bussiPackage}.entity.${entityPackage}.${entityName}">
		select
		   *
		from `${tableName}`
		where `${po.fieldName}` = <@mapperEl beanKeyField/>
	</select>
 	</#if>
 </#list>
 
  <sql id="getCondition">
        <where>
        	<#list originalColumns as po>
        		<#if po.fieldType=='INT'>
        		<if test="queryMap.${po.fieldName} != null and queryMap.${po.fieldName} !='' ">
        			and `${po.fieldName}` = ${specialChar}{queryMap.${po.fieldName}}
        		</if>
        		</#if>
        		<#if po.fieldType=='TINYINT'>
        		<if test="queryMap.${po.fieldName} != null and queryMap.${po.fieldName} !='' ">
        			and `${po.fieldName}` = ${specialChar}{queryMap.${po.fieldName}}
        		</if>
        		</#if>
        		<#if po.fieldType=='VARCHAR'>
        		<if test="queryMap.${po.fieldName} != null and queryMap.${po.fieldName} !='' ">
        			and `${po.fieldName}` like CONCAT('%', ${specialChar}{queryMap.${po.fieldName}}, '%')
        		</if>
        		</#if>
        		<#if po.fieldType=='DECIMAL'>
        		<if test="queryMap.startNumber !=null and  queryMap.startNumber !='' "> 
        			and `${po.fieldName}` &gt; ${specialChar}{queryMap.startNumber}
        		</if>
				<if test="queryMap.endNumber !=null and queryMap.endNumber !='' "> 
					and `${po.fieldName}` &lt; ${specialChar}{queryMap.endNumber} 
				</if>
        		</#if>
        		<#if po.fieldType=='DATETIME'>
        		<if test="queryMap.startDate !=null  and queryMap.startDate !='' "> 
        			and `${po.fieldName}` &gt; ${specialChar}{queryMap.startDate}
        		</if>
				<if test="queryMap.endDate !=null  and queryMap.endDate !='' "> 
					and `${po.fieldName}` &lt; ${specialChar}{queryMap.endDate} 
				</if>
        		</#if>
        	</#list>
        </where>
    </sql>
    
   <select id="get${entityName}s" parameterType="java.util.Map" resultType="${bussiPackage}.entity.${entityPackage}.${entityName}">
		select
		   *
		from `${tableName}`
		<include refid="getCondition"/>
		order by `id` desc
		<if test="size != null and size &gt; 0">limit ${specialChar}{start},${specialChar}{size}</if>
	</select>
	
   <select id="get${entityName}sCount" parameterType="java.util.Map" resultType="Integer">
		select
		   count(*)
		from `${tableName}`
		<include refid="getCondition"/>
   </select>
	
	<insert id="insert" parameterType="${bussiPackage}.entity.${entityPackage}.${entityName}" useGeneratedKeys="true" keyProperty="id" keyColumn="id">
		insert into `${tableName}`
		(
			<#list originalColumns as po>
			<#if po.fieldName!="id">
			`${po.fieldName}`<#if po_has_next>,</#if>
			</#if>
			</#list>
		)
		values
		(
			<#list originalColumns as po>
			<#if po.fieldName!="id">
			${specialChar}{${po.fieldName}}<#if po_has_next>,</#if>
			</#if>
			</#list>
		)
	</insert>
	
	<update id="update" parameterType="${bussiPackage}.entity.${entityPackage}.${entityName}">
        update `${tableName}`
    	<set>
    		<#list originalColumns as po>
			<#if po.fieldName!="id">
			<if test="${po.fieldName} != null">`${po.fieldName}`= ${specialChar}{${po.fieldName}}<#if po_has_next>,</#if></if>
			</#if>
			</#list>
	    </set>
        where `id` = ${specialChar}{id}
	</update>
	
	<delete id="delById">
        delete from `${tableName}` where `id` = ${specialChar}{id}
    </delete>
    
    <select id="getByProperties" parameterType="java.util.Map" resultType="${bussiPackage}.entity.${entityPackage}.${entityName}">
   	 	select
		   *
		from `${tableName}`
		where 1=1
		<#list originalColumns as po>
		<if test="queryMap.${po.fieldName} != null and queryMap.${po.fieldName} !='' ">
   			and `${po.fieldName}` = ${specialChar}{queryMap.${po.fieldName}}
   		</if>
		</#list>
    </select>
    
</mapper>