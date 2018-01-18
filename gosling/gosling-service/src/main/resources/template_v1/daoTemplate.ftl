package ${bussiPackage}.dao.${entityPackage};

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import ${bussiPackage}.entity.${entityPackage}.${entityName};

/**
 * 
 * @类描述：${ftl_description}
 * @项目名称：高斯林开源项目
 * @包名：${bussiPackage}.dao.${entityPackage}
 * @类名称：${entityName}Dao
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：${.now}
 */
@Repository
public interface ${entityName}Dao {
 
 <#list originalColumns as po>
 	<#if po.fieldName=="id">
 	/**根据ID获取唯一*/
	${entityName} getById(<#if po.fieldType=='INT' || po.fieldType=='TINYINT'>Integer</#if><#if po.fieldType=="VARCHAR">String</#if> ${po.fieldName});
 	</#if>
 </#list>
	
	/**根据条件获取列表 分页*/
	List<${entityName}> get${entityName}s(@Param("queryMap") Map<String, String> queryMap,
                            @Param("start") Integer start, @Param("size") Integer size);
    
    /**根据条件获取数量 分页*/
    Integer get${entityName}sCount(@Param("queryMap") Map<String, String> queryMap);
    
     /**保存*/
	Integer insert(${entityName} ${entityName?uncap_first});
	
	 /**更新*/
	Integer update(${entityName} ${entityName?uncap_first});
	
<#list originalColumns as po>
 	<#if po.fieldName=="id">
	/**删除*/
	Integer delById(<#if po.fieldType=='INT' || po.fieldType=='TINYINT'>Integer</#if><#if po.fieldType=="VARCHAR">String</#if> ${po.fieldName});
	</#if>
 </#list>
	
	/**根据对象查询*/
	List<${entityName}> getByProperties(@Param("queryMap") Map<String, String> queryMap);
}