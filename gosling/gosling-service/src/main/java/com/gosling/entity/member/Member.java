package com.gosling.entity.member;

 /**
 * 
 * @类描述：会员
 * @项目名称：高斯林开源项目
 * @包名：com.gosling.entity.member
 * @类名称：Member
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：2018-1-18 19:15:24
 */
public class Member implements java.io.Serializable {

	/**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long    serialVersionUID  = 6934708541683110498L;
    
	/***/
	private java.lang.Integer id;
	/***/
	private java.lang.String username;
	/***/
	private java.lang.String password;
	/**昵称*/
	private java.lang.String nickname;
	/**父id*/
	private java.lang.Integer pid;
	
	/**
	 *方法: 取得INT
	 *@return: INT  
	 */
	public java.lang.Integer  getId(){
		return this.id;
	}

	/**
	 *方法: 设置INT
	 *@param: INT  
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得VARCHAR
	 *@return: VARCHAR  
	 */
	public java.lang.String  getUsername(){
		return this.username;
	}

	/**
	 *方法: 设置VARCHAR
	 *@param: VARCHAR  
	 */
	public void setUsername(java.lang.String username){
		this.username = username;
	}
	/**
	 *方法: 取得VARCHAR
	 *@return: VARCHAR  
	 */
	public java.lang.String  getPassword(){
		return this.password;
	}

	/**
	 *方法: 设置VARCHAR
	 *@param: VARCHAR  
	 */
	public void setPassword(java.lang.String password){
		this.password = password;
	}
	/**
	 *方法: 取得VARCHAR
	 *@return: VARCHAR  昵称
	 */
	public java.lang.String  getNickname(){
		return this.nickname;
	}

	/**
	 *方法: 设置VARCHAR
	 *@param: VARCHAR  昵称
	 */
	public void setNickname(java.lang.String nickname){
		this.nickname = nickname;
	}
	/**
	 *方法: 取得INT
	 *@return: INT  父id
	 */
	public java.lang.Integer  getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置INT
	 *@param: INT  父id
	 */
	public void setPid(java.lang.Integer pid){
		this.pid = pid;
	}
}
