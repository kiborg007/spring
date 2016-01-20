<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.roman.service.PersonServiceImpl" %>
<%@page import="java.util.List" %>
<%@page import="com.roman.model.Person" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="personService" class="com.roman.service.PersonServiceImpl" scope="request"></jsp:useBean>

<c:set var="listPersons" value="${PersonServiceImpl.get }"></c:set>