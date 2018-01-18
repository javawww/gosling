package ${bussiPackage}.service.${entityPackage};

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ${bussiPackage}.entity.${entityPackage}.${entityName};
import ${bussiPackage}.dao.${entityPackage}.${entityName}Dao;

/**
 * 
 * @类描述：${ftl_description}实现类
 * @项目名称：gosling-blog-service
 * @包名：${bussiPackage}.service.${entityPackage}
 * @类名称：${entityName}Service
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：${.now}
 */
 @Service(value = "${entityName?uncap_first}Service")
public class ${entityName}Service{

	@Resource(name="${entityName?uncap_first}Dao")
	private ${entityName}Dao ${entityName?uncap_first}Dao; 
	
	<#list originalColumns as po>
 	<#if po.fieldName=="id">
 	/**根据ID获取唯一*/
	public ${entityName} getById(<#if po.fieldType=='INT' || po.fieldType=='TINYINT'>Integer</#if><#if po.fieldType=="VARCHAR">String</#if> ${po.fieldName}){
		return ${entityName?uncap_first}Dao.getById(${po.fieldName});
	}
 	</#if>
 </#list>
	
	/**根据条件获取列表 分页*/
	public List<${entityName}> get${entityName}s(Map<String, String> queryMap, Integer start, Integer size){
		return ${entityName?uncap_first}Dao.get${entityName}s(queryMap,start,size);
	}
    
    /**根据条件获取数量 分页*/
    public Integer get${entityName}sCount(Map<String, String> queryMap){
    	return ${entityName?uncap_first}Dao.get${entityName}sCount(queryMap);
    }
    
     /**保存*/
	public Integer insert(${entityName} ${entityName?uncap_first}){
		return ${entityName?uncap_first}Dao.insert(${entityName?uncap_first});
	}
	
	 /**更新*/
	public Integer update(${entityName} ${entityName?uncap_first}){
		return ${entityName?uncap_first}Dao.update(${entityName?uncap_first});
	}
	
<#list originalColumns as po>
 	<#if po.fieldName=="id">
	/**删除*/
	public Integer delById(<#if po.fieldType=='INT' || po.fieldType=='TINYINT'>Integer</#if><#if po.fieldType=="VARCHAR">String</#if> ${po.fieldName}){
		return ${entityName?uncap_first}Dao.delById(${po.fieldName});
	}
	</#if>
 </#list>
 
 	/**根据对象查询*/
	public List<${entityName}> getByProperties(Map<String, String> queryMap) {
		return ${entityName?uncap_first}Dao.getByProperties(queryMap);
	}
 
}