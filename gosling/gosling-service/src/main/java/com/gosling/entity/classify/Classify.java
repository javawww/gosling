package com.gosling.entity.classify;

 /**
 * 
 * @类描述：文章分类
 * @项目名称：高斯林开源项目
 * @包名：com.gosling.entity.classify
 * @类名称：Classify
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：2018-1-21 12:08:10
 */
public class Classify implements java.io.Serializable {

	/**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long    serialVersionUID  = 6934708541683110498L;
    
	/**主键*/
	private java.lang.Integer id;
	/**父ID*/
	private java.lang.Integer pid;
	/**父路径*/
	private java.lang.String ppath;
	/**名称*/
	private java.lang.String name;
	/**排序 */
	private java.lang.Integer sort;
	/**创建时间*/
	private java.util.Date createTime;
	
	/**
	 *方法: 取得INT
	 *@return: INT  主键
	 */
	public java.lang.Integer  getId(){
		return this.id;
	}

	/**
	 *方法: 设置INT
	 *@param: INT  主键
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得INT
	 *@return: INT  父ID
	 */
	public java.lang.Integer  getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置INT
	 *@param: INT  父ID
	 */
	public void setPid(java.lang.Integer pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得VARCHAR
	 *@return: VARCHAR  父路径
	 */
	public java.lang.String  getPpath(){
		return this.ppath;
	}

	/**
	 *方法: 设置VARCHAR
	 *@param: VARCHAR  父路径
	 */
	public void setPpath(java.lang.String ppath){
		this.ppath = ppath;
	}
	/**
	 *方法: 取得VARCHAR
	 *@return: VARCHAR  名称
	 */
	public java.lang.String  getName(){
		return this.name;
	}

	/**
	 *方法: 设置VARCHAR
	 *@param: VARCHAR  名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得TINYINT
	 *@return: TINYINT  排序 
	 */
	public java.lang.Integer  getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置TINYINT
	 *@param: TINYINT  排序 
	 */
	public void setSort(java.lang.Integer sort){
		this.sort = sort;
	}
	/**
	 *方法: 取得DATETIME
	 *@return: DATETIME  创建时间
	 */
	public java.util.Date  getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置DATETIME
	 *@param: DATETIME  创建时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
}
