package template;

/**
 * 映射某表字段信息
 * 对应生成实体对象
 * @author Administrator
 *
 */
public class Columnt {

	/**
	 * 字段数据库名称
	 */
	private String fieldDbName;
	/**
	 * 字段实体类名称（用到）
	 */
	private String fieldName;
	/**
	 * 字段注释（用到）
	 */
	private String filedComment = "";
	/**
	 * 字段类型（用到）
	 */
	private String fieldType = "";
	/**
	 * 类类型
	 */
	private String classType = "";
	/**
	 * 
	 */
	private String classType_row = "";
	/**
	 * 操作类型
	 */
	private String optionType = "";
	/**
	 * 最大长度（用到）
	 */
	private String charmaxLength = "";
	/**
	 * 字段长度（精度）
	 */
	private String precision;
	/**
	 * 小数位数（范围）
	 */
	private String scale;
	/**
	 * 是否允许为空（用到）
	 */
	private String nullable;
	
	public String getFieldDbName() {
		return fieldDbName;
	}
	public void setFieldDbName(String fieldDbName) {
		this.fieldDbName = fieldDbName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFiledComment() {
		return filedComment;
	}
	public void setFiledComment(String filedComment) {
		this.filedComment = filedComment;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getClassType_row() {
		return classType_row;
	}
	public void setClassType_row(String classType_row) {
		this.classType_row = classType_row;
	}
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	public String getCharmaxLength() {
		return charmaxLength;
	}
	public void setCharmaxLength(String charmaxLength) {
		this.charmaxLength = charmaxLength;
	}
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getNullable() {
		return nullable;
	}
	public void setNullable(String nullable) {
		this.nullable = nullable;
	}
	
	
	
}
