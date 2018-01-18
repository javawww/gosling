package ${bussiPackage}.entity.${entityPackage};

 /**
 * 
 * @类描述：${ftl_description}
 * @项目名称：高斯林开源项目
 * @包名：${bussiPackage}.entity.${entityPackage}
 * @类名称：${entityName}
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：${.now}
 */
public class ${entityName} implements java.io.Serializable {

	/**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long    serialVersionUID  = 6934708541683110498L;
    
	<#list originalColumns as po>
	/**${po.filedComment}*/
	private <#if po.fieldType=='INT' || po.fieldType=='TINYINT'>java.lang.Integer</#if><#if po.fieldType=='DECIMAL'>java.math.BigDecimal</#if><#if po.fieldType=='DATETIME'>java.util.Date</#if><#if po.fieldType=="VARCHAR" || po.fieldType=="TEXT">java.lang.String</#if> ${po.fieldName};
	</#list>
	
	<#list originalColumns as po>
	/**
	 *方法: 取得${po.fieldType}
	 *@return: ${po.fieldType}  ${po.filedComment}
	 */
	public <#if po.fieldType=='INT' || po.fieldType=='TINYINT'>java.lang.Integer</#if><#if po.fieldType=='DECIMAL'>java.math.BigDecimal</#if><#if po.fieldType=='DATETIME'>java.util.Date</#if><#if po.fieldType=="VARCHAR" || po.fieldType=="TEXT">java.lang.String</#if>  get${po.fieldName?cap_first}(){
		return this.${po.fieldName};
	}

	/**
	 *方法: 设置${po.fieldType}
	 *@param: ${po.fieldType}  ${po.filedComment}
	 */
	public void set${po.fieldName?cap_first}(<#if po.fieldType=='INT' || po.fieldType=='TINYINT'>java.lang.Integer</#if><#if po.fieldType=='DECIMAL'>java.math.BigDecimal</#if><#if po.fieldType=='DATETIME'>java.util.Date</#if><#if po.fieldType=="VARCHAR" || po.fieldType=="TEXT">java.lang.String</#if> ${po.fieldName}){
		this.${po.fieldName} = ${po.fieldName};
	}
	</#list>
}
