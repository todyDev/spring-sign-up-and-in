<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div class="header">
            <nav>
               <ul class="nav nav-pills pull-right">
                  <c:catch>
                     <c:choose>
                         <c:when test="${empty authInfo }">
                            <ul class="nav nav-pills pull-right">
                               <li role="presentation"><a href="${pageContext.request.contextPath }/signin">Sign in</a></li>
                               <li role="presentation"><a href="${pageContext.request.contextPath }/signup/step1">Sign up</a></li>
                            </ul>
                         </c:when>
                         <c:otherwise>
                            <c:choose>
                               <c:when test="${authInfo.grade eq 1 }">
                                  <ul class="nav nav-pills pull-right">
                                     <li role="presentation"><a href="#">관리자 ${authInfo.name }님, 안녕하세요.</a></li>
                                     <li role="presentation"><a href="${pageContext.request.contextPath }/signout">Sign out</a></li>
                                  </ul>                            
                               </c:when>
                               <c:otherwise>
                                  <ul class="nav nav-pills pull-right">
                                     <li role="presentation"><a href="#">${authInfo.name }님, 반갑습니다.</a></li>
                                     <li role="presentation"><a href="${pageContext.request.contextPath }/signout">Sign out</a></li>
                                  </ul>          
                               </c:otherwise>
                            </c:choose>
                            <c:when test="${authInfo.grade eq '1' }">
                               <ul class="nav nav-pills pull-right">
                                  <li role="presentation"><a href="#">관리자 ${authInfo.name }님, 안녕하세요.</a></li>
                                  <li role="presentation"><a href="${pageContext.request.contextPath }/signout">Sign out</a></li>
                               </ul>                            
                            </c:when>
                            <c:otherwise>
                               <ul class="nav nav-pills pull-right">
                                  <li role="presentation"><a href="#">${authInfo.name }님, 반갑습니다.</a></li>
                                  <li role="presentation"><a href="${pageContext.request.contextPath }/signout">Sign out</a></li>
                               </ul>          
                            </c:otherwise>
                         </c:otherwise>
                     </c:choose>
                  </c:catch>
               </ul>
            </nav>
            

            <h3 class="text-muted"><b>tody</b>Dev</h3>
        </div>