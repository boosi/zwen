package autogrd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.*;



/**
 * 专门处理正则表达式的相关检查；<br/>
 * 全部为静态函数；不能继承；
 * @author Zhengwen 
 * @date 19 Dec, 2014
 * @version Grading 3.0 Builder 008
 */
public final class RegularReview {

	
	
	
	/**
	 * 规范字符串，使得该字符串仅有唯一形式；
	 * @param instr		源字串；
	 * @return			返回规范的字串；
	 */
	static int formater(String instr) {
		String 	rex;
		Matcher mat;
		
		rex = "(?i)<math[^>]*>(.+)</math>";									// Math 标签不配对；
		mat = Pattern.compile(rex).matcher(instr);
			while (!mat.find())
				return -3502;
			if (mat.group(1).indexOf("<math") >= 0 || mat.group(1).indexOf("</math>") >= 0)
				return -3504;												// 多余的 Math 标签； 新增 3504： 多余的标签；
		
		rex = "(?i)(&#160;)";												// 空格检查； 
		mat = Pattern.compile(rex).matcher(instr);
			while (mat.find())
				return -3010;
		
		//{bgn 括弧；	
		Matcher mL = Pattern.compile("\\(").matcher(instr), 
				mR = Pattern.compile("\\)").matcher(instr);
		int		nL = 0,
				nR = 0;
				while (mL.find())
					nL++;	//计数；
				while (mR.find())
					nR++;
				if (nL != nR)
					return -6100;
			
			mL = Pattern.compile("\\{").matcher(instr);
			mR = Pattern.compile("\\}").matcher(instr);
			nL = 0;
			nR = 0;
				while (mL.find())
					nL++;
				while (mR.find())
					nR++;
				if (nL != nR)
					return -6100;	
				
			mL = Pattern.compile("\\|").matcher(instr);
				while (mL.find())
					nL++;	//计数；
				if (nL % 2 != 0)
					return -6100;
		//}end	
			
		
		//{bgn 	格式检查；		
		rex = "(?i)<mfrac[^>]*>(.+)</mfrac>";						//分式；
		mat = Pattern.compile(rex).matcher(instr);
			while (mat.find()) {
				String tmp = mat.group(1);
				out.println("tmp=\t" + tmp);
			}
				
				
		//}end
			
		//--------------------------
		
		//{bgn 
		/**
		mis = wdt.getListByName("mfenced"); 							// 括号、绝对值、花括弧等内容为空（软键盘）；
		it = mis.iterator();
		while (it.hasNext()) {
			Node nd = it.next();
			if (nd.getTextContent().equals("")) {
				return -3502;
			}
		}

		mis = wdt.getListByName("msup");
		it = mis.iterator(); 											// 分式缺少项目；
		while (it.hasNext()) {
			Node nd = it.next();
			if (nd.getFirstChild().getTextContent().equals("")
					|| nd.getLastChild().getTextContent().equals("")) {
				return -3502;
			}
		}

		mis = wdt.getListByName("msqrt");
		it = mis.iterator(); 											// 根号内缺少项目；
		while (it.hasNext()) {
			Node nd = it.next();
			if (nd == null || nd.getTextContent().equals("")) {
				return -3502;
			}
		}

		mis = wdt.getListByName("mroot"); 								// 根号内缺少项目；
		it = mis.iterator();
		while (it.hasNext()) {
			Node nd = it.next();
			if (nd == null || nd.getFirstChild().getTextContent().equals("")
					|| nd.getLastChild().getTextContent().equals("")) {
				return -3502;
			}
		}

		mis = wdt.getListByName("mfrac");
		it = mis.iterator(); 											// 分式缺少项目；
		while (it.hasNext()) {
			Node nd = it.next();
			if (nd.getFirstChild().getTextContent().equals("")
					|| nd.getLastChild().getTextContent().equals("")) {
				return -3502;
			}
		}

		mis = wdt.getListByName("mover"); 								// 顶标缺少项目；
		it = mis.iterator();
		while (it.hasNext()) {
			Node nd = it.next();
			if (nd == null || nd.getFirstChild() == null
					|| nd.getFirstChild().getTextContent().equals("")) {
				return -3502;
			}
		}

		mis = wdt.getListByName("mtable"); 								// 矩阵缺少项目；
		it = mis.iterator();
		while (it.hasNext()) {
			Node nd = it.next();
			num1 = nd.getChildNodes().getLength();
			num2 = 0;
			for (int i = 0; i < num1; i++) {
				if (nd.getChildNodes().item(i).getChildNodes().getLength() > num2) {
					num2 = nd.getChildNodes().item(i).getChildNodes()
							.getLength();
				}
			}
			for (int i = 0; i < num1; i++) {
				for (int j = 0; j < num2; j++) {
					if (nd.getChildNodes().item(i).getChildNodes().item(j) == null
							|| nd.getChildNodes().item(i).getChildNodes()
									.item(j).getTextContent().equals("")) {
						return -3502;
					}
				}
			}
		}
		**/
		//}end
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
