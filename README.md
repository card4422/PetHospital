#Readme
##环境介绍
* **集成开发环境**:IDEA
* **版本控制工具**:[GitHub](https://github.com/card4422/PetHospital)
* **包管理工具**:Maven 3.3.4:[Reporsitory](http://mvnrepository.com)
* **内部服务器**:Tomcat 7.0
* **JDK**:1.7

##使用说明
###后台服务器端口:
	http://localhost:8080

###前端服务器端口:
	http://localhost:3000
##基本框架
使用了**Spring**+**SpringMVC**+**Hibernate**框架进行系统的开发

* **Spring**:
* **SpringMVC**:是一个较为成熟的*Model*-*View*-*Control*框架，主要解决以下几部分问题:	
	1. 将web页面中的输入元素封装为一个（请求）数据对象
	2. 根据请求的不同，调度相应的逻辑处理单元，并将（请求）数据对象作为参数传入。
	3. 逻辑处理单元完成运算后，返回一个数据对象。
	4. 将结果数据对象中的数据与预先设计的表现层相融合并展现给	用户。
* **Hibernate**:

##包设计说明
###Entity
###Dao
###Service

##数据表设计
* 用户user

属性名     | 备注
-----------|----------------
id         | pk,ai
user_name  | pk
user_pwd   | 0普通用户;1管理员

* 科室room

属性名|备注
-----|----
id|pk,ai
room_name|

