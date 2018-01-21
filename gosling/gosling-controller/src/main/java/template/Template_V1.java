package template;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.prompt.PromptSupport;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * @author Administrator
 *	此模板特点：
 *	一、调用流程：service -- >  dao   -- > mapper 
 *	二、抛弃service接口层，直接在service实现层注入dao进行业务处理
 *	三、dao层进行数据的存取操作
 *	四、推荐使用指数：五颗星
 */
@SuppressWarnings("serial")
public class Template_V1 extends JFrame implements ActionListener {
	// 全局属性
	JPanel jp = null;
	Connection conn;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	List<Columnt> columns = new ArrayList();

	JLabel lbshow = new JLabel("欢迎您的使用");

	static JTextField jdbc_driver = new JTextField();
	static JTextField jdbc_url = new JTextField();
	static JTextField jdbc_username = new JTextField();
	static JTextField jdbc_password = new JTextField();
	static JTextField jdbc_dbType = new JTextField();

	static JTextField source_root_package = new JTextField();
	static JTextField webroot_package = new JTextField();
	static JTextField template_path = new JTextField();
	static JTextField bussi_package = new JTextField();
	static JTextField system_encoding = new JTextField();
	//
	static JTextField package_name = new JTextField();
	static JTextField table_name = new JTextField();
	static JTextField table_desc = new JTextField();
	static JTextField entity_name = new JTextField();
	//模板名称
	static JTextField controller_template = new JTextField();
	static JTextField list_template = new JTextField();
	static JTextField add_template = new JTextField();
	static JTextField edit_template = new JTextField();

	JButton extbtn, confirmbtn;

	String entityPackage, rootpackage, webrootpackage, diypackage, templatepath, entityName, description, tableName;
	
	/**
	 * 
	 * @描述:
	 * @方法名: main
	 * @param args
	 * @返回类型 void
	 * @创建人 Administrator
	 * @创建时间 2017年12月10日下午12:24:25
	 */
	public static void main(String[] args) {
		// step1 执行
		new Template_V1();
	}

