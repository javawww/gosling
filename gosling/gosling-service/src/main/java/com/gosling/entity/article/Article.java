package com.gosling.entity.article;

 /**
 * 
 * @类描述：文章
 * @项目名称：高斯林开源项目
 * @包名：com.gosling.entity.article
 * @类名称：Article
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：2018-1-21 12:05:36
 */
public class Article implements java.io.Serializable {

	/**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long    serialVersionUID  = 6934708541683110498L;
    
	/**主键*/
	private java.lang.Integer id;
	/**分类ID*/
	private java.lang.Integer typeId;
	/**分类路径*/
	private java.lang.String typePath;
	/**标题*/
	private java.lang.String title;
	/**内容*/
	private java.lang.String content;
	/**作者*/
	private java.lang.String author;
	/**创建人id*/
	private java.lang.Integer createId;
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
	 *@return: INT  分类ID
	 */
	public java.lang.Integer  getTypeId(){
		return this.typeId;
	}

	/**
	 *方法: 设置INT
	 *@param: INT  分类ID
	 */
	public void setTypeId(java.lang.Integer typeId){
		this.typeId = typeId;
	}
	/**
	 *方法: 取得VARCHAR
	 *@return: VARCHAR  分类路径
	 */
	public java.lang.String  getTypePath(){
		return this.typePath;
	}

	/**
	 *方法: 设置VARCHAR
	 *@param: VARCHAR  分类路径
	 */
	public void setTypePath(java.lang.String typePath){
		this.typePath = typePath;
	}
	/**
	 *方法: 取得VARCHAR
	 *@return: VARCHAR  标题
	 */
	public java.lang.String  getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置VARCHAR
	 *@param: VARCHAR  标题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得TEXT
	 *@return: TEXT  内容
	 */
	public java.lang.String  getContent(){
		return this.content;
	}

	/**
	 *方法: 设置TEXT
	 *@param: TEXT  内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得VARCHAR
	 *@return: VARCHAR  作者
	 */
	public java.lang.String  getAuthor(){
		return this.author;
	}

	/**
	 *方法: 设置VARCHAR
	 *@param: VARCHAR  作者
	 */
	public void setAuthor(java.lang.String author){
		this.author = author;
	}
	/**
	 *方法: 取得INT
	 *@return: INT  创建人id
	 */
	public java.lang.Integer  getCreateId(){
		return this.createId;
	}

	/**
	 *方法: 设置INT
	 *@param: INT  创建人id
	 */
	public void setCreateId(java.lang.Integer createId){
		this.createId = createId;
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
