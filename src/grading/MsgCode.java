package grading;



/**
 * 错误代码与错误消息的对应，可以详细查询错误种类与具体代码；
 * @author Zhengwen 
 * @date 31 Dec, 2014
 * @version Grading 3.0 Builder	0009
 */
public final class MsgCode {
	
	public static int 	BACK_CODE				= -1000;			//输入的答案是错误的；
	public static int 	CORRECT_NUM 			= 0;				//输入的答案是正确的；
	

	public static int	SPEAC_CHAR				= -3010;			//非法空格；
	public static int	ILLEGAL_CHARS			= -3012;			//非法字符；
	public static int	REDUNDANCY_ZERO			= -3013;			//多余的“零”（冗余）；
	
	public static int 	INVALID_FORMAT			= -3504;			//残缺的格式(或标签不完整)；
	public static int 	REDUNDANCY_TAG 			= -3506;			//多余标签；
	
	
	
	public static int 	ISEMPTY					= -6100;
	public static int 	UNKOWN_ERROR			= -6600;			//未知的错误，此信息备用；
	public static int 	CONFIG_ERROR 			= -6610;			//设定'比较条件'时出错误；详细：config.setconfigmap();
	public static int 	TRANS_FAIL				= -6620;			//运行必要变换时出现错误；详细：Inspector.needful()
	
	
	public static int 	ANSWER_ERR				= -6800;			//正确答案无法有效转换为 DOM 对象；
	public static int 	INPUT_ERR				= -6900;			//用户输入无法有效转换为 DOM 对象；
	
	
	
	
}