	/**
	 * 静态代码块 step2 初始化数据
	 */
	static {
		//-----------------------------------------
		//数据库连接信息
		//==============================================
		InputStream dbin = Template_V1.class.getResourceAsStream("/config/jdbc.properties");
		//-----------------------------------------
		//配置信息
		//==============================================
		InputStream sysin = Template_V1.class.getResourceAsStream("/config/sys.properties");
		Properties dbprops = new Properties();
		Properties sysprops = new Properties();
		try {
			dbprops.load(dbin);
			sysprops.load(sysin);
			// 数据库参数配置
			jdbc_driver.setText(dbprops.getProperty("jdbc_driver"));
			jdbc_url.setText(dbprops.getProperty("jdbc_url"));
			jdbc_username.setText(dbprops.getProperty("jdbc_username"));
			jdbc_password.setText(dbprops.getProperty("jdbc_password"));
			// 代码生成参数配置
			source_root_package.setText(sysprops.getProperty("source_root_package"));//源代码根路径
			webroot_package.setText(sysprops.getProperty("webroot_package"));//页面根路径
			template_path.setText(sysprops.getProperty("template_path"));//模板文件路径
			bussi_package.setText(sysprops.getProperty("bussi_package"));//根包
			//模板名称
			controller_template.setText("controllerTemplate.ftl");
			list_template.setText("listTemplate.ftl");
			add_template.setText("addTemplate.ftl");
			edit_template.setText("editTemplate.ftl");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 无参构造方法
	 */
	public Template_V1() {
		// step3 初始化主界面
		initGUI();
	}

	private void initGUI() {
		jp = new JPanel();
		jp.setLayout(new GridLayout(0, 2));
		this.setContentPane(jp);
		this.setTitle("技术交流群：327947585");
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setSize(new Dimension(600, 600));
		this.setResizable(false);
		this.setLocationRelativeTo(getOwner()); // 让窗体居中显示
		// this.setLocation(0, 0);
		// step4 渲染界面控件
		paintGUI();
		pack();
	}

	private void paintGUI() {
		//-----------------------------------------------------
		//数据库信息
		//========================================================
		jp.add(new JLabel("提示(默认值):", SwingConstants.CENTER));
		jp.add(lbshow);
		jp.add(new JLabel("数据库url(默认值):", SwingConstants.CENTER));
		jp.add(jdbc_url);
		jp.add(new JLabel("用户名(默认值):", SwingConstants.CENTER));
		jp.add(jdbc_username);
		jp.add(new JLabel("密码(默认值):", SwingConstants.CENTER));
		jp.add(jdbc_password);

		//-----------------------------------------------------
		//路径信息
		//========================================================
		jp.add(new JLabel("源码根包(默认值):", SwingConstants.CENTER));
		jp.add(source_root_package);
		jp.add(new JLabel("Web根路径(默认值):", SwingConstants.CENTER));
		jp.add(webroot_package);
		jp.add(new JLabel("模板所在目录(默认值):", SwingConstants.CENTER));
		jp.add(template_path);
		jp.add(new JLabel("自定义根包(默认值):", SwingConstants.CENTER));
		jp.add(bussi_package);
		
		//-----------------------------------------------------
		//实体类、表
		//========================================================
		jp.add(new JLabel("业务包名(小写):", SwingConstants.CENTER));
		jp.add(package_name);
		PromptSupport.setPrompt("member", package_name);
		jp.add(new JLabel("业务表名:", SwingConstants.CENTER));
		jp.add(table_name);
		PromptSupport.setPrompt("member", table_name);
		jp.add(new JLabel("业务实体类名(首字母大写):", SwingConstants.CENTER));
		jp.add(entity_name);
		PromptSupport.setPrompt("Member", entity_name);
		jp.add(new JLabel("业务功能描述:", SwingConstants.CENTER));
		jp.add(table_desc);
		PromptSupport.setPrompt("会员管理", table_desc);
		jp.add(new JLabel("----------------------------", SwingConstants.CENTER));
		jp.add(new JLabel("----------------------------", SwingConstants.CENTER));
		
		//-----------------------------------------------------
		//模板文件
		//========================================================
		jp.add(new JLabel("controller模板文件:", SwingConstants.CENTER));
		jp.add(controller_template);
		PromptSupport.setPrompt("controllerTemplate.ftl", controller_template);
		jp.add(new JLabel("list模板文件:", SwingConstants.CENTER));
		jp.add(list_template);
		PromptSupport.setPrompt("listTemplate.ftl", list_template);
		jp.add(new JLabel("add模板文件:", SwingConstants.CENTER));
		jp.add(add_template);
		PromptSupport.setPrompt("addTemplate.ftl", add_template);
		jp.add(new JLabel("edit模板文件:", SwingConstants.CENTER));
		jp.add(edit_template);
		PromptSupport.setPrompt("editTemplate.ftl", edit_template);
		
		
		// 广告位
		jp.add(new JLabel("----------------------------", SwingConstants.CENTER));
		jp.add(new JLabel("----------------------------", SwingConstants.CENTER));

		confirmbtn = new JButton("一键生成");
		confirmbtn.addActionListener(this);
		extbtn = new JButton("退出");
		extbtn.addActionListener(this);
		jp.add(confirmbtn);
		jp.add(extbtn);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == extbtn) {
			this.dispose();
			System.exit(0);
		} else if (e.getSource() == confirmbtn) {
			try {
				Class.forName(jdbc_driver.getText());
				conn = DriverManager.getConnection(jdbc_url.getText() + "?useUnicode=true&characterEncoding=UTF-8",
						jdbc_username.getText(), jdbc_password.getText());
				if (conn != null) {
					if (!"".equals(package_name.getText())) {
						entityPackage = package_name.getText();
					} else {
						lbshow.setForeground(Color.red);
						lbshow.setText("包名不能为空");
						return;
					}
					if (!"".equals(source_root_package.getText())) {
						rootpackage = source_root_package.getText();
					} else {
						lbshow.setForeground(Color.red);
						lbshow.setText("src根包不能为空");
						return;
					}
					if (!"".equals(webroot_package.getText())) {
						webrootpackage = webroot_package.getText();
					} else {
						lbshow.setForeground(Color.red);
						lbshow.setText("WEB根目录不能为空");
						return;
					}
					if (!"".equals(bussi_package.getText())) {
						diypackage = bussi_package.getText();
					} else {
						lbshow.setForeground(Color.red);
						lbshow.setText("自定义包不能为空");
						return;
					}
					if (!"".equals(template_path.getText())) {
						templatepath = template_path.getText();
					} else {
						lbshow.setForeground(Color.red);
						lbshow.setText("模板目录不能为空");
						return;
					}
					if (!"".equals(entity_name.getText())) {
						entityName = entity_name.getText();
					} else {
						lbshow.setForeground(Color.red);
						lbshow.setText("实体类名不能为空");
						return;
					}
					if (!"".equals(table_desc.getText())) {
						description = table_desc.getText();
					} else {
						lbshow.setForeground(Color.red);
						lbshow.setText("功能描述不能为空");
						return;
					}
					if (!"".equals(table_name.getText())) {
						tableName = table_name.getText();
						String sql = "show tables like " + "\'" + tableName + "\'";
						Statement stat;
						try {
							stat = conn.createStatement();
							ResultSet rs = stat.executeQuery(sql);
							if (rs.next()) {
							} else {
								lbshow.setForeground(Color.red);
								lbshow.setText("表名不存在");
								return;
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
						lbshow.setForeground(Color.red);
						lbshow.setText("表名不能为空");
						return;
					}
					try {
						DatabaseMetaData dbmd = conn.getMetaData();
						ResultSet resultSet = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });
						while (resultSet.next()) {
							String tableName1 = resultSet.getString("TABLE_NAME");
							if (tableName1.equals(tableName)) {
								ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
								while (rs.next()) {
									Columnt columnt = new Columnt();
									columnt.setFieldName(rs.getString("COLUMN_NAME"));// 字段名称
									columnt.setFiledComment(rs.getString("REMARKS"));// 字段注释
									columnt.setFieldType(rs.getString("TYPE_NAME"));// 字段类型
									columnt.setNullable(rs.getString("NULLABLE"));// 是否为空
									columnt.setCharmaxLength(rs.getString("COLUMN_SIZE"));// 最大长度
									columns.add(columnt);
								}
								System.out.println("此表中共有：" + columns.size() + "字段");
							}
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					//---------------------------------------------
					//模板准备数据
					//============================================
					Map<String, Object> root = new HashMap<String, Object>();
					root.put("entityName", entityName);//实体类名称
					root.put("originalColumns", columns);//字段信息
					root.put("bussiPackage", diypackage);//根包
					root.put("entityPackage", entityPackage);//业务包
					root.put("ftl_description", description);//功能描述
					root.put("tableName", tableName);//表名称
					root.put("specialChar", "#");//特殊字符
					
					//-------------------------------------------------------
					//freemarker技术：代码生成器核心
					//===========================================================
					try {
						Configuration cfg = new Configuration();
						File tempPath = new File(templatepath);
						cfg.setDirectoryForTemplateLoading(tempPath);
						cfg.setObjectWrapper(new DefaultObjectWrapper());
						//模板文件
						Template tempcontroller = null;
						if(!controller_template.getText().equals("")){
							tempcontroller = cfg.getTemplate(controller_template.getText());// controller控制器
						}
						Template templist = null;
						if(!list_template.getText().equals("")){
							templist = cfg.getTemplate(list_template.getText());// list页面文件
						}
						Template tempadd = null;
						if(!add_template.getText().equals("")){
							tempadd = cfg.getTemplate(add_template.getText());// add页面文件
						}
						Template tempedit = null;
						if(!edit_template.getText().equals("")){
							tempedit = cfg.getTemplate(edit_template.getText());// edit页面文件
						}

						//---------------------------------------------
						//模板生成：控制器controller
						//==============================================
						if(tempcontroller!=null){
							String actionFile = getJavaFilePath(rootpackage, diypackage, entityPackage, entityName,
									"Controller.java", "controller");
							Writer out = new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream(actionFile, false), "UTF-8"));
							tempcontroller.process(root, out);
							out.flush();
						}
						//---------------------------------------------
						//模板生成：list页面
						//==============================================
						if(templist!=null){
							String listFile = getFtlFilePath(webrootpackage, diypackage, entityPackage, "list");
							Writer outlist = new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream(listFile, false), "UTF-8"));
							templist.process(root, outlist);
							outlist.flush();
						}
						//---------------------------------------------
						//模板生成：add页面
						//==============================================
						if(tempadd!=null){
							String addFile = getFtlFilePath(webrootpackage, diypackage, entityPackage, "add");
							Writer outadd = new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream(addFile, false), "UTF-8"));
							templist.process(root, outadd);
							outadd.flush();
						}
						//---------------------------------------------
						//模板生成：edit页面
						//==============================================
						if(tempedit!=null){
							String editFile = getFtlFilePath(webrootpackage, diypackage, entityPackage, "edit");
							Writer outedit = new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream(editFile, false), "UTF-8"));
							tempedit.process(root, outedit);
							outedit.flush();
						}
						//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					} catch (Exception e4) {
						e4.printStackTrace();
						lbshow.setForeground(Color.red);
						lbshow.setText("有异常出现请查看控制台异常信息");
						return;
					}

					lbshow.setForeground(new Color(21, 200, 211));
					lbshow.setText("成功生成增删改查->功能:" + description + "刷新工程查看");
					//关闭
					//dispose();
				}
			} catch (ClassNotFoundException e1) {
				lbshow.setForeground(Color.red);
				lbshow.setText("MySQL数据库驱动包没有找到");
				e1.printStackTrace();
				return;
			} catch (SQLException e2) {
				lbshow.setForeground(Color.red);
				lbshow.setText("数据库连接信息填写有误");
				e2.printStackTrace();
				return;
			} finally {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	/**
	 * 返回文件全路径如：
	 * @param webrootpackage  WEB根路径
	 * @param diypackage	根包  : 不使用
	 * @param entityPackage		业务包
	 * @param entityName	实体类名
	 * @return
	 */
	public static String getFtlFilePath(String webrootpackage, String diypackage, String entityPackage,
			String entityName) {
		String filePath = "";
		char[] chars = new char[1];
		chars[0] = entityName.charAt(0);
		String temp = new String(chars);
		if (chars[0] >= 'A' && chars[0] <= 'Z') {// 当为字母时则转换为小写
			entityName = entityName.replaceFirst(temp, temp.toLowerCase());
		}
		filePath = System.getProperty("user.dir").replace("\\", "/") + "/" + webrootpackage + "/"
				+ "/" + entityPackage + "/" + entityName + ".ftl";
		File file = new File(filePath);
		if (file.exists()) {// 如果文件存在

		} else {// 否则创建目录和创建文件
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "创建文件失败");
			}
		}

		return filePath;
	}

	/**
	 * 返回文件全路径如：
	 * @param srcrootpackage  源代码根路径
	 * @param diypackage	根包
	 * @param entityPackage		业务包
	 * @param entityName	实体类名
	 * @param suffix	后缀
	 * @param varpackage  功能包如service,dao
	 * @return
	 */
	public static String getJavaFilePath(String srcrootpackage, String diypackage, String entityPackage,
			String entityName, String suffix, String varpackage) {
		String javaFilePath = "";
		javaFilePath = System.getProperty("user.dir").replace("\\", "/") + "/" + srcrootpackage + "/"
				+ diypackage.replace(".", "/") + "/" + varpackage + "/" + entityPackage + "/" + entityName + suffix;
		File file = new File(javaFilePath);
		if (file.exists()) {
			// 如果文件存在  不处理
		} else {
			// 否则创建目录和创建文件
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "创建文件失败");
			}
		}
		return javaFilePath;
	}
}
