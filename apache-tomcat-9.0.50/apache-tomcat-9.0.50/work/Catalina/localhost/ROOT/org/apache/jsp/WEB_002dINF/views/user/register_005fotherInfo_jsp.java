/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.50
 * Generated at: 2021-08-05 08:33:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_005fotherInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1614961976342L));
    _jspx_dependants.put("jar:file:/D:/PersonalProject_Spring/apache-tomcat-9.0.50/apache-tomcat-9.0.50/wtpwebapps/EasyResearch/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>회원 정보 입력 페이지</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"icon\" type=\"image/x-icon\" href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" />\r\n");
      out.write("\r\n");
      out.write("<!-- Core theme CSS (includes Bootstrap)-->\r\n");
      out.write("<link href=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#rightColumn{\r\n");
      out.write("	width: 90%;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/header.jsp", out, false);
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<p>\r\n");
      out.write("		<h2>회원가입 정보를 입력해주세요.</h2>\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("		<form method=\"post\" name=\"reg_form\" action=\"/user/register_otherInfo\">\r\n");
      out.write("			<table>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>회원분류</td>\r\n");
      out.write("					<td id=\"rightColumn\">\r\n");
      out.write("						<input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${umvo.sort}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" disabled>\r\n");
      out.write("						<input type=\"hidden\" name=\"userType\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${umvo.sort}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>학번 / 교번</td>\r\n");
      out.write("					<td id=\"rightColumn\">\r\n");
      out.write("						<input style=\"width:60%;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${umvo.idNumber}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" disabled>\r\n");
      out.write("						<input type=\"hidden\" name=\"univIdNum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${umvo.idNumber}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>이름</td>\r\n");
      out.write("					<td id=\"rightColumn\">\r\n");
      out.write("						<input style=\"width:60%;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${umvo.registeredName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" disabled>\r\n");
      out.write("						<input type=\"hidden\" name=\"userName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${umvo.registeredName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>학교 이메일</td>\r\n");
      out.write("					<td id=\"rightColumn\">\r\n");
      out.write("						<input style=\"width:60%;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${umvo.univEmail}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" disabled>\r\n");
      out.write("						<input type=\"hidden\" name=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${umvo.univEmail}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>아이디</td>\r\n");
      out.write("					<td id=\"rightColumn\">\r\n");
      out.write("						<input style=\"width:60%;\" type=\"text\" name=\"userId\" id=\"user_id\" placeholder=\"아이디를 6자 ~ 14자의 영문대소문자와 숫자로 입력하세요.\"> &nbsp; &nbsp;\r\n");
      out.write("						<input type=\"button\" id=\"idCheck\" value=\"아이디 중복체크\" disabled>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td colspan=\"2\">\r\n");
      out.write("						<div><span id=\"idChk\"></span></div>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>비밀번호</td>\r\n");
      out.write("					<td id=\"rightColumn\">\r\n");
      out.write("						<input style=\"width:60%;\"  type=\"password\" name=\"userPw\" id=\"user_pw\" placeholder=\"비밀번호를 입력하세요. 8자 ~ 20자, 영문, 숫자, 특수문자 조합\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td colspan=\"2\">\r\n");
      out.write("						<div><span id=\"pwChk\"></span></div>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>비밀번호 확인</td>\r\n");
      out.write("					<td id=\"rightColumn\">\r\n");
      out.write("						<input style=\"width:60%;\" type=\"password\" id=\"pw_again\" placeholder=\"위의 비밀번호와 똑같이 입력해주세요.\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td colspan=\"2\">\r\n");
      out.write("						<div><span id=\"pwAgainChk\"></span></div>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td colspan=\"2\">\r\n");
      out.write("						<div><span id=\"idNumChk\"></span></div>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>휴대폰 번호</td>\r\n");
      out.write("					<td id=\"rightColumn\">\r\n");
      out.write("						<input style=\"width:60%;\" type=\"text\" name=\"tel\" id=\"user_phoneNum\" placeholder=\" - 없이 숫자만 입력해주세요.\"> &nbsp; &nbsp;\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td colspan=\"2\">\r\n");
      out.write("						<div><span id=\"phoneNumChk\"></span></div>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td colspan=\"2\">\r\n");
      out.write("						<input type=\"button\" id=\"finalRegi\" value=\"회원가입\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("		</form>\r\n");
      out.write("		</p>\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("	$(function() { // 검증 함수 시작\r\n");
      out.write("		\r\n");
      out.write("		const getIdCheck = RegExp(/^[a-zA-z0-9]{6,14}$/); // 따옴표(/), 적용 시작(^), 적용 끝($), [허용되는 것: 영문 대소문자 & 숫자, 띄어쓰기 불가능]{최소, 최대}\r\n");
      out.write("		\r\n");
      out.write("		const getPwCheck = RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,_,~])|([!,@,#,$,%,^,&,*,_,~].*[a-zA-Z0-9]){8,20}/); // a.(a로 시작하는 것들) .n(n으로 끝나는 것들) / *(반복가능), \r\n");
      out.write("		// 영문 대소문자 & 숫자 포함한 걸로 시작(.), 반복 가능(*), 특수문자 포함해야함.\r\n");
      out.write("		\r\n");
      out.write("		const getPhoneNumCheck = RegExp(/^[0-9]{11}$/); // 00000000000 형태만 가능\r\n");
      out.write("		\r\n");
      out.write("		let chk1 = false, chk2 = false, chk3 = false;\r\n");
      out.write("		// chk1: 아이디 체크, chk2: 비밀번호 체크, chk3: 휴대폰 번호 체크\r\n");
      out.write("		\r\n");
      out.write("		const idCheckBtn = document.getElementById('idCheck');\r\n");
      out.write("		\r\n");
      out.write("		$(\"#user_id\").keyup(function() { // ID 입력값 검증\r\n");
      out.write("			if($(\"#user_id\").val() === \"\"){\r\n");
      out.write("				$(\"#user_id\").css(\"background-color\",\"pink\");\r\n");
      out.write("				$(\"#idChk\").html(\"<b style='font-size: 14px; color: red;'>아이디는 필수 정보입니다.</b>\");\r\n");
      out.write("				idCheckBtn.disabled = true;\r\n");
      out.write("				chk1 = false;\r\n");
      out.write("			}\r\n");
      out.write("			else if(!getIdCheck.test($(\"#user_id\").val())){\r\n");
      out.write("				$(\"#user_id\").css(\"background-color\",\"pink\");\r\n");
      out.write("				$(\"#idChk\").html(\"<b style='font-size: 14px; color: red;'>아이디는 6 ~ 14자의 영문대소문자와 숫자로만 이뤄져야하고 공백이 없어야 합니다.</b>\");\r\n");
      out.write("				idCheckBtn.disabled = true;\r\n");
      out.write("				chk1 = false;\r\n");
      out.write("			} else {\r\n");
      out.write("				$(\"#user_id\").css(\"background-color\",\"white\");\r\n");
      out.write("				$(\"#idChk\").html(\"<b style='font-size: 14px; color: green;'>조건 만족. 중복 체크를 완료하세요 :) </b>\");\r\n");
      out.write("				idCheckBtn.disabled = false;\r\n");
      out.write("				$(\"#idCheck\").click(function() { // id 중복확인\r\n");
      out.write("					\r\n");
      out.write("					$.ajax({ \r\n");
      out.write("						type: \"POST\",\r\n");
      out.write("						url: \"/user/checkId\",\r\n");
      out.write("						data: {\r\n");
      out.write("							id : $(\"#user_id\").val()\r\n");
      out.write("						},\r\n");
      out.write("						success: function(result) {\r\n");
      out.write("							console.log(\"통신 성공!: \" + result);\r\n");
      out.write("							if(result === \"OK\"){\r\n");
      out.write("								$(\"#user_id\").css(\"background-color\", \"skyblue\");\r\n");
      out.write("								$(\"#idChk\").html(\"<b style='font-size: 14px; color: green;'>사용 가능한 아이디입니다.</b>\");\r\n");
      out.write("								chk1 = true;\r\n");
      out.write("							}\r\n");
      out.write("							else {\r\n");
      out.write("								$(\"#user_id\").css(\"background-color\", \"pink\");\r\n");
      out.write("								$(\"#idChk\").html(\"<b style='font-size: 14px; color: red;'>이미 사용중인 아이디입니다.</b>\");\r\n");
      out.write("								chk1 = false;\r\n");
      out.write("							}\r\n");
      out.write("						},\r\n");
      out.write("						error: function() {\r\n");
      out.write("							console.log(\"통신 실패!\");\r\n");
      out.write("						}\r\n");
      out.write("						\r\n");
      out.write("					}); // ajax\r\n");
      out.write("				})// id 중복확인\r\n");
      out.write("				\r\n");
      out.write("			} // else\r\n");
      out.write("		}) // ID 입력값 검증\r\n");
      out.write("		\r\n");
      out.write("		////////////////////////////////////////////////////////\r\n");
      out.write("		\r\n");
      out.write("		$(\"#user_pw\").keyup(function() { // 비밀번호 입력값 검증\r\n");
      out.write("			\r\n");
      out.write("			if($(\"#user_pw\").val() === \"\"){\r\n");
      out.write("				$(\"#user_pw\").css(\"background-color\", \"pink\");\r\n");
      out.write("				$(\"#pwChk\").html(\"<b style='font-size: 14px; color: red;'>비밀번호는 필수 입력사항입니다.</b>\");\r\n");
      out.write("				chk2 = false;\r\n");
      out.write("			} \r\n");
      out.write("			else if(!getPwCheck.test($(\"#user_pw\").val())){\r\n");
      out.write("				$(\"#user_pw\").css(\"background-color\",\"pink\");\r\n");
      out.write("				$(\"#pwChk\").html(\"<b style='font-size: 14px; color: red;'>비밀번호는 8 ~ 20자의 영문대소문자와 특수문자의 조합이 필수입니다.</b>\");\r\n");
      out.write("				chk2 = false;\r\n");
      out.write("			}\r\n");
      out.write("			else {\r\n");
      out.write("				$(\"#user_pw\").css(\"background-color\",\"white\");\r\n");
      out.write("				$(\"#pwChk\").html(\"<b style='font-size: 14px; color: green;'>조건 만족. 아래에 비밀번호를 한 번 더 입력해주세요 :) </b>\");\r\n");
      out.write("				\r\n");
      out.write("				$(\"#pw_again\").keyup(function() { // 비밀번호 확인란\r\n");
      out.write("					if($(\"#pw_again\").val() === \"\"){\r\n");
      out.write("						$(\"#pw_again\").css(\"background-color\", \"pink\");\r\n");
      out.write("						$(\"#pwAgainChk\").html(\"<b style='font-size: 14px; color: red;'>비밀번호 재입력은 필수 입력사항입니다.</b>\");\r\n");
      out.write("						chk2 = false;\r\n");
      out.write("					} \r\n");
      out.write("					else if($(\"#pw_again\").val() != $(\"#user_pw\").val()){\r\n");
      out.write("						$(\"#pw_again\").css(\"background-color\", \"pink\");\r\n");
      out.write("						$(\"#pwAgainChk\").html(\"<b style='font-size: 14px; color: red;'>위의 비밀번호와 불일치합니다.</b>\");\r\n");
      out.write("						chk2 = false;\r\n");
      out.write("					}\r\n");
      out.write("					else{\r\n");
      out.write("						$(\"#user_pw\").css(\"background-color\", \"skyblue\");\r\n");
      out.write("						$(\"#pw_again\").css(\"background-color\", \"skyblue\");\r\n");
      out.write("						$(\"#pwAgainChk\").html(\"<b style='font-size: 14px; color: green;'>비밀번호 확인 완료.</b>\");\r\n");
      out.write("						chk2 = true;\r\n");
      out.write("					}\r\n");
      out.write("				})// 비밀번호 확인란\r\n");
      out.write("				\r\n");
      out.write("			}\r\n");
      out.write("				\r\n");
      out.write("				\r\n");
      out.write("		})// 비밀번호 입력값 검증\r\n");
      out.write("		\r\n");
      out.write("		//////////////////////////////////////////\r\n");
      out.write("		\r\n");
      out.write("		$(\"#user_phoneNum\").keyup(function() { // 휴대폰 번호 입력값 검증 + 인증번호 보내고 인증하는거 추가해보기\r\n");
      out.write("			if($(\"#user_phoneNum\").val() === \"\"){\r\n");
      out.write("				$(\"#user_phoneNum\").css(\"background-color\", \"pink\");\r\n");
      out.write("				$(\"#phoneNumChk\").html(\"<b style='font-size: 14px; color: red;'>휴대폰 번호는 필수 입력 값입니다.</b>\");\r\n");
      out.write("				chk3 = false;\r\n");
      out.write("			} \r\n");
      out.write("			else if(!getPhoneNumCheck.test($(\"#user_phoneNum\").val())){\r\n");
      out.write("				$(\"#user_phoneNum\").css(\"background-color\", \"pink\");\r\n");
      out.write("				$(\"#phoneNumChk\").html(\"<b style='font-size: 14px; color: red;'>11자리의 숫자만 입력해주세요.</b>\");\r\n");
      out.write("				chk3 = false;\r\n");
      out.write("			}\r\n");
      out.write("			else {\r\n");
      out.write("				$(\"#user_phoneNum\").css(\"background-color\", \"skyblue\");\r\n");
      out.write("				$(\"#phoneNumChk\").html(\"<b style='font-size: 14px; color: green;'>조건 만족.</b>\");\r\n");
      out.write("				chk3 = true;\r\n");
      out.write("			}\r\n");
      out.write("		})// 휴대폰 번호 입력값 검증\r\n");
      out.write("		\r\n");
      out.write("		$(\"#finalRegi\").click(function() {\r\n");
      out.write("			if(!chk1){\r\n");
      out.write("				console.log(\"id문제\");\r\n");
      out.write("				alert(\"아이디 입력란에 문제가 있습니다.\");\r\n");
      out.write("				reg_form.userId.focus();\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("			else if(!chk2){\r\n");
      out.write("				console.log(\"pw문제\");\r\n");
      out.write("				alert(\"비밀번호나 비밀번호 확인란에 문제가 있습니다.\");\r\n");
      out.write("				reg_form.userPw.focus();\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("			else if(!chk3){\r\n");
      out.write("				console.log(\"phone문제\");\r\n");
      out.write("				alert(\"휴대폰 번호 입력란에 문제가 있습니다.\");\r\n");
      out.write("				reg_form.tel.focus();\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("			else{\r\n");
      out.write("				if(confirm(\"회원가입 하시겠습니까?\")){ // 확인 누르면\r\n");
      out.write("					console.log(\"회원 가입 승인\");\r\n");
      out.write("					reg_form.submit();\r\n");
      out.write("				} else { // 취소 누르면\r\n");
      out.write("					console.log(\"회원 가입 취소\");\r\n");
      out.write("					return;\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("	}) // 검증 함수 끝\r\n");
      out.write("	\r\n");
      out.write("</script>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f0_reused = false;
    try {
      _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f0.setParent(null);
      // /WEB-INF/views/user/register_otherInfo.jsp(10,43) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setValue("/assets/favicon.ico");
      int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
      if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      _jspx_th_c_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f1_reused = false;
    try {
      _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f1.setParent(null);
      // /WEB-INF/views/user/register_otherInfo.jsp(13,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f1.setValue("/css/styles.css");
      int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
      if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      _jspx_th_c_005furl_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f1, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f2_reused = false;
    try {
      _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f2.setParent(null);
      // /WEB-INF/views/user/register_otherInfo.jsp(14,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f2.setValue("/js/jquery-3.5.1.js");
      int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
      if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      _jspx_th_c_005furl_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f2, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/user/register_otherInfo.jsp(101,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${umvo.sort!='강사'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("					<tr>\r\n");
          out.write("						<td>전공</td>\r\n");
          out.write("						<td id=\"rightColumn\">\r\n");
          out.write("							<input style=\"width:60%;\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${umvo.major}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" disabled>\r\n");
          out.write("							<input type=\"hidden\" name=\"major\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${umvo.major}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("						</td>\r\n");
          out.write("					</tr>\r\n");
          out.write("				");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}
