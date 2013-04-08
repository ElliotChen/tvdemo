run "mvn -Pquick,${profile} package"

maven :
(1)使用profile,區分不同環境的設定檔案
(2)使用dependencyManagement管理library的版本
(3)

Logging:
(1)slf4j+logback are better than commons-logging+log4j
	slf4j syntex:logger.debug("Find user:{} by id:{}", user, id);
	logback appender:
(2)JMX: control logging level via JMX

Hibernate:
(1)hibernate.hbm2ddl.auto:create-drop, create, update, check, production應去除這個設定
(2)JMX: control cache release.
(3)Create, SaveOrUpdate, Merge

Struts2:
(1)Type Converter : xwork-conversion.properties
(2)Preparable, ModelDriven : BaseCrudAction
(3)Interceptor Stack.
(4)General Config -- 
		<action name="*!*" method="{2}" class="{1}Action">
	        <result name="index">/WEB-INF/jsp/admin/{1}/index.jsp</result>
	        <result name="create">/WEB-INF/jsp/admin/{1}/create.jsp</result>
	        <result name="edit">/WEB-INF/jsp/admin/{1}/edit.jsp</result>
	    </action>

Spring:
(1)務必瞭解OpenSessionInViewFilter的影響

Concept:
(1)Base flow : View -> Action(Controllor) -> Service(Manager) -> Dao
(2)Entity = Domain Model = Model (there is no business logic ... )
(3)商業邏輯
	(3－1)Dao 不含任何商業邏輯，甚至連邏輯都不該有
	(3－2)商業邏輯應全部在Server(Manager)裡
	(3－3)Action除了資料格式的處理外，也不含任何商業邏輯

Testing:
(1)Action中不該出現Session, HttpRequest, HttpResponse